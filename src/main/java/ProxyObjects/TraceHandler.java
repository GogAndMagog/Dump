package ProxyObjects;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TraceHandler implements InvocationHandler {
  private Object target;

  public TraceHandler(Object t) {
    target = t;
  }

  public Object invoke(Object proxy,
                       Method m,
                       Object[] args)
    throws Throwable {
    System.out.println("Class: "
      + target.getClass().getName()
      + " Method: "
      + m.getName()
      + " Arguments: "
      + Arrays.toString(args));
    return m.invoke(target, args);
  }
}
