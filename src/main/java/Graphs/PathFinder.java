package Graphs;

import java.util.HashMap;
import java.util.List;

public interface PathFinder {
  public List<String> findPath(HashMap<String, HashMap<String, AStarNode>> graph, String baseNode, String targetNode);
}
