package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    List<GraphNode> nodes;
    Map<Integer, GraphNode> map;

    Graph(List<Integer> jobs) {
        nodes = new ArrayList<>();
        map = new HashMap<>();
        for (Integer job : jobs) {
            addNode(job);
        }
    }

    public void addNode(int job) {
        GraphNode node = new GraphNode(job);
        map.put(job, node);
        nodes.add(node);
    }

    public void addEdge(Integer start,Integer end) {
        GraphNode startNode = map.get(start);
        GraphNode endNode = map.get(end);
        startNode.children.add(endNode);
    }
}