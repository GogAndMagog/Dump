package Streams;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTests {


  public static void main(String[] args) {
    test();
  }

  public static void test() {
    createOptional();
  }


  private static Stream<String> codePoints(String s) {
    var result = new ArrayList<String>();
    int i = 0;
    while (i < s.length()) {
      int j = s.offsetByCodePoints(i, 1);
      result.add(s.substring(i, j));
      i = j;
    }
    return result.stream();
  }

  private static void createOptional() {
    final String BASE = "Base";
    final String CRINGE = "Cringe";
    final String INITIAL = "Initial value: ";
    final String ADDITION = "addition";
    final String SPACE = " ";

    String testValue = "test value";
    List<String> tmpValues = new ArrayList<>();


    Optional<String> stringOptional = Optional.empty();
    Consumer<String> action = s -> tmpValues.add(new StringBuilder().append(INITIAL)
      .append(SPACE)
      .append(s)
      .toString());


    System.out.println(stringOptional.orElseGet(
      () -> new StringBuilder().append(BASE)
        .append("/")
        .append(CRINGE)
        .toString()));


    stringOptional = Optional.of(testValue);

    stringOptional.ifPresent(action);

    System.out.println(stringOptional.map(s -> new StringBuilder(s).append(SPACE)
      .append(ADDITION)).get());

    tmpValues.forEach(System.out::println);

    System.out.println(stringOptional.get());
  }


  public static void legacyTest() {

    Stream<Integer> intStream = Stream.of(1, 3, 45);
    intStream.filter(x -> x > 2)
      .forEach(
        x -> {
          x++;
          System.out.println(x);
        });


    List<String> entryValues = new ArrayList<>() {
      {
        add("Arron");
      }

      {
        add("Kick");
      }

      {
        add("Mugabe");
      }

      {
        add("Quetzalcoatl");
      }
    };
    entryValues.forEach(x -> System.out.println(x));
    System.out.println();

    var stream_1 = entryValues.stream()
      .filter(x -> {
        return x.length() > 4;
      })
      .map(String::toUpperCase);
    var stream_2 = entryValues.stream()
      .filter(x -> {
        return x.length() <= 4;
      })
      .map(x -> {
        return x.toLowerCase() + 1;
      });
    var modifiedValues = Stream.concat(stream_1, stream_2).collect(Collectors.toList());

    modifiedValues.forEach(x -> {
      System.out.println(x);
    });

    Stream<Double> infiniteStream = Stream.generate(Math::random);

    Object[] randoms = infiniteStream
      .peek(System.out::println)
      .limit(10)
      .toArray();
    System.out.println();

    Stream<String> flatRes = entryValues.stream().flatMap(w -> codePoints(w));
    flatRes.forEach(System.out::println);
    System.out.println();

    Arrays.stream(randoms).forEach(System.out::println);
    System.out.println();

    List<Integer> hundred = new ArrayList<>();
    hundred = Stream.iterate(500, integer -> integer += 1)
      .skip(100)
      .limit(101)
      .dropWhile(integer -> integer != 635)
      .takeWhile(integer -> integer <= 650)
      .collect(Collectors.toList());
    hundred.forEach(System.out::println);
    System.out.println();

    var uniqueWordsStream = Stream.of("Bob", "Anna", "Bob", "Bob")
      .distinct()
      .sorted(Comparator.comparing(String::length).reversed());
    uniqueWordsStream = uniqueWordsStream;
    var uniqueWords = uniqueWordsStream.collect(Collectors.toList());
    uniqueWords.forEach(System.out::println);
    System.out.println(uniqueWords.stream().max(Comparator.comparing(String::length)).orElse(""));
    uniqueWords.clear();
    System.out.println(uniqueWords.stream().max(Comparator.comparing(String::length)).orElse("List is empty"));
    System.out.println();

    Optional<String>
      optionalOne = Optional.of("Karen"), optionalTwo = Optional.of("Dick"), transformedOne = Optional.of("Dick"), transformedTwo = Optional.of("Dick");

    transformedOne = optionalOne
      .filter(s -> {
        return s.length() > 4;
      })
      .map(String::toUpperCase);
    transformedTwo = optionalTwo
      .filter(s -> {
        return s.length() > 4;
      })
      .map(String::toUpperCase);
    transformedOne.ifPresent(System.out::println);
    transformedTwo.ifPresent(System.out::println);

    var mapCollection_1 = entryValues.stream()
      .map(StreamTests::codePoints)
      .collect(Collectors.toList());
    var mapCollection_2 = entryValues.stream()
      .flatMap(StreamTests::codePoints)
      .collect(Collectors.toList());
    mapCollection_1.forEach(stringStream -> stringStream.forEach(System.out::println));
    mapCollection_2.forEach(System.out::println);

    uniqueWords.add("Bob");
    uniqueWords.add("Bob");
    uniqueWords.add("Bob");
    uniqueWords.add("Ann");
    uniqueWords.add("Ann");
    uniqueWords.add("John");
    uniqueWords.add("John");

    //Collecting data from stream
    System.out.println("Collecting data from stream:");
    var namesSet = uniqueWords.stream()
      .filter(s -> {
        if (s.substring(0, 1).equals("A"))
          return false;
        else
          return true;
      })
      .collect(Collectors.toCollection(TreeSet::new));

    System.out.println("Stream data:");
    uniqueWords.stream().forEach(System.out::println);
    System.out.println("Passed.\n");

    System.out.println("Set data:");
    namesSet.forEach(System.out::println);
    System.out.println("Passed.\n");

    String[] namesString = uniqueWords.toArray(String[]::new);
    System.out.println("Array data:");
    for (String nameString : namesString) {
      System.out.println(nameString);
    }
    System.out.println("Passed.\n");

    //Reduce the stream
    IntSummaryStatistics stats = uniqueWords.stream().collect(
      Collectors.summarizingInt(String::length)
    );
    System.out.println("Reduce the stream fot sum, avg and other:");
    System.out.printf("Max: %1d \n", stats.getMax());
    System.out.printf("Min: %1d \n", stats.getMin());
    System.out.printf("Sum: %1d \n", stats.getSum());

    var locales = Stream.of(Locale.getAvailableLocales());
    /*Map<String, Set<String>> countryLanguageSets = locales.collect(
      Collectors.toMap(
        Locale::getDisplayCountry,
        l -> Set.of(l.getDisplayLanguage()),
        (a, b) ->
        { // union of a and b
          Set<String> union = new HashSet<>(a);
          union.addAll(b);
          return union;
        }));
    System.out.println("countryLanguageSets: " + countryLanguageSets);*/

    Map<String, List<Locale>> countryToLocales = locales.collect(
      Collectors.groupingBy(Locale::getCountry));
    try {

      countryToLocales.get("RU").forEach(System.out::println);
      countryToLocales.get("UA").forEach(System.out::println);
      countryToLocales.get("US").forEach(System.out::println);
      countryToLocales.get("UK").forEach(System.out::println);
    }
    /*catch (NullPointerException e) {
//      e.printStackTrace();
      System.out.println(e.getCause() +
        " " +
        e.getClass().getName() +
        " " +
        e.getLocalizedMessage() +
        " " +
        Arrays.toString(e.getStackTrace()));
    }*/ catch (Exception e) {
//      e.printStackTrace();
      System.out.println(e.getCause() +
        " " +
        e.getClass().getName() +
        " " +
        e.getLocalizedMessage() +
        " " +
        Arrays.toString(e.getStackTrace()));


    }
  }


}
