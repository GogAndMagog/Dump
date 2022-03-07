package nestedPackage;

import java.util.Currency;

public class Person {
  private String  name;
  private int     age;
  Hair hair;

  private Double  salary;

  public int getAge() {
    return age;
  }

  public String getName() {
    return name;
  }

  public Person(String name, int age, Double salary, Hair hair)
  {
    this.name   = name;
    this.age    = age;
    this.salary = salary;
    this.hair   = hair;
  }

  public Double getSalary()
  {
    return salary;
  }

  public void plusYear()
  { age++; }
}
