package GenericTests;

import Events.Persons.Person;

/**
 * Interval class inherits form Pair class, it allows some restrictions on set methods of superclass.
 */
public class Interval<T extends Comparable> extends Pair<Person> {

  /**
   * Set first value only if it is lower than or equals to second value
   * @param value New value
   */
  public void setFirst(T value) {
    if (value.compareTo(getSecond()) <= 0)
      setFirst(value);
  }

  /**
   * Set second value only if it is greater than or equals to second value
   * @param value New value
   */
  public void setSecond(T value) {
    if (value.compareTo(getSecond()) <= 0)
      setSecond(value);
  }
}

