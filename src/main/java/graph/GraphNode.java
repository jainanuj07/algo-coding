package graph;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    public Integer nodeId;
    List<GraphNode> children;
    boolean visiting;
    boolean visited;

    GraphNode(Integer nodeId) {
        this.nodeId=nodeId;
        visited=false;
        visiting=false;
        children = new ArrayList<>();
    }
}
