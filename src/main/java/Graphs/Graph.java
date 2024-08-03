package Graphs;

import java.util.HashMap;

public class Graph<Id, T extends Node> {
    HashMap<Id, HashMap<Id, T>> nodes = new HashMap<>();

    public Graph() {}

    public void addNode(Id id) {
        nodes.put(id, new HashMap<>());
    }

    public void addNeighbours(Id id, Id neighbour, T node) {
        nodes.get(id).put(neighbour, node);
    }
}
