package TmpTests;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.DoublePredicate;
import java.util.stream.Collectors;

/**
 * Class for temporary tests.
 */
public class AnyTestClass {

    public static void main(String... args) {

//    testOne();
//    testTwo();
//    threadLocalTest();
//    hashMapTest();
//    parallelArraysAlgs();
//        futureTaskTest();
//        executorTest();
//        forkJoinFrameworkTest();
        loadImageTest();
    }

    private static void testOne() {
        List<String> strings = List.of("1", "2", "2");
        HashMap<Integer, String> collect = new HashMap<>();
        for (String string : strings) {
            collect.put(Integer.parseInt(string), string);// (2)
        }
        collect.forEach((k, v) -> System.out.println(k + " " + v));
    }

    private static void testTwo() {
        List<String> strings = List.of("1", "2", "2");
        Map<Integer, String> collect = strings.stream().collect(Collectors.toMap(Integer::parseInt, s -> s));// (1)
        collect.forEach((k, v) -> System.out.println(k + " " + v));
    }

    private static void threadLocalTest() {
        Runnable simpleTask = new Runnable() {
            @Override
            public void run() {
                ThreadLocal<Integer> counter = new ThreadLocal<>();
                System.out.println(counter.get());

                counter = ThreadLocal.withInitial(ThreadLocalRandom.current()::nextInt);
                System.out.println(counter.get());

                counter.set(99);
                System.out.println(counter.get());

                counter.remove();
                System.out.println(counter.get());
            }
        };

        new Thread(simpleTask).start();
    }

    private static void hashMapTest() {
        ConcurrentHashMap<String, Integer> testConcurrentHMap = new ConcurrentHashMap<>();
        Integer maxLength = testConcurrentHMap.reduceKeys(Long.MAX_VALUE, String::length, Integer::max);
        Long threshold = 2L;

        HashMap<String, Integer> standardHashMap = new HashMap<>();
        standardHashMap.put("Key", 4);
        System.out.println(standardHashMap.get("Key"));

        standardHashMap.merge("Key", 4, (integer, integer2) -> {
            return integer + integer2;
        });
        System.out.println(standardHashMap.get("Key"));

        testConcurrentHMap.put("Key", 10);
        testConcurrentHMap.put("Key2", 20);
        testConcurrentHMap.put("Key3", 40);

        testConcurrentHMap.forEach(threshold, (key, integer) -> integer *= 10, System.out::println);

        Long count = testConcurrentHMap.reduceValues(threshold, v -> v < 15 ? 1L : null, Long::sum);
        System.out.println(count);

        System.out.println(testConcurrentHMap.put("Key", 15));
        System.out.println(testConcurrentHMap.contains(10));
        System.out.println(testConcurrentHMap.contains(15));


    }

    private static void parallelArraysAlgs() {
        Integer values[] = new Integer[20];
        Arrays.parallelSetAll(values, i -> ThreadLocalRandom.current().nextInt(0, 20));
        for (int value : values)
            System.out.println(value);

        System.out.println("Sorted array: ");
        Arrays.parallelSort(values, values.length / 2, values.length, Integer::compareTo);
        for (int value : values)
            System.out.println(value);

    }

    private static void futureTaskTest() {
        int limit = 10;

        Callable<Integer> task = () -> {
            Integer result = 0;
            for (int i = 0; i <= limit; i++)
                result += i;
            return result;
        };
        var futureTask = new FutureTask<Integer>(task);
        var t = new Thread(futureTask); // it's a Runnable
        t.start();

        try {
            Integer result = futureTask.get(); // it's a Future
            System.out.println(result);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

    }

    private static void executorTest() {
        int numberOfThreads = 4;
        int limit = 10;
        int numberOfTasks = 10;

        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        List<Callable<Integer>> tasks = new ArrayList<>();

        for (int i = 0; i < numberOfTasks; i++) {
            int current = i;
            Callable<Integer> task = () -> {
                Integer result = 0;
                for (int j = 0; j <= current; j++)
                    result += j;
                return result;
            };
            tasks.add(task);
        }

        try {
            System.out.println(executorService.invokeAny(tasks));
            executorService.shutdown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

    }

    private static void forkJoinFrameworkTest() {
        DoublePredicate filter = x -> {
            return x > 0.5;
        };
        final int SIZE = 10000000;
        var numbers = new double[SIZE];
        for (int i = 0; i < SIZE; i++) numbers[i] = Math.random();
        var counter = new Counter(numbers, 0, numbers.length, filter);
        var pool = new ForkJoinPool();
        pool.invoke(counter);
        System.out.println(counter.join());

    }

    private static void loadImageTest()
    {
        try {
        URL url = new URL("https://horstmann.com/images/violet.jpg");
            var image = ImageIO.read(url);
            if (image != null) {
                String filename = "C:\\Users\\user\\Downloads\\image.png";
                ImageIO.write(image, "PNG", new File(filename));
                System.out.println("Ok!");
            } else {
                System.out.println("Not Ok!");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
