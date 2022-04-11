package Threads;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentCollectionTest {

  private static final int ELEMENTS = 100
                         , THREADS = 3;

  private static ConcurrentHashMap cHashMap = new ConcurrentHashMap<Integer, String>();
  private static int offset = 0;

   public static void test()
   {
     boolean abort = false;
     int closedThreads = 0;

     Thread[] threads = new Thread[THREADS];

     for (Thread t : threads)
     {
       var rNew = new ParameterizedRunnable(offset, ELEMENTS, cHashMap);
       t = new Thread(rNew);
       t.start();
       offset += ELEMENTS;
     }

     while (!abort)
     {
       for (Thread t : threads)
       {
         if (t == null || !t.isAlive())
           closedThreads++;
         if (closedThreads == THREADS)
           abort = true;
       }
       cHashMap.forEach((k, v) ->{ System.out.println(k + " " + v); } );
       System.out.println();
     }
     cHashMap.forEach((k, v) ->{ System.out.println(k + " " + v); } );
   }

}
