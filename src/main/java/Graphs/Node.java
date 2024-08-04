package Graphs;

public abstract class Node<Id> {
    protected Id id;

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }
}
