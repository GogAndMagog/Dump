package Graphs;

import java.util.HashMap;

public class AStarNode {
    private Coordinates coordinates;

    String id;

    private int heuristic;
    private int cost;
    private long priority;

    HashMap<Coordinates, AStarNode> neighbours = new HashMap<>();

    public AStarNode(Coordinates coordinates, String id, int cost, int heuristic, long priority) {
        this.coordinates = coordinates;
        this.id = id;
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

    public HashMap<Coordinates, AStarNode> getNeighbours() {
        return neighbours;
    }

    public void addNeighbour(AStarNode neighbour) {
        neighbours.put(neighbour.getCoordinates(), neighbour);
    }

    @Override
    public String toString() {
        return "Node{" +
                "coordinates=" + coordinates +
                ", id=" + id +
                ", heuristic=" + heuristic +
                ", cost=" + cost +
                ", priority=" + priority +
                '}';
    }
}
