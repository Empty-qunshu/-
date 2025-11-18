// 日志条目类
class Log {
    String timestamp; // 时间戳
    String level;     // 日志级别
    String content;   // 日志内容

    public Log(String timestamp, String level, String content) {
        this.timestamp = timestamp;
        this.level = level;
        this.content = content;
    }

    @Override
    public String toString() {
        return "[" + timestamp + "][" + level + "] " + content;
    }
}

// 日志系统类（顺序表实现）
class LogServer {
    private Log[] logs;     // 存储日志的数组
    private int curLen;     // 当前日志数
    private int maxSize;    // 最大容量

    public LogServer(int maxSize) {
        this.maxSize = maxSize;
        this.logs = new Log[maxSize];
        this.curLen = 0;
    }

    // 向顺序表尾部追加日志 O(1)
    public int appendLog(Log log) {
        if (curLen >= maxSize) {
            System.out.println("Log system is full! Cannot add new log.");
            return -1;
        }
        logs[curLen++] = log;
        return 0;
    }

    // 显示所有日志 O(n)
    public void showAllLogs() {
        for (int i = 0; i < curLen; i++) {
            System.out.println(logs[i]);
        }
    }

    // 按级别查找日志 O(n)
    public Log[] searchByLevel(String level) {
        // 时间复杂度 O(n)，需要遍历整个顺序表
        int count = 0;
        for (int i = 0; i < curLen; i++) {
            if (logs[i].level.equals(level)) count++;
        }
        Log[] result = new Log[count];
        int idx = 0;
        for (int i = 0; i < curLen; i++) {
            if (logs[i].level.equals(level)) result[idx++] = logs[i];
        }
        return result;
    }

    // 获取最后一条日志 O(1)
    public Log getLatestLog() {
        // 顺序表支持下标访问，直接返回最后一条日志
        if (curLen == 0) return null;
        return logs[curLen - 1];
    }

    // 清空日志 O(1)
    public void clear() {
        curLen = 0;
    }
}


