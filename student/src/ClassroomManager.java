// ClassroomManager.java

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class ClassroomManager implements Serializable {
    private static final long serialVersionUID = 1L;

    // 主数据结构
    private Map<Integer, Classroom> idMap = new HashMap<>();
    private transient TreeMap<Integer, List<Classroom>> capacityIndex = new TreeMap<>();
    private Map<String, List<Classroom>> categoryMap = new HashMap<>();
    private List<Classroom> allList = new ArrayList<>();

    public ClassroomManager() {
        rebuildTransientIndexes();
    }

    // 在反序列化或首次加载后需重建 transient 索引
    private void rebuildTransientIndexes() {
        capacityIndex = new TreeMap<>();
        for (Classroom c : allList) {
            capacityIndex.computeIfAbsent(c.getCapacity(), k -> new ArrayList<>()).add(c);
        }
    }

    // 增加
    public boolean add(Classroom c) {
        if (idMap.containsKey(c.getId())) return false;
        idMap.put(c.getId(), c);
        allList.add(c);
        capacityIndex.computeIfAbsent(c.getCapacity(), k -> new ArrayList<>()).add(c);
        categoryMap.computeIfAbsent(c.getCategory(), k -> new ArrayList<>()).add(c);
        return true;
    }

    // 更新（以 id 为准）
    public boolean update(Classroom updated) {
        int id = updated.getId();
        Classroom old = idMap.get(id);
        if (old == null) return false;
        // remove old indexes
        allList.remove(old);
        List<Classroom> capList = capacityIndex.get(old.getCapacity());
        if (capList != null) capList.remove(old);
        List<Classroom> catList = categoryMap.get(old.getCategory());
        if (catList != null) catList.remove(old);

        // put updated
        idMap.put(id, updated);
        allList.add(updated);
        capacityIndex.computeIfAbsent(updated.getCapacity(), k -> new ArrayList<>()).add(updated);
        categoryMap.computeIfAbsent(updated.getCategory(), k -> new ArrayList<>()).add(updated);
        return true;
    }

    public boolean delete(int id) {
        Classroom c = idMap.remove(id);
        if (c == null) return false;
        allList.remove(c);
        List<Classroom> capList = capacityIndex.get(c.getCapacity());
        if (capList != null) capList.remove(c);
        List<Classroom> catList = categoryMap.get(c.getCategory());
        if (catList != null) catList.remove(c);
        return true;
    }

    // 按编号查询
    public Classroom getById(int id) {
        return idMap.get(id);
    }

    // 按 capacity 区间查询，asc=true 则升序
    public List<Classroom> queryByCapacityRange(int low, int high, boolean asc) {
        NavigableMap<Integer, List<Classroom>> sub = capacityIndex.subMap(low, true, high, true);
        List<Classroom> result = new ArrayList<>();
        for (Map.Entry<Integer, List<Classroom>> e : (asc ? sub.entrySet() : sub.descendingMap().entrySet())) {
            result.addAll(e.getValue());
        }
        // 若需要在相同 capacity 下进一步按 id 或 name 排序，可调整：
        result.sort(Comparator.comparingInt(Classroom::getCapacity).thenComparingInt(Classroom::getId));
        if (!asc) Collections.reverse(result);
        return result;
    }

    // 分类统计：返回每类数量
    public Map<String, Integer> categoryStats() {
        Map<String, Integer> stats = new HashMap<>();
        for (Map.Entry<String, List<Classroom>> e : categoryMap.entrySet()) {
            stats.put(e.getKey(), e.getValue().size());
        }
        return stats;
    }

    // 排行榜：按 capacity 取 top k（降序）
    public List<Classroom> topKByCapacity(int k) {
        return allList.stream()
                .sorted(Comparator.comparingInt(Classroom::getCapacity).reversed()
                        .thenComparingInt(Classroom::getId))
                .limit(k)
                .collect(Collectors.toList());
    }

    // 导出 CSV（简单实现）
    public void exportCsv(String path) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path))) {
            pw.println("id,name,category,capacity,floor,hasProjector,available");
            for (Classroom c : allList) {
                pw.printf("%d,%s,%s,%d,%d,%b,%b%n",
                        c.getId(), c.getName(), c.getCategory(), c.getCapacity(), c.getFloor(), c.isHasProjector(), c.isAvailable());
            }
        }
    }

    // 保存、加载（序列化）
    public void saveToFile(String filePath) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(this);
        }
    }

    public static ClassroomManager loadFromFile(String filePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            ClassroomManager mgr = (ClassroomManager) ois.readObject();
            mgr.rebuildTransientIndexes();
            // Also rebuild idMap from allList to be safe
            mgr.idMap = new HashMap<>();
            for (Classroom c : mgr.allList) mgr.idMap.put(c.getId(), c);
            return mgr;
        }
    }

    // 供调试输出
    public void printAll() {
        for (Classroom c : allList) {
            System.out.println(c);
        }
    }
}
