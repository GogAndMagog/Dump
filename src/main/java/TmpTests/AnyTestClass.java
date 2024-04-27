package TmpTests;

import com.sun.management.ThreadMXBean;

import java.lang.management.ManagementFactory;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;



/**
 * Class for temporary tests.
 */
public class AnyTestClass {

  public static void main(String... args)
  {
    intrinsicLockTest();
   //test_one();
//    measureObjectSize();
  }

  
  private static void test_one()
  {
    Map<String, Integer> testMap = new HashMap<>();

    testMap.put(null, 1);
    testMap.put("2", null);
    testMap.put(null, null);

    testMap.forEach((s, integer) -> {
      if (s == null)
        System.out.println("Key: null");
      else
        System.out.println("Key: " + s);
      if (integer == null)
        System.out.println("Value: null");
      else
        System.out.println("Value: " + integer);
    });
  }
  private static void measureObjectSize()
  {
    long threadID = Thread.currentThread().getId();
    var mxBean = (ThreadMXBean)ManagementFactory.getThreadMXBean();

    long before = mxBean.getThreadAllocatedBytes(threadID);
    new Object();
    long after = mxBean.getThreadAllocatedBytes(threadID);

    System.out.println("Size = " + (after - before));
  }

  private static void intrinsicLockTest()
  {
    Body randomBody = new Body();

    Runnable taskOne = ()->{ synchronized (randomBody){
      randomBody.changeGender(Sex.FEMALE);
    }};

    //Thread starts
    Thread thread = new Thread(taskOne);
    thread.start();

    //Trying to get access to a synchronized object by reflection
    try {
      synchronized (randomBody){
      TimeUnit.SECONDS.sleep(3); //Waiting for 3 seconds for thread starts
      Field nameField = randomBody.getClass().getDeclaredField("sex");
      nameField.setAccessible(true);
      nameField.set(randomBody, Sex.HELICOPTER);}
    }
    catch (NoSuchFieldException e) {
      System.err.println(e.getMessage());
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }

    //Trying to change gender by standard setter-method
    synchronized (randomBody){
    randomBody.changeGender(Sex.ANIME);}
  }
}

