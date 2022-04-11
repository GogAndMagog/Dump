package Persons;

import java.io.IOException;
import java.util.Objects;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Person implements Cloneable, IPerson {

  private static final Logger logger = Logger.getLogger("Person");

  private static final String DEFAULT_NAME = "Ivan";
  private String  name;
  private int     age;
  private Hair    hair;

  private Double  salary;

  static
  {
    logger.setLevel(Level.FINEST);
    try
    {
      final FileHandler fHandler = new FileHandler();
      fHandler.setLevel(Level.FINEST);
      logger.addHandler(fHandler);
      logger.setUseParentHandlers(false);
    }
    catch(IOException e)
    {
      logger.warning("IOException: file handler failed.");
    }
  }

  public int getAge() {
    logger.exiting(this.getClass().getName(), "getAge", age);
    return age;
  }

  public String getName() {
    logger.exiting(this.getClass().getName(), "getName", name);
    return name;
  }

  public Person(String name, int age, Double salary, Hair hair)
  {
    logger.entering(this.getClass().getName(), "Constructor", new Object[]{name, age, salary, hair});
    this.name = Objects.requireNonNullElse(name, "unknown");
    this.age    = age;
    this.salary = salary;
    this.hair   = hair;
  }

  public Person(String name, int age, Double salary)
  {
    logger.entering(this.getClass().getName(), "Constructor", new Object[]{name, age, salary});
    this.name   = name;
    this.age    = age;
    this.salary = salary;
    this.hair   = Hair.BLACK;
  }

  public Person(String name, int age)
  {
    logger.entering(this.getClass().getName(), "Constructor", new Object[]{name, age});
    this.name   = name;
    this.age    = age;
    this.salary = 0.0;
    this.hair   = Hair.BLACK;
  }

  public Person(String name)
  {
    logger.entering(this.getClass().getName(), "Constructor", new Object[]{name});
    this.name   = name;
    this.age    = 1;
    this.salary = 0.0;
    this.hair   = Hair.BLACK;
  }

  public Person( )
  {
    logger.entering(this.getClass().getName(), "Constructor");
    this.name   = Person.DEFAULT_NAME;
    this.age    = 1;
    this.salary = 0.0;
    this.hair   = Hair.BLACK;
  }

  public Double getSalary()
  {
    logger.exiting(this.getClass().getName(), "getSalary", salary);
    return salary;
  }

  public Hair getHair()
  {
    logger.exiting(this.getClass().getName(), "getHair", this.hair);
    return this.hair;
  }

  public void plusYear()
  {
    logger.entering(this.getClass().getName(), "plusYear");
    age++;
    logger.exiting(this.getClass().getName(), "plusYear", age);
  }

  public Person clone() throws CloneNotSupportedException
  {
    logger.exiting(this.getClass().getName(), "clone", new Object[]{this});
    return (Person) super.clone();
  }

}
