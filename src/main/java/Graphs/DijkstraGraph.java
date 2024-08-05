package Graphs;

import java.util.HashMap;

public class DijkstraGraph implements Graph<DijkstraNode> {

    private HashMap<String, DijkstraNode> nodes = new HashMap<>();

    @Override
    public void addNode(DijkstraNode node) {
        nodes.put(node.getId(), node);
    }

    @Override
    public DijkstraNode getNode(DijkstraNode dijkstraNode) {
        return null;
    }

    public void addNeighbour(String id, DijkstraNode node) {
        try {
            nodes.get(id).addNeighbour(node);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public HashMap<String, DijkstraNode> getNodes() {
        return nodes;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        for (var id : nodes.keySet()) {
            str.append(id).append(": ").append(nodes.get(id).neighbours).append("\n");
        }
        return str.toString();
    }
}
