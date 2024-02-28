import Events.Persons.IPerson;
import Events.Persons.Manager;
import Events.Persons.Person;

import InternalClasses.*;
import Events.*;
import Reflection.*;
import Streams.StreamTests;
import Tests.*;
import ProxyObjects.*;
import Sorts.*;
import Threads.*;
import org.jetbrains.annotations.NotNull;
import PageCounter.*;
import GenericTests.*;
import Collections.*;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Proxy;
import java.math.BigDecimal;
import java.util.*;
import java.time.*;
import java.util.function.*;
import java.util.logging.Logger;


public class Worker {

  private static Logger logger = Logger.getLogger("Worker");

  public static void main(String... args) throws IOException {
     /*Loading start configuration*/


    File run_properties_path = new File("D:\\Projects\\JAVA\\Dump\\src\\main\\resources\\run.properties");
    Properties properties = new Properties();
    properties.load(new FileReader(run_properties_path));

    /*Primitives and WrapperClasses test*/
    final boolean PRIMITIVES_FLAG = Boolean.parseBoolean(properties.getProperty("PRIMITIVES_FLAG"));
    /*OOP-test*/
    boolean OOP_TEST = Boolean.parseBoolean(properties.getProperty("OOP_TEST"));
    /*BigDecimal test*/
    boolean BIG_DECIMAL_FLAG = Boolean.parseBoolean(properties.getProperty("BIG_DECIMAL_FLAG"));
    /*String equals test*/
    boolean STREQUALS_FLAG = Boolean.parseBoolean(properties.getProperty("STREQUALS_FLAG"));
    /*Array to string test*/
    boolean ARRAY_FLAG = Boolean.parseBoolean(properties.getProperty("ARRAY_FLAG"));
    /* Reflection test*/
    boolean REFLECTION_FLAG = Boolean.parseBoolean(properties.getProperty("REFLECTION_FLAG"));
    /*Events test*/
    boolean EVENT_FLAG = Boolean.parseBoolean(properties.getProperty("EVENT_FLAG"));
    /*Lambda test*/
    boolean LAMBDA_FLAG = Boolean.parseBoolean(properties.getProperty("LAMBDA_FLAG"));
    /*Internal class test*/
    boolean INTERNAL_CLASS_FLAG = Boolean.parseBoolean(properties.getProperty("INTERNAL_CLASS_FLAG"));
    /*Proxy objects test*/
    boolean PROXY_FLAG = Boolean.parseBoolean(properties.getProperty("PROXY_FLAG"));
    /*Test of standard Java collection framework*/
    boolean COLLECTIONS_TEST = Boolean.parseBoolean(properties.getProperty("COLLECTIONS_TEST"));
    /*Sorts test*/
    boolean SORTS_TEST = Boolean.parseBoolean(properties.getProperty("SORTS_TEST"));
    /*Algorithms test*/
    boolean ALG_TEST = Boolean.parseBoolean(properties.getProperty("ALG_TEST"));
    /*Thread tests*/
    boolean THREAD_TEST = Boolean.parseBoolean(properties.getProperty("THREAD_TEST"));
    /*Stream tests*/
    boolean STREAM_TEST = Boolean.parseBoolean(properties.getProperty("STREAM_TEST"));
    /*Page counter tests*/
    boolean PAGE_COUNTER_TEST = Boolean.parseBoolean(properties.getProperty("PAGE_COUNTER_TEST"));
    /*Test of generic types, classes and methods*/
    boolean GENERIC_TEST = Boolean.parseBoolean(properties.getProperty("GENERIC_TEST"));

    System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId());

    /*Primitives and WrapperClasses test*/
    if (PRIMITIVES_FLAG)
      primitivesTest();

    /*OOP-test*/
    if (OOP_TEST)
      oopTest();

    /*BigDecimal test*/
    if (BIG_DECIMAL_FLAG)
      bigDecimalTest();

    /*String equals test*/
    if (STREQUALS_FLAG)
      stringEqualsTest();

    /*Array to string test*/
    if (ARRAY_FLAG)
      arrayToStringTest();

    /* Reflection test*/
    if (REFLECTION_FLAG)
      reflectionTest();

    /*Events test*/
    if (EVENT_FLAG)
      evetTest();

    /*Lambda test*/
    if (LAMBDA_FLAG)
      lambdaTets();

    /*Internal class test*/
    if (INTERNAL_CLASS_FLAG)
      internalClassTest();

    /*Proxy objects test*/
    if (PROXY_FLAG)
      proxyClassTest();

    /*Collections test*/
//    if (COLLECTIONS_TEST)
//      collectionsTest();

    /*Sorts test*/
    if (SORTS_TEST)
      sortsTest();

    /*Algorithms test*/
    if (ALG_TEST) {
      AlgorithmsTest.binarySearchTest();
      AlgorithmsTest.simpleAlgs();
    }

    /*Threads test*/
    if (THREAD_TEST) {
      RecursiveTaskTest.test();
    }

    /*Stream tests*/
    if (STREAM_TEST) {
      StreamTests.test();
    }

    /*Page counter tests*/
    if (PAGE_COUNTER_TEST) {
      int sumOfPages = 1095;
      System.out.printf("Pages: %d\n", PageCounter.countPages(sumOfPages));
    }

    /*Test of generic types, classes and methods*/
    if (GENERIC_TEST)
    {
      GenericTests.test();
    }

    /*Test of standard Java collection framework*/
    if (COLLECTIONS_TEST)
    {
      CollectionsTest.test();
    }

  }

  /*Primitives and WrapperClasses test*/
  static void primitivesTest() {
    int[] numbersPrimitive = { 1, 5, 2};
    Integer[] numbersClassType = { 1, 5, 2};

    List listPrimitive, listClassType;

    listPrimitive = Arrays.asList(numbersPrimitive);
    listClassType = Arrays.asList(numbersClassType);

    int iterationsMax = 1000,
      i;

    //Primitives:
    double a = 10.0,
      b = 1.3,
      resPrimitive;
    //Wrapper Class:
    Double x = 10.0,
      y = 1.3,
      resClass;

    resPrimitive = a - b;
    resClass = x - y;
    System.out.printf("double result: %f\n", resPrimitive);
    System.out.printf("Double result: %f\n", resClass);

    int res = 2_147_483_647;
    System.out.println("Res Integer: " + res);

  }

  /*OOP-test*/
  static void oopTest() {
    ArrayList<Person> persons = new ArrayList<>();
    persons = Worker.createPersons();

    getPersonSummary(persons);

    /*Enum test*/
    Worker.changeableHairEnum(persons);
  }

  /*BigDecimal test*/
  static void bigDecimalTest() {
    BigDecimal amount = BigDecimal.valueOf(20000.12);
    BigDecimal delta = BigDecimal.valueOf(100);
    amount.add(delta);

    System.out.println(amount);
  }

  /*String equals test*/
  static void stringEqualsTest() {
    String s1 = "aaa", s2 = "aaa", s3 = "aaaa", s4 = "aa", s5 = "bbb";
    int[] symbols = s1.codePoints().toArray();
    System.out.println(s1.equals(s2));
    System.out.println(s1.equals(s3));
    System.out.println(s1.equals(s4));
    System.out.println(s1.equals(s5));
  }

  /*Array to string test*/
  static void arrayToStringTest() {
    int[] randomNumbers = {2, 4, 88, 756, 5};
    Arrays.sort(randomNumbers);
    System.out.println(Arrays.toString(randomNumbers));
  }

  /* Reflection test*/
  static void reflectionTest() {
    try {
      System.out.println(ReflectionTest.getAllAboutClass("Persons.Person"));
    } catch (Exception e) {
      System.out.println(e.getStackTrace().toString());
    }
  }

  /*Events test*/
  static void evetTest() {
    var listener = new TimePrinter();

    var timer = new Timer(1000, listener);
    timer.start();

    JOptionPane.showMessageDialog(null, "Qui t program?");
    System.exit(0);
  }

  /*Lambda test*/
  static void lambdaTets() {
    String[] brands = {"Coca-cola", "Pepsi", "Mars", "Citibank"};
    Arrays.sort(brands, (first, second) -> first.length() - second.length());
    System.out.println(Arrays.toString(brands));

    ActionListener actionListener = event -> System.out.println("The time is " + Instant.ofEpochMilli(event.getWhen()));

    ArrayList<Person> persons = new ArrayList<>();

    persons.add(new Person("John", 21));
    persons.add(new Person("Bill", 18));
    persons.add(new Person("Hill", 60));
    persons.removeIf(p -> p.getAge() > 30);
    for (Person p : persons)
      System.out.println(p.getName() + ' ' + p.getAge());

    Worker.repeat(10, i -> System.out.println("Countdown: " + (10 - i)));

  }

  /*Internal class test*/
  static void internalClassTest() {
    var clock = new TalkingClock(1000, false);
    clock.start();
    JOptionPane.showMessageDialog(null, "Quit program?");
    System.exit(0);
  }

  /*Proxy objects test*/
  static void proxyClassTest() {
    IPerson value = new Person();
    var handler = new TraceHandler(value);
    Object proxy = Proxy.newProxyInstance(
      ClassLoader.getSystemClassLoader(),
      new Class[]{IPerson.class}, handler);
    IPerson proxeedValue = (IPerson) proxy;
    System.out.println("Person: " + ((IPerson) proxy).getName());
    System.out.println("Person: " + proxeedValue.getName());
  }

  /*Collections test*/
  static void collectionsTest() {
    LinkedList<String> items = new LinkedList<>();
    ArrayList<String> items_2 = new ArrayList<>();
    HashMap<String, Integer> hashMap = new HashMap<>();

    int iterations = 100_000;
//    int iterations = 10;
//    int iterations = 10;
    long start, additionTimeLinkedList, additionTimeArrayList, additionTimeHashMap

      , gettingTimeLinkedList, gettingTimeArrayList, gettingTimeHashMap, gettingRandomTimeLinkedList, gettingRandomTimeArrayList, gettingRandomTimeHashMap;

    /*Linked list tests:
     *1. Addition of elements*/
    start = System.currentTimeMillis();
    for (int i = 0; i < iterations; i++) {
      items.add("Element: " + i);
    }
    additionTimeLinkedList = System.currentTimeMillis() - start;

    /*2. Continuous access*/
    start = System.currentTimeMillis();
    for (String e : items) {
      e += " Work";
    }
    gettingTimeLinkedList = System.currentTimeMillis() - start;

    /*3. Random access*/
    Random random = new Random();

    start = System.currentTimeMillis();
    for (int i = 0; i < iterations; i++) {
      items.get(random.nextInt(items.size()));
    }
    gettingRandomTimeLinkedList = System.currentTimeMillis() - start;

    /*Array list tests:
     *1. Addition of elements*/
    start = System.currentTimeMillis();
    for (int i = 0; i < iterations; i++) {
      items_2.add("Element: " + i);
    }
    additionTimeArrayList = System.currentTimeMillis() - start;

    /*2. Continuous access*/
    start = System.currentTimeMillis();
    for (String e : items_2) {
      e += " Work";
    }
    gettingTimeArrayList = System.currentTimeMillis() - start;

    /*3. Random access*/
    start = System.currentTimeMillis();
    for (int i = 0; i < iterations; i++) {
      items_2.get(random.nextInt(items_2.size()));
    }
    gettingRandomTimeArrayList = System.currentTimeMillis() - start;

    /*Hash map tests:
     * 1. Addition of elemets*/
    start = System.currentTimeMillis();
    for (int i = 0; i < iterations; i++) {
      hashMap.put("Hash" + i, i);
    }
    additionTimeHashMap = System.currentTimeMillis() - start;

    /*2. Continuous access*/
    start = System.currentTimeMillis();
    hashMap.forEach((k, v) -> {
      v += 1;
    });
    gettingTimeHashMap = System.currentTimeMillis() - start;

    /*3. Random acces*/
    start = System.currentTimeMillis();
    for (int i = 0; i < iterations; i++) {
      hashMap.get("Hash" + random.nextInt(hashMap.size()));
    }
    gettingRandomTimeHashMap = System.currentTimeMillis() - start;

    /*Output*/
    System.out.println("Linked list addition of " + iterations + " elements elapsed time: " + additionTimeLinkedList);
    System.out.println("Array list addition of " + iterations + " elements elapsed time: " + additionTimeArrayList);
    System.out.println("Hash map addition of " + iterations + " elements elapsed time: " + additionTimeHashMap);

    System.out.println("Linked list getting of " + iterations + " elements elapsed time: " + gettingTimeLinkedList);
//    System.out.println("Array list getting of " + iterations + " elements elapsed time: " + gettingTimeArrayList);
    System.out.println("Hash map getting of " + iterations + " elements elapsed time: " + gettingTimeHashMap);

    System.out.println("Linked list random getting of " + iterations + " elements elapsed time: " + gettingRandomTimeLinkedList);
    System.out.println("Array list random getting of " + iterations + " elements elapsed time: " + gettingRandomTimeArrayList);
    System.out.println("Hash map random getting of " + iterations + " elements elapsed time: " + gettingRandomTimeHashMap);

  }

  public static void sortsTest() {
    List<Integer> unsortedArray = new ArrayList<>() {{
      add(1);
      add(2);
      add(34);
      add(10);
      add(12);
    }};
    Sorter.mergeSort(unsortedArray);


  }

  private static void changePerson(Person person) {
    person = new Person();
    person.plusYear();
    person.plusYear();
  }

  private static void changeStr(StringBuilder sb) {
    sb.append("append");
  }

  public static void repeat(int n, IntConsumer action) {
    for (int i = 0; i <= n; i++)
      action.accept(i);
  }

  private static ArrayList<Person> createPersons() {
    Person mike,
      ivan;
    Manager joe,
      bob;

    ArrayList<Person> persons = new ArrayList<>();

    mike = new Person("Mike", 21, 5000.0);
    joe = new Manager("Joe", 45, 10000.0);
    ivan = new Person();
    bob = new Manager("Bob", 36, 10000.0, 1000.0);

    joe.setBonus(2000.0);
    persons.add(mike);
    persons.add(joe);
    persons.add(ivan);
    persons.add(bob);

    return persons;
  }

  private static void changeableHairEnum(ArrayList<Person> persons) {
    int i = 0;
    for (Person person : persons) {
      i++;
      person.getHair().changable = "Changeable hair " + i;
    }

    for (Person person : persons) {
      System.out.println(person.getName() + " " + person.getHair().changable);
    }
  }

  private static void getPersonSummary(@NotNull ArrayList<? extends Person> persons) {
    for (Person person : persons) {
      System.out.printf("Person: %s Age: %d Salary: %f\n",
        person.getName(),
        person.getAge(),
        person.getSalary());
    }
  }

  private static BigDecimal maxBigDecimal(BigDecimal a, BigDecimal b) {
    if (a.compareTo(b) > 0)
      return a;
    else
      return b;
  }

}
