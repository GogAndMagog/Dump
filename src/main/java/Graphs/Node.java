package Graphs;

public class Node {
    private Coordinates coordinates;

    private int heuristic;
    private int cost;
    private long priority;

    public Node(Coordinates coordinates, int cost, int heuristic, long priority) {
        this.coordinates = coordinates;
        this.cost = cost;
        this.heuristic = heuristic;
        this.priority = priority;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public long getPriority() {
        return priority;
    }

    public void setPriority(long priority) {
        this.priority = priority;
    }

    public int getHeuristic() {
        return heuristic;
    }

    public void setHeuristic(int heuristic) {
        this.heuristic = heuristic;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
