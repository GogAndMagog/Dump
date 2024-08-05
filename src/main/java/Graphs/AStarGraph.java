package Graphs;

import java.util.HashMap;

public class AStarGraph<Coordinates, T extends AStarNode> {
//    HashMap<Coordinates, HashMap<Coordinates, T>> graph = new HashMap<>();
    HashMap<Coordinates, T> nodes = new HashMap<>();

    public AStarGraph() {
    }

    public void addNode(Coordinates coordinates, T node) {
        nodes.put(coordinates, node);
    }

    public T getNode(Coordinates coordinates) {return nodes.get(coordinates);}

    public void addNeighbour(Coordinates coordinates, T node) {
        try {
            nodes.get(coordinates).addNeighbour(node);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        for (Coordinates id : nodes.keySet()) {
            str.append(id).append(": ").append(nodes.get(id).neighbours).append("\n");
        }
        return str.toString();
    }
}
