package Graphs;

import Graphs.DistanceCalculationHeuristic.ChebyshevDistanceCalculator;
import Graphs.DistanceCalculationHeuristic.DistanceCalculator;

import java.util.*;

public class AStarAlgorithm implements PathFinder{

    DistanceCalculator distanceCalculator = new ChebyshevDistanceCalculator();

    @Override
    public List<String> findPath(HashMap<String, HashMap<String, Node>> graph, String baseNode, String targetNode) {
        HashMap<String, Node> costs = createCosts(graph, baseNode);
        HashMap<String, String> parents = createParents(graph, baseNode);
        HashMap<String, Integer> neighbours = new HashMap<>();

        HashSet<String> passedNodes = new HashSet<>();

        int cost = Integer.MAX_VALUE;
        int newCost = 0;

        System.out.println(graph);

        String currentNode = findLowestCostNode(costs, passedNodes);
        System.out.println(currentNode);
        while (currentNode != null) {
            cost = costs.get(currentNode).getCost();
            neighbours = graph.get(currentNode);
            if (neighbours == null) {
                passedNodes.add(currentNode);
                currentNode = null;
                continue;
            }
            for (var neighbour : neighbours.keySet()) {
                newCost = cost + neighbours.get(neighbour);
                if (costs.get(neighbour).getCost() > newCost) {
                    costs.put(neighbour, newCost);
                    parents.put(neighbour, currentNode);
                }
            }
            passedNodes.add(currentNode);
            currentNode = findLowestCostNode(costs, passedNodes);
        }

        return restorePath(parents, baseNode, targetNode);
    }

    private HashMap<String, String> createParents(HashMap<String, HashMap<String, Integer>> graph, String baseNode) {
        HashMap parents = new HashMap<String, String>();
        for (var key : graph.keySet()) {
            parents.put(key, null);
        }

        HashMap baseNodeNeighbours = graph.get(baseNode);

        for (var neighbour : baseNodeNeighbours.keySet()) {
            if (parents.containsKey(neighbour)) {
                parents.put(neighbour, baseNode);
            }
        }

        System.out.println(parents);

        return parents;
    }

    private HashMap<String, Node> createCosts(HashMap<String, HashMap<String, Node>> graph, String baseNode) {
        HashMap<String, Node> costs = new HashMap<>();

        for (var node : graph.keySet()) {
            costs.put(node, new Node(new Coordinates(0,0), Integer.MAX_VALUE, Integer.MAX_VALUE, Long.MAX_VALUE));
        }

        var neighbours = graph.get(baseNode);
        for (var neighbourNode : neighbours.keySet()) {
            costs.put(neighbourNode, neighbourNode);
//            costs.put(neighbourNode, neighbours.get(neighbourNode));
        }

        System.out.println(costs);

        return costs;
    }

    private String findLowestCostNode(HashMap<String, Node> costs, HashSet<String> passed) {
        int lowestCost = Integer.MAX_VALUE;
        Node cost;

        String lowestCostNode = null;

        for (var node : costs.keySet()) {
            cost = costs.get(node);
//            if (cost < lowestCost && !(passed.contains(node))) {
//                lowestCost = cost;
//                lowestCostNode = node;
//            }
        }

        return lowestCostNode;
    }

    private List<String> restorePath(HashMap<String, String> parents, String baseNode, String targetNode) {
        List<String> path = new ArrayList<>();
        String currentNode = targetNode;

        while (currentNode != null) {
            path.add(currentNode);
            currentNode = parents.get(currentNode);
        }

        Collections.reverse(path);

        System.out.println(path);

        return path;
    }
}
