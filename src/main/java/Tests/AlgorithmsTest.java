package Tests;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class AlgorithmsTest {

  private static class Pair implements Comparable
  {
    private int           number;
    private String        description;
    private final String  defaultDescription = "Default description";
    private final int     defaultNumber = -1;

    Pair(int number, String description)
    {
      this.number = number;
      this.description = description;
    }

    Pair()
    {
      this.number = defaultNumber;
      this.description = defaultDescription;
    }

    public int getNumber ()
    { return  this.number; }

    public String getDescription()
    { return  this.description; }

    @Override
    public String toString()
    {
      StringBuilder sb = new StringBuilder();
      sb.append(this.getClass().getName() + " ");
      sb.append("Number: " + this.getNumber() + " ");
      sb.append("Description: " + this.getDescription());
      return  sb.toString();
    }

    @Override
    public int compareTo(@NotNull Object o) {
      Pair other = (Pair) o;
      if (this.getNumber() == other.getNumber())
        return 0;
      else if(this.getNumber() > other.getNumber())
        return -1;
      else
        return 1;
    }
  }

  public static void binarySearchTest()
  {
    List<Pair> pairs = new ArrayList<>(){{
        add(new Pair(2, "Aa"));
        add(new Pair(1, "Bbb"));
        add(new Pair(3,"Ccccc"));
        add(new Pair());
    }};


    pairs.sort((o1, o2) -> {  int result = (o1.getNumber() < o2.getNumber()) ? -1 : 1; return result; } );
    System.out.println();
    for (Pair p: pairs)
      System.out.println(p);
    System.out.println();

    Pair srcExample_1 = new Pair(3, "");
    Pair srcExample_2 = new Pair(3, "Aa");

    int i = Collections.binarySearch(pairs,
      srcExample_1,
      (o1, o2) -> {  int result = (o1.getNumber() < o2.getNumber()) ? -1 : 1; return result; });
    System.out.println(pairs.get(-i-1));

    Collections.shuffle(pairs);
    System.out.println();
    for (Pair p : pairs)
      System.out.println(p);
    System.out.println();

    i = Collections.binarySearch(pairs,
      srcExample_1,
      (o1, o2) -> {  int result = (o1.getNumber() < o2.getNumber()) ? -1 : 1; return result; });
    if ((-i-1) >= 0 && (-i-1) < pairs.size() ) {
      System.out.println("Index: " + (-i-1));
      System.out.println(pairs.get(-i-1)); }
    else
      System.out.println("Index: " + (-i-1));

    System.out.println();
    for (Pair p : pairs)
      System.out.println(p);
    System.out.println();

    pairs.sort((o1, o2) -> {  int result = (o1.getDescription().length() < o2.getDescription().length()) ? -1 : 1;
                              return result; });
    System.out.println();
    for (Pair p : pairs)
      System.out.println(p);
    System.out.println();

    i = Collections.binarySearch(pairs,
      srcExample_2,
      (o1, o2) -> {  int result = (o1.getDescription().length() < o2.getDescription().length()) ? -1 : 1;
      return result; });
    if ((-i-1) >= 0 && (-i-1) < pairs.size() ) {
      System.out.println("Index: " + (-i-1));
      System.out.println(pairs.get(-i-1)); }
    else
      System.out.println("Index: " + (-i-1));
  }

  public static void simpleAlgs() {

    List<String> strings = new ArrayList<>(){{
      add("StrPattern1");
      add("StrPattern2");
      add("StrPattern3");
      add("StrPattern4");
    }};
    System.out.println("Initialized values:");
    System.out.println(strings);
    System.out.println();

    System.out.println("Reverse elements.");
    Collections.reverse(strings);
    System.out.println("New values");
    System.out.println(strings);
    System.out.println();

    System.out.println();
    System.out.println("Remove string that ends with \"n3\".");
    strings.removeIf(s -> s.substring(9,11).equals("n3"));
    System.out.println("The remaining strings:");
    System.out.println(strings);
    System.out.println();

    System.out.println("Min string function.");
    String min = Collections.min(strings, (o1, o2) -> {
      int n1, n2, result = 0;

      try {
        n1 = Integer.parseInt(o1.substring(10,11));
        n2 = Integer.parseInt(o2.substring(10,11));

        result = (n1 > n2) ? 1 : -1;
      }
      catch (NumberFormatException e)
      {
        System.out.println(e.getCause());
      }

     return result;
    });
    System.out.println(min);
    System.out.println();

    System.out.println("Replace all func.");
    strings.replaceAll(s -> { s += ". Brave new world!";
                              return  s;});
    System.out.println("New values:");
    System.out.println(strings);
    System.out.println();

    System.out.println("Swap first and last strings.");
    Collections.swap(strings, 0, strings.size()-1);
    System.out.println("New values");
    System.out.println(strings);
    System.out.println();

    System.out.println("Fill all strings with the same value.");
    Collections.fill(strings, "Fill all!");
    System.out.println("New valuse:");
    System.out.println(strings);
    System.out.println();

    System.out.println("Strings in array:");
    var stringsArray = strings.toArray(new String[strings.size()]);
    System.out.println( Arrays.toString(stringsArray));
    System.out.println();

    var programProperties = System.getProperties();
    System.out.println("User home directory: " + programProperties.getProperty("user.home"));
    System.out.println("Java version: " + programProperties.getProperty("java.version"));
    System.out.println();

    try {
      programProperties.store(System.out, "Properties test");
    }
    catch (IOException e)
    {
      System.out.println("Error message: "
        + e.getMessage()
        + " Cause: "
        + e.getCause());
    }


  }

}
