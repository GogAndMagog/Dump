package Graphs;

public class Node {
    private int weight;
    private int priority;

    public Node(int weight, int priority) {
        this.weight = weight;
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
