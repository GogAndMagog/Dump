package Persons;

public class Manager extends Person {

  private Double bonus = 0.0;

  public Manager(String name, int age, Double salary)
  {
    super(name, age, salary);
  }

  public Manager(String name, int age, Double salary, Double bonus)
  {
    super(name, age, salary);
    this.bonus = bonus;
  }

  @Override
  public Double getSalary()
  {
    return (super.getSalary() + bonus);

  }

  public void setBonus(Double bonus)
  {
    this.bonus = bonus;
  }
}
