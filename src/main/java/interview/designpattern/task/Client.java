package interview.designpattern.task;

public class Client {
  public static void main(String[] args) {
    new LoggingRunnable(
        new TransactionalRunnable(
            new CodingTask(0))).run();
  }
}
