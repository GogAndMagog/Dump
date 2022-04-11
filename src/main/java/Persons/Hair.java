package Persons;

public enum Hair {

  BLACK("BLCK", "Black"),
  BLOND("BLND", "Blond"),
  BROWN("BRWN", "Brown"),
  GREEN("GRN", "Green"),
  RED("RED", "Red");

  private final String colorCode;
  private final String description;
  public String changable;

  private Hair( String colorCode,
                String description)
  {
    this.colorCode   = colorCode;
    this.description = description;
  }

  public String getColorCode()
  {
    return this.colorCode;
  }

  public String getDescription()
  {
    return this.description;
  }
}
