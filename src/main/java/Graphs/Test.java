package Graphs;

import java.util.HashMap;
import java.util.Map;

public class Test {

  public static void main(String... args) {
    HashMap<String, HashMap<String, Integer>> graph = new HashMap<>();
    PathFinder pathFinder = new DijkstraAlgorithm();

    //Nodes
    String start = "Start";
    String a = "A";
    String b = "B";
    String c = "C";
    String d = "D";
    String e = "E";

    //Creating test-graph
    HashMap<String, Integer> neighbours = new HashMap<>();
    neighbours.put(a, 6);
    neighbours.put(b, 2);

    graph.put(start, new HashMap<>(neighbours));

    neighbours.clear();
    neighbours.put(c, 1);

    graph.put(a, new HashMap<>(neighbours));

    neighbours.clear();
    neighbours.put(c, 1);

    graph.put(a, new HashMap<>(neighbours));

    neighbours.clear();
    neighbours.put(a, 3);
    neighbours.put(c, 5);

    graph.put(b, new HashMap<>(neighbours));

    neighbours.clear();
    neighbours.put(e, 10);
    neighbours.put(d, 5);
    graph.put(c, new HashMap<>(neighbours));

    neighbours.clear();
    graph.put(e, new HashMap<>(neighbours));

    neighbours.clear();
    neighbours.put(e, 4);
    graph.put(d, new HashMap<>(neighbours));

    //Testing algorithm
    pathFinder.findPath(graph, start, e);

    System.out.println(graph);
  }
}
