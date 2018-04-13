package 设计模式.模式.装饰者模式.测试二;

public class Tester {

  public static void main(String[] args) {
    new LoggingRunnable(
        new TransactionalRunnable(
            new CodingTask(0))).run();
  }
}
