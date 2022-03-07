import nestedPackage.Manager;
import nestedPackage.Person;

import javax.xml.namespace.QName;
import java.util.ArrayList;

public class Worker  {
  public static void main(String args[]) {

    {
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

      //for (i = 0; i < iterationsMax; i++)
      // {System.out.printf("%d\n", i + 1);}
    }

    Person mike;
    Manager joe,
            bob;
    ArrayList<Person> persons = new ArrayList<>();

    mike = new Person("Mike", 21, 5000.0);
    joe = new Manager("Joe", 45, 10000.0);
    bob = new Manager("Bob", 36, 10000.0, 1000.0);

    joe.setBonus(2000.0);
    persons.add(mike);
    persons.add(joe);
    persons.add(bob);

    getPersonSummary(persons);
  }

  private static void getPersonSummary(ArrayList<? extends Person> persons)
  {
    for (Person person: persons) {
      System.out.printf("Person: %s Age: %d Salary: %f\n",
        person.getName(),
        person.getAge(),
        person.getSalary());
    }
  }
}
