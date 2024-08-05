package Graphs;

import java.util.HashMap;
import java.util.List;

public interface  PathFinder<Id,T extends Node> {
  public List<Coordinates> findPath(DijkstraGraph graph, Id baseNode, Id targetNode);
//  public List<T> findPath(HashMap<String, HashMap<String, AStarNode>> graph, String baseNode, String targetNode);
}
