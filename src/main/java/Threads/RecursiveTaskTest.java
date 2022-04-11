package Threads;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.function.DoublePredicate;

public class RecursiveTaskTest extends RecursiveTask<Integer> {

  private final int THRESHOLD = 1000;
  private static final int SIZE = 10_000_000;

  private double[] values;
  private int from, to;
  private DoublePredicate filter;

  public RecursiveTaskTest(double[] values, int from, int to, DoublePredicate filter)
  {
    this.values = values;
    this.from = from;
    this.to = to;
    this.filter = filter;
  }

  @Override
  protected Integer compute() {

    int count = 0;
    if ((to - from) > THRESHOLD)
    {
      for (int i = 0; i < to; i++)
        if (filter.test(values[i])) count++;
    }
    else
    {
      int mid = (from + to)/2;
      RecursiveTaskTest task_1 = new RecursiveTaskTest(values, from, mid, filter);
      RecursiveTaskTest task_2 = new RecursiveTaskTest(values, mid, to, filter);
      invokeAll(task_1, task_2);
      count = task_1.join() + task_2.join();
    }

    return count;
  }

  public static void test()
  {

    double[] testValues = new double[SIZE];
    for(int i = 0; i < SIZE; i++)
      testValues[i] = Math.random();

    var testTask = new RecursiveTaskTest(testValues, 0, SIZE, x->x > 0.5);
    var pool = new ForkJoinPool();
    pool.invoke(testTask);
    System.out.println("Recursive task test: " + testTask.join());
  }
}
