package Graphs;

import Graphs.DistanceCalculationHeuristic.ChebyshevDistanceCalculator;
import Graphs.DistanceCalculationHeuristic.DistanceCalculator;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String... args) {
        Test test = new Test();

//        test.testDijkstra2();
        test.testAStarGraph2();

    }

    private void testDijkstra1() {
        Graph graph = createDijkstraGraph(3, 3); ;
        PathFinder pathFinder = new DijkstraAlgorithm();

        var node = ((DijkstraGraph) graph).getNodeByCoordinates(new Coordinates( 1, 1));
        node.setCost(3);

        var path = pathFinder.findPath(graph, "0", "8");

        System.out.println(path);
    }

    private void testDijkstra2() {
        Graph graph = createDijkstraGraph(5, 5); ;
        PathFinder pathFinder = new DijkstraAlgorithm();

        var node = ((DijkstraGraph) graph).getNodeByCoordinates(new Coordinates( 1, 0));
        node.setCost(2);
        node = ((DijkstraGraph) graph).getNodeByCoordinates(new Coordinates( 1, 1));
        node.setCost(10);
        node = ((DijkstraGraph) graph).getNodeByCoordinates(new Coordinates( 1, 2));
        node.setCost(10);
        node = ((DijkstraGraph) graph).getNodeByCoordinates(new Coordinates( 1, 3));
        node.setCost(10);

        var path = pathFinder.findPath(graph,
                "0",
                ((DijkstraGraph) graph).getNodeByCoordinates(new Coordinates( 4, 4)).getId());

        System.out.println(path);
    }

    private void testAStarGraph2() {
        DistanceCalculator distanceCalculator = new ChebyshevDistanceCalculator();
        PathFinder pathFinder = new AStarAlgorithm(distanceCalculator);
        Graph graph = createAStarGraph(5, 5);

        var node = ((AStarGraph) graph).getNodeByCoordinates(new Coordinates( 1, 0));
        node.setCost(10);
        node = ((AStarGraph) graph).getNodeByCoordinates(new Coordinates( 1, 1));
        node.setCost(10);
        node = ((AStarGraph) graph).getNodeByCoordinates(new Coordinates( 1, 2));
        node.setCost(2);
        node = ((AStarGraph) graph).getNodeByCoordinates(new Coordinates( 1, 3));
        node.setCost(10);

        var path = pathFinder.findPath(graph,
                "0",
                ((AStarGraph) graph).getNodeByCoordinates(new Coordinates( 4, 4)).getId());

        System.out.println(path);
    }

    private void testAStarGraph1() {
        DistanceCalculator distanceCalculator = new ChebyshevDistanceCalculator();
        PathFinder pathFinder = new AStarAlgorithm(distanceCalculator);
        AStarGraph graph = createAStarGraph(3, 3);

        var node = graph.getNodeById("1");
        node.setCost(5);

        var path = pathFinder.findPath(graph, "0", "8");

        System.out.println(path);
    }

    private DijkstraGraph createDijkstraGraph(int n, int m)
    {
        DijkstraGraph dijkstraGraph = new DijkstraGraph();
        Coordinates coordinates;
        int id = 0;


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                coordinates = new Coordinates(i, j);
                dijkstraGraph.addNode(new DijkstraNode(Integer.toString(id), coordinates, 1));
                id++;
            }
        }

        for (var node : dijkstraGraph.getNodes()) {
            var neighbors = getNeighbours(node.getCoordinates(), n, m);
            for (var neighbor : neighbors) {
                dijkstraGraph.addNeighbour(node.getId(), dijkstraGraph.getNodeByCoordinates(neighbor));
            }
        }

        return dijkstraGraph;
    }

    private AStarGraph createAStarGraph(int n, int m)
    {
        AStarGraph dijkstraGraph = new AStarGraph();
        Coordinates coordinates;
        int id = 0;


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                coordinates = new Coordinates(i, j);
                dijkstraGraph.addNode(new AStarNode(Integer.toString(id), coordinates, 1));
                id++;
            }
        }

        for (var node : dijkstraGraph.getNodes()) {
            var neighbors = getNeighbours(node.getCoordinates(), n, m);
            for (var neighbor : neighbors) {
                dijkstraGraph.addNeighbour(node.getId(), dijkstraGraph.getNodeByCoordinates(neighbor));
            }
        }

        return dijkstraGraph;
    }

//    private AStarGraph<Coordinates, AStarNode> createAstarGraph(int n, int m) {
//        AStarGraph<Coordinates, AStarNode> AStarGraph = new AStarGraph<>();
//        Coordinates coordinates = new Coordinates(0, 0);
//        int id = 0;
//
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                coordinates = new Coordinates(i, j);
//                AStarGraph.addNode(coordinates, new AStarNode(coordinates, Integer.toString(id), 0, 0, 0));
//                id++;
//            }
//        }
//
//        for (var node : AStarGraph.nodes.keySet()) {
//            var neighbors = getNeighbours(node, n, m);
//            for (var neighbor : neighbors) {
//                AStarGraph.addNeighbour(node, AStarGraph.getNode(neighbor));
//            }
//        }
//
//        return AStarGraph;
//    }

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
