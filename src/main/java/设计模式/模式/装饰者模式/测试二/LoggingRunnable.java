package 设计模式.模式.装饰者模式.测试二;

public class LoggingRunnable implements Runnable {

  private final Runnable innerRunnable;

  public LoggingRunnable(Runnable innerRunnable) {
    this.innerRunnable = innerRunnable;
  }

  @Override
  public void run() {
    long startTime = System.currentTimeMillis();
    System.out.println("Task started at "
        + startTime);

    innerRunnable.run();

    System.out.println("Task finished. Elapsed time: "
        + (System.currentTimeMillis() - startTime));
  }
}
