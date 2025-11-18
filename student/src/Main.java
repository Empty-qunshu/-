// Main.java （简单控制台界面）

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final String DATA_FILE = "data.ser";

    public static void main(String[] args) {
        ClassroomManager mgr;
        try {
            mgr = ClassroomManager.loadFromFile(DATA_FILE);
            System.out.println("已加载数据文件：" + DATA_FILE);
        } catch (Exception e) {
            mgr = new ClassroomManager();
            System.out.println("未找到数据文件，使用空数据初始化。");
        }

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n==== 教室资源管理系统 ====");
            System.out.println("1. 添加教室 2. 修改教室 3. 删除教室 4. 按编号查询");
            System.out.println("5. 按容量区间查询 6. 分类统计 7. 排行榜(topK) 8. 导出CSV");
            System.out.println("9. 保存并退出 0. 退出（不保存）");
            System.out.print("请选择：");
            int cmd = Integer.parseInt(sc.nextLine());
            try {
                if (cmd == 1) {
                    System.out.print("id:");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("name:");
                    String name = sc.nextLine();
                    System.out.print("category:");
                    String cat = sc.nextLine();
                    System.out.print("capacity:");
                    int cap = Integer.parseInt(sc.nextLine());
                    System.out.print("floor:");
                    int floor = Integer.parseInt(sc.nextLine());
                    System.out.print("hasProjector(true/false):");
                    boolean p = Boolean.parseBoolean(sc.nextLine());
                    System.out.print("available(true/false):");
                    boolean a = Boolean.parseBoolean(sc.nextLine());
                    boolean ok = mgr.add(new Classroom(id, name, cat, cap, floor, p, a));
                    System.out.println(ok ? "添加成功" : "添加失败（id已存在）");
                } else if (cmd == 2) {
                    System.out.print("修改 id:");
                    int id = Integer.parseInt(sc.nextLine());
                    Classroom old = mgr.getById(id);
                    if (old == null) {
                        System.out.println("未找到");
                        continue;
                    }
                    System.out.print("new name (空保留):");
                    String name = sc.nextLine();
                    if (!name.isEmpty()) old.setName(name);
                    System.out.print("new category (空保留):");
                    String cat = sc.nextLine();
                    if (!cat.isEmpty()) old.setCategory(cat);
                    System.out.print("new capacity (空保留):");
                    String capStr = sc.nextLine();
                    if (!capStr.isEmpty()) old.setCapacity(Integer.parseInt(capStr));
                    System.out.print("new floor (空保留):");
                    String fStr = sc.nextLine();
                    if (!fStr.isEmpty()) old.setFloor(Integer.parseInt(fStr));
                    System.out.print("hasProjector (true/false 空保留):");
                    String pStr = sc.nextLine();
                    if (!pStr.isEmpty()) old.setHasProjector(Boolean.parseBoolean(pStr));
                    System.out.print("available (true/false 空保留):");
                    String aStr = sc.nextLine();
                    if (!aStr.isEmpty()) old.setAvailable(Boolean.parseBoolean(aStr));
                    boolean ok = mgr.update(old);
                    System.out.println(ok ? "修改成功" : "修改失败");
                } else if (cmd == 3) {
                    System.out.print("删除 id:");
                    int id = Integer.parseInt(sc.nextLine());
                    boolean ok = mgr.delete(id);
                    System.out.println(ok ? "删除成功" : "删除失败（未找到）");
                } else if (cmd == 4) {
                    System.out.print("查询 id:");
                    int id = Integer.parseInt(sc.nextLine());
                    Classroom c = mgr.getById(id);
                    System.out.println(c == null ? "未找到" : c);
                } else if (cmd == 5) {
                    System.out.print("low:");
                    int low = Integer.parseInt(sc.nextLine());
                    System.out.print("high:");
                    int high = Integer.parseInt(sc.nextLine());
                    System.out.print("asc(true) or desc(false):");
                    boolean asc = Boolean.parseBoolean(sc.nextLine());
                    List<Classroom> res = mgr.queryByCapacityRange(low, high, asc);
                    res.forEach(System.out::println);
                } else if (cmd == 6) {
                    Map<String, Integer> stats = mgr.categoryStats();
                    stats.forEach((k, v) -> System.out.println(k + " : " + v));
                } else if (cmd == 7) {
                    System.out.print("top k:");
                    int k = Integer.parseInt(sc.nextLine());
                    List<Classroom> top = mgr.topKByCapacity(k);
                    top.forEach(System.out::println);
                } else if (cmd == 8) {
                    System.out.print("csv path:");
                    String path = sc.nextLine();
                    mgr.exportCsv(path);
                    System.out.println("导出成功：" + path);
                } else if (cmd == 9) {
                    mgr.saveToFile(DATA_FILE);
                    System.out.println("已保存，退出。");
                    break;
                } else if (cmd == 0) {
                    System.out.println("退出（未保存）。");
                    break;
                } else {
                    System.out.println("无效命令");
                }
            } catch (Exception ex) {
                System.out.println("出错: " + ex.getMessage());
            }
        }
        sc.close();
    }
}
