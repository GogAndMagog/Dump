package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test {

    public static void main(String... args) {
        Test test = new Test();
        test.testNewGraph();

    }

    private void testDijkstra() {
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
//        pathFinder.findPath(graph, start, e);

        System.out.println(graph);
    }

    private void testNewGraph() {
        AStarGraph<Coordinates, AStarNode> AStarGraph = createGraph(3, 3);

        var node = AStarGraph.getNode(new Coordinates(1,1));
        node.setCost(5);
        System.out.println(AStarGraph);
    }

    private AStarGraph<Coordinates, AStarNode> createGraph(int n, int m) {
        AStarGraph<Coordinates, AStarNode> AStarGraph = new AStarGraph<>();
        Coordinates coordinates = new Coordinates(0, 0);
        int id = 0;


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                coordinates = new Coordinates(i, j);
                AStarGraph.addNode(coordinates, new AStarNode(coordinates, Integer.toString(id), 0, 0, 0));
                id++;
            }
        }

        for (var node : AStarGraph.nodes.keySet()) {
            var neighbors = getNeighbours(node, n, m);
            for (var neighbor : neighbors) {
                AStarGraph.addNeighbour(node, AStarGraph.getNode(neighbor));
            }
        }

        return AStarGraph;
    }

    public List<Coordinates> getNeighbours(Coordinates coordinates, int n, int m) {
        List<Coordinates> neighbors = new ArrayList<>();

        Coordinates tmpPosition = new Coordinates(coordinates.getX(), coordinates.getY() - 1);
        if (isAccessible(tmpPosition, n, m))
            neighbors.add(tmpPosition);

        tmpPosition = new Coordinates(coordinates.getX() + 1, coordinates.getY() - 1);
        if (isAccessible(tmpPosition, n, m))
            neighbors.add(tmpPosition);

        tmpPosition = new Coordinates(coordinates.getX() + 1, coordinates.getY());
        if (isAccessible(tmpPosition, n, m))
            neighbors.add(tmpPosition);

        tmpPosition = new Coordinates(coordinates.getX() + 1, coordinates.getY() + 1);
        if (isAccessible(tmpPosition, n, m))
            neighbors.add(tmpPosition);

        tmpPosition = new Coordinates(coordinates.getX(), coordinates.getY() + 1);
        if (isAccessible(tmpPosition, n, m))
            neighbors.add(tmpPosition);

        tmpPosition = new Coordinates(coordinates.getX() - 1, coordinates.getY() + 1);
        if (isAccessible(tmpPosition, n, m))
            neighbors.add(tmpPosition);

        tmpPosition = new Coordinates(coordinates.getX() - 1, coordinates.getY());
        if (isAccessible(tmpPosition, n, m))
            neighbors.add(tmpPosition);

        tmpPosition = new Coordinates(coordinates.getX() - 1, coordinates.getY() - 1);
        if (isAccessible(tmpPosition, n, m))
            neighbors.add(tmpPosition);

        return neighbors;
    }

    private boolean isAccessible(Coordinates coordinates, int n, int m) {
        return checkOutOfField(coordinates, n, m);
    }

    private boolean checkOutOfField(Coordinates coordinates, int n, int m) {
        if (coordinates.getX() >= n ||
                coordinates.getX() < 0 ||
                coordinates.getY() >= m ||
                coordinates.getY() < 0)
            return false;
        else
            return true;
    }

}
