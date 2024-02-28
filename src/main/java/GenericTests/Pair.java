package GenericTests;

import Events.Persons.Person;

import java.util.function.Supplier;


/**
 * Test class for Generics.
 * @param <T> Content type of Pair generic class.
 */
public class Pair<T> {

  private T[] content;

  /**
   * First element of Pair class.
   */
  private T firs;
  /**
   * Second element of Pair class.
   */
  private T second;

  /**
   * Constructor without parameters initializes first and second fields by NULL value.
   */
  public Pair() {
    this.firs = null;
    this.second = null;
  }


  /**
   * Constructor that initializes first and second fields by concrete values.
   * @param first Init value.
   * @param second Init value.
   */
  public Pair(T first, T second) {
    this.firs = first;
    this.second = second;
  }

  /**
   * Set first element of Pair.
   * @param value New value.
   */
  public void setFirst(T value) {
    this.firs = value;
  }

  /**
   *Set second element of Pair.
   * @param value New value.
   */
  public void setSecond(T value) {
    this.second = value;
  }

  /**
   * Getter of first field.
   * @return First value.
   */
  public T getFirs() {
    return firs;
  }

  /**
   * Getter of second field.
   * @return Second value.
   */
  public T getSecond() {
    return second;
  }


  /**
   * Create Pair object through supplier functional interface.
   * @param constructor Realisation of object constructor.
   * @param <T> Generic type of Pair content.
   * @return Returns Pair object.
   */
  public static <T> Pair<T> makePair(Supplier<T> constructor)
  {
    return new Pair<>(constructor.get(), constructor.get());
  }
}
