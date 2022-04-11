package Threads;

import java.util.concurrent.ConcurrentHashMap;

public class ParameterizedRunnable implements Runnable{

  private static final String PATTERN = "Element"
    , SPACE = " ";

  private int offset, elements;
  private static ConcurrentHashMap cHashMap;

  public ParameterizedRunnable(int offset, int elements, ConcurrentHashMap cHashMap)
  {
    this.offset = offset;
    this.elements = elements;
    this.cHashMap = cHashMap;
  }

  @Override
  public void run( ) {
    var sb = new StringBuilder();
    for (int i = 0; i < elements; i++) {
      sb.append(PATTERN)
        .append(SPACE)
        .append(i)
        .append(SPACE)
        .append(Thread.currentThread().getId())
        .append(SPACE);
      cHashMap.put(offset + i, sb);
      sb = new StringBuilder();
    }
  }
}
