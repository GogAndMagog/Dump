package Graphs;

public interface Graph<Id, Node> {
    public void addNode(Node node);
    public Node getNodeById(Id node);
}
