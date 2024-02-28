package Collections;

/**
 * Class that returns exact the same hashcode. Needed to make a collision.
 */
public class HashCodeTester
{
  /**
   * Default data.
   */
  private final static String DEFAULT_DATA = "Default";

  /**
   * Some value of the class. Needed for identify objects.
   */
  private String data;

  /**
   * Constructor without parameters will initialize data value "Default".
   */
  public HashCodeTester()
  {
    data = DEFAULT_DATA;
  }

  /**
   * Create object with specialized data.
   * @param initData Some data.
   */
  public HashCodeTester(String initData)
  {
    data = initData;
  }

  /**
   * Returns actual class-data.
   * @return Class-data.
   */
  public String getData()
  {
    return data;
  }

  /**
   * Overridden hashCode-method. Will return exact the same value.
   * @return Hashcode.
   */
  public int hashCode() {
    return 1;
  }

  /**
   * Overrided equals-method. Will return always "true" value.
   * @param obj Compared object.
   * @return Result of comparison.
   */
  public boolean equals(Object obj)
  {return true;}
}