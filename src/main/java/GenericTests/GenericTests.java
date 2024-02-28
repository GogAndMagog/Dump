package GenericTests;

import Events.Persons.Manager;
import Events.Persons.Person;

import java.lang.reflect.WildcardType;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class with synthetic tests for "Generics".
 */
public class GenericTests {
  /**
   * Standard project logger.
   */
  private static Logger logger = Logger.getLogger("Worker");

  /**
   * Test call method.
   */
  public static void test() {
    logger.log(Level.INFO, "Starting of Generic Tests:");

    genericMethodsTest();
    genericClassesTest();
  }

  /**
   * Test of different generic methods. Shows its flexibility.
   */
  private static void genericMethodsTest() {
    logger.log(Level.INFO, "Result of generic method getObjectAsString: " + getObjectAsString(logger));
    logger.log(Level.INFO, "Result of generic method getObjectAsString: " + getObjectAsString(System.out));
    logger.log(Level.INFO, "Result of generic method getObjectAsString: " + getObjectAsString(1));
    logger.log(Level.INFO, "Result of generic method getObjectAsString: " + getObjectAsString(2.1));
    logger.log(Level.INFO, "Result of generic method getObjectAsString: " + getObjectAsString(2.2f));

    logger.log(Level.INFO, "Result of generic method getTypeAsString: " + getTypeAsString(logger));
    logger.log(Level.INFO, "Result of generic method getTypeAsString: " + getTypeAsString(System.out));
    logger.log(Level.INFO, "Result of generic method getTypeAsString: " + getTypeAsString(1));
    logger.log(Level.INFO, "Result of generic method getTypeAsString: " + getTypeAsString(2.1));
    logger.log(Level.INFO, "Result of generic method getTypeAsString: " + getTypeAsString(2.2f));
  }

  /**
   * Test of several generic classes. Tests erasure feature. And inheritance problems.
   */
  private static void genericClassesTest() {
    genericClassTest();
    wildcardMethodTest();
  }

  /**
   * Test of generic class.
   */
  private static void genericClassTest()
  {
    Pair<String> supplierPair = Pair.makePair(String::new);
    supplierPair.setFirst("Aboba");
    supplierPair.setSecond("Obabo");

    logger.log(Level.INFO, "Supplier pair first item: " + supplierPair.getFirs());
    logger.log(Level.INFO, "Supplier pair second item: " + supplierPair.getSecond());
  }

  /**
   * Test of wildcard method.
   */
  private static void wildcardMethodTest()
  {
    Manager managerBob = new Manager("Bob", 45, 3000.0, 150.0);
    Person workerMike = new Person("Mike", 25, 1500.0);
    Person workerJin = new Person("Jin", 19, 1500.0);
    Pair<Person> workPair = new Pair<Person>();
    workPair.setFirst(managerBob);
    workPair.setSecond(workerMike);
    printBuddies(workPair);

    Pair<Manager> managerBuddies = new Pair<Manager>(managerBob, managerBob);
    Pair<? extends Person> wildcardBuddiesExtends = managerBuddies;
//    Can't modify this generic object.
//    wildcardBuddiesExtends.setFirst(workerJin);
//    wildcardBuddiesExtends.setFirst(managerBob);

//    But can read values.
    wildcardBuddiesExtends.getFirs();
    wildcardBuddiesExtends.getSecond();

    Pair<Person> workerBuddies = new Pair<Person>(workerMike, workerMike);
    Pair<? super Person> wildcardBuddiesSuper = workerBuddies;
//    Can modify generic object.
    wildcardBuddiesSuper.setFirst(managerBob);
    wildcardBuddiesSuper.setSecond(workerJin);

//    But can't read values.
//    managerBob = wildcardBuddiesSuper.getFirs();
//    workerJin = wildcardBuddiesSuper.getSecond();

  }

  /**
   * Method prints to console content of restricted Pair.
   * @param p Pair that can contains Person objects and its subclasses.
   */
  public static void printBuddies(Pair<? extends Person> p)
  {
    logger.log(Level.INFO, "First person is " + p.getFirs().getName() + " he is " +p.getFirs().getClass().getTypeName()
      + ". Age: " + p.getFirs().getAge() + ".");
    logger.log(Level.INFO, "Second person: " + p.getSecond().getName() + " he is " + p.getSecond().getClass().getTypeName()
      + " .Age: " + p.getSecond().getAge() + ".");
  }

  /**
   * Takes object of any type and calls toString() method.
   *
   * @param object Object.
   * @param <T>    Generic type of entry param, erases to Object type at compile time.
   * @return Returns string representation of entry object.
   */
  private static <T> String getObjectAsString(T object) {
    logger.entering(GenericTests.class.getName(), "getTypeAsString", object);
    return object.toString();
  }

  /**
   * Takes object of any type and return description of its type.
   *
   * @param object Object.
   * @param <T>    Generic type of entry param, erases to Object type at compile time.
   * @return Description of object type.
   */
  private static <T> String getTypeAsString(T object) {
    logger.entering(GenericTests.class.getName(), "getTypeAsString", object);
    return object.getClass().getTypeName().toString();
  }
}


