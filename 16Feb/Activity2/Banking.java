import java.time.LocalDateTime;
import java.util.*;

public class SecureBankingLogManager {

    enum ActionType {
        DEPOSIT,
        WITHDRAW,
        TRANSFER,
        LOGIN,
        FAILED_LOGIN
    }

    enum Status {
        SUCCESS,
        FAILED
    }

    static class LogEntry {

        private final long logId;
        private final String accountNumber;
        private final ActionType actionType;
        private final double amount;
        private final LocalDateTime timestamp;
        private final Status status;

        public LogEntry(long logId, String accountNumber,
                        ActionType actionType, double amount,
                        LocalDateTime timestamp, Status status) {
            this.logId = logId;
            this.accountNumber = accountNumber;
            this.actionType = actionType;
            this.amount = amount;
            this.timestamp = timestamp;
            this.status = status;
        }

        public long getLogId() { return logId; }
        public String getAccountNumber() { return accountNumber; }
        public ActionType getActionType() { return actionType; }
        public double getAmount() { return amount; }
        public LocalDateTime getTimestamp() { return timestamp; }
        public Status getStatus() { return status; }

        public String toString() {
            return "LogEntry{" +
                    "logId=" + logId +
                    ", accountNumber='" + accountNumber + '\'' +
                    ", actionType=" + actionType +
                    ", amount=" + amount +
                    ", timestamp=" + timestamp +
                    ", status=" + status +
                    '}';
        }
    }

    interface SuspiciousDetector {
        List<LogEntry> detect(List<LogEntry> logs);
    }

    static class DefaultSuspiciousDetector implements SuspiciousDetector {

        public List<LogEntry> detect(List<LogEntry> logs) {

            List<LogEntry> suspicious = new ArrayList<>();

            for (int i = 0; i < logs.size(); i++) {

                LogEntry current = logs.get(i);

                if (current.getActionType() == ActionType.WITHDRAW &&
                        current.getAmount() > 50000) {
                    suspicious.add(current);
                }

                if (current.getActionType() == ActionType.FAILED_LOGIN) {

                    int failedCount = 0;
                    int start = Math.max(0, i - 4);

                    for (int j = start; j <= i; j++) {
                        if (logs.get(j).getActionType() == ActionType.FAILED_LOGIN) {
                            failedCount++;
                        }
                    }

                    if (failedCount > 3) {
                        suspicious.add(current);
                    }
                }
            }

            return suspicious;
        }
    }

    static class LogManager {

        private long idCounter = 1;

        private final List<LogEntry> allLogs = new ArrayList<>();
        private final Map<String, List<LogEntry>> accountLogs = new HashMap<>();
        private final Map<ActionType, List<LogEntry>> actionLogs = new HashMap<>();
        private final Deque<LogEntry> logStack = new ArrayDeque<>();

        private final SuspiciousDetector detector;

        public LogManager(SuspiciousDetector detector) {
            this.detector = detector;
        }

        public void addLog(String accountNumber,
                           ActionType actionType,
                           double amount,
                           Status status) {

            LogEntry entry = new LogEntry(
                    idCounter++,
                    accountNumber,
                    actionType,
                    amount,
                    LocalDateTime.now(),
                    status
            );

            allLogs.add(entry);
            logStack.push(entry);

            accountLogs.computeIfAbsent(accountNumber, k -> new ArrayList<>())
                    .add(entry);

            actionLogs.computeIfAbsent(actionType, k -> new ArrayList<>())
                    .add(entry);
        }

        public List<LogEntry> getLogsByAccount(String accountNumber) {
            return accountLogs.getOrDefault(accountNumber, new ArrayList<>());
        }

        public List<LogEntry> getRecentLogs(int n) {

            List<LogEntry> result = new ArrayList<>();
            Iterator<LogEntry> iterator = logStack.iterator();

            while (iterator.hasNext() && result.size() < n) {
                result.add(iterator.next());
            }

            return result;
        }

        public List<LogEntry> detectSuspicious() {
            return detector.detect(allLogs);
        }

        public List<LogEntry> searchByAction(ActionType type) {
            return actionLogs.getOrDefault(type, new ArrayList<>());
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LogManager manager = new LogManager(new DefaultSuspiciousDetector());

        while (true) {

            System.out.println("\n1.Add Log");
            System.out.println("2.Get Logs by Account");
            System.out.println("3.Get Recent Logs");
            System.out.println("4.Detect Suspicious");
            System.out.println("5.Search by Action");
            System.out.println("6.Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Account: ");
                    String acc = sc.next();
                    System.out.print("ActionType: ");
                    ActionType type = ActionType.valueOf(sc.next());
                    System.out.print("Amount: ");
                    double amt = sc.nextDouble();
                    System.out.print("Status: ");
                    Status status = Status.valueOf(sc.next());
                    manager.addLog(acc, type, amt, status);
                    break;

                case 2:
                    System.out.print("Account: ");
                    System.out.println(manager.getLogsByAccount(sc.next()));
                    break;

                case 3:
                    System.out.print("Enter N: ");
                    System.out.println(manager.getRecentLogs(sc.nextInt()));
                    break;

                case 4:
                    System.out.println(manager.detectSuspicious());
                    break;

                case 5:
                    System.out.print("ActionType: ");
                    System.out.println(manager.searchByAction(
                            ActionType.valueOf(sc.next())));
                    break;

                case 6:
                    return;
            }
        }
    }
}
