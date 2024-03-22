package TmpTests;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Class for temporary tests.
 */
public class AnyTestClass {

  public static void main(String... args)
  {
    test_one();
    test_two();
  }

  private static void test_one()
  {
    List<String> strings = List.of("1", "2", "2");
    HashMap<Integer, String> collect = new HashMap<>();
    for (String string : strings) {
      collect.put(Integer.parseInt(string), string);// (2)
    }
    collect.forEach((k, v) -> System.out.println(k + " " + v));
  }

  private static void test_two()
  {
    List<String> strings = List.of("1", "2", "2");
    Map<Integer, String> collect = strings.stream().collect(Collectors.toMap(Integer::parseInt, s -> s));// (1)
    collect.forEach((k, v) -> System.out.println(k + " " + v));
  }
}
