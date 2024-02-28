package Threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TaskTest {

  private static final int DEFAULT_ITERATIONS = 10;
  private int iterations;

  public TaskTest()
  {
    this.iterations = DEFAULT_ITERATIONS;
  }

  public TaskTest(int iterations)
  {
    this.iterations = iterations;
  }

  public void setIterations(int iterations) {
    this.iterations = iterations;
  }

  public void test()
  {
    Callable<Integer> sum = () -> {
      int resSum = 0;
      for (int i = 0; i < iterations; i++) {
        Thread.sleep(1000);
        resSum += i;
      }

      return resSum;
    };

    try {
      var futureTask = new FutureTask<Integer>(sum);
      var thread = new Thread(futureTask);
      thread.start();
      var counter = 0;
      while (thread.isAlive())
      {
        counter++;
        Thread.sleep(500);
        System.out.println("Waiting " + counter);
      }
      System.out.println("Sum: " + futureTask.get());
    }
    catch (InterruptedException e)
    { e.printStackTrace();}
    catch (ExecutionException e)
    { e.printStackTrace();}

  }
}

