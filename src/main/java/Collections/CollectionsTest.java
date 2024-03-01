package Collections;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class that contains different tests for collections.
 */
public class CollectionsTest {

  /**
   * Standard project logger.
   */
  private static Logger logger = Logger.getLogger("Worker");

  /**
   * General test-method
   */
  public static void test()
  {
    iteratorTest();
    hashMapCollisionTest();
    viewTest();
  }

  /**
   * Test iterators behavior.
   */
  private static void iteratorTest()
  {
    var names = new ArrayList<String>();
    names.add("James");
    names.add("Bob");
    names.add("Larry");

    ListIterator<String> iterator1 = names.listIterator();
    ListIterator<String> iterator2 = names.listIterator();

    //Force "ConcurrentModificationException"
    try {
      iterator1.next();
      iterator1.remove();
      iterator2.next();
    }
    catch (ConcurrentModificationException e)
    {
      logger.log(Level.INFO, "ConcurrentModificationException occurred!", e);
    }
  }


  /**
   * Test how Java can handle the collisions in Hashmaps.
   */
  private static void hashMapCollisionTest()
  {
    HashMap<Integer, String> testMap = new HashMap<>();
    String name1 = "Sergey";
    String name2 = "Viktor";
    String name3 = "Andrey";

    testMap.put(1, name1);
    testMap.put(2, name2);
    testMap.put(3, name3);

    logger.info("Hashmap collision test: ");
    for (String name : testMap.values())
      logger.info("Name: " + name);

    getNameById(1, testMap);
    getNameById(2, testMap);
    getNameById(4, testMap);
    getNameById(4, null);


    testMap.put(1, name2);
    getNameById(1, testMap);

    HashCodeTester objectOne = new HashCodeTester();
    HashCodeTester objectTwo  = new HashCodeTester("Different data, oh wow!");
    HashCodeTester objectThree = new HashCodeTester("Data of the third object...");

    logger.info("Object one hashcode: " + objectOne.hashCode());
    logger.info("Object two hashcode: " + objectTwo.hashCode());

    HashSet<HashCodeTester> testHashSet = new HashSet<HashCodeTester>();
    testHashSet.add(objectOne);
    testHashSet.add(objectTwo);

    logger.info(""+testHashSet.size());
    for(var data: testHashSet)
      logger.info("Hashset contains: " + data.getData());

    if (testHashSet.contains(objectOne))
      logger.info("Hashset contains: " + objectOne.getData());
    if (testHashSet.contains(objectTwo))
      logger.info("Hashset contains: " + objectTwo.getData());
    if (testHashSet.contains(objectThree))
      logger.info("Hashset contains: " + objectThree.getData());

    Iterator<HashCodeTester> hashSetIterator = testHashSet.iterator();
    while (hashSetIterator.hasNext())
      logger.info(hashSetIterator.next().getData());

    logger.info(""+testHashSet.size());

  }

  /**
   * Test of unmodifiable view.
   */
  private static void viewTest()
  {
    var names = new ArrayList<>(List.of("Ann", "Bob", "Rob"));
    var unmodifiableNames = Collections.unmodifiableList(names);
    names.add("Borg");

    for (var name : unmodifiableNames )
      logger.info("Unmodifiable name: " + name.toString());

    //Cause the UnsupportedOperationException
    try {
      unmodifiableNames.add("Bun");
    }
    catch (UnsupportedOperationException e)
    {
      logger.log( Level.FINE, "Attempt of modification unmodified view!", e);
    }
  }

  /**
   * Tries to find Name by id.
   * @param id Key index.
   * @param hashMap Name storage.
   */
  private static void getNameById(int id, HashMap<Integer, String> hashMap)
  {
    if (hashMap == null || hashMap.isEmpty()) {
      logger.warning("Hashmap is empty!");
      return;
    }

    String name = hashMap.get(id);
    if (name != null)
      logger.info("Name by id: " + id + " , is " + name + ".");
    else
      logger.warning("Can't find the name by id: " + id);
  }
}
