package Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTests {

  public static void test()
  {

    Stream<Integer> intStream = Stream.of(1, 3, 45);
    intStream.filter(x->x>2)
      .forEach(
        x->{
          x++;
          System.out.println(x);});


    List<String> entryValues = new ArrayList<>( )
    {
      {add("Arron");}
      {add("Kick");}
      {add("Mugabe");}
      {add("Ketcelcoatl");}
    };
    entryValues.forEach(x->System.out.println(x));
    System.out.println();

    var modifiedValues =
      entryValues.stream()
        .filter(x->{return  x.length() > 4;})
        .map(x->{ return x.toUpperCase() + 1;})
        .collect(Collectors.toList());
    modifiedValues.forEach(x->{System.out.println(x);});


  }
}
