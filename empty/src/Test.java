// 测试类
public class Test {
    public static void main(String[] args) {
        LogServer server = new LogServer(20);

        // 添加10条日志
        for (int i = 1; i <= 10; i++) {
            String level;
            if (i % 3 == 0) level = "ERROR";
            else if (i % 2 == 0) level = "WARN";
            else level = "INFO";

            Log log = new Log("2025.09.24 10:0" + i + ":000", level, "第 " + i + " 条日志");
            server.appendLog(log);
        }

        // 显示所有日志
        System.out.println("=== 所有日志 ===");
        server.showAllLogs();

        // 查找 ERROR 日志
        System.out.println("\n=== ERROR 日志 ===");
        Log[] errors = server.searchByLevel("ERROR");
        for (Log log : errors) {
            System.out.println(log);
        }

        // 获取最新日志
        System.out.println("\n=== 最新日志 ===");
        System.out.println(server.getLatestLog());
    }
}