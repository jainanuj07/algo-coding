package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {

    static List<Integer> getSortedOrder(List<Integer> jobs, List<Integer[]> deps) {
        Graph graph = new Graph(jobs);
        for (Integer[] dep : deps) {
            graph.addEdge(dep[0], dep[1]);
        }
        List<GraphNode> nodes = graph.nodes;
        List<Integer> sortedOrder = new ArrayList<>();
        for (GraphNode node : nodes) {
            if(node.visited == false) {
                if (!doDFS(node, sortedOrder))
                    return new ArrayList<>();
            }
        }
        return sortedOrder;
    }

    static boolean doDFS(GraphNode node,List<Integer>sortedOrder)
    {
        if(node.visiting == true) return false;
        if(node.visited == true) return true;
        node.visiting=true;
        List<GraphNode> children = node.children;
        for(GraphNode child: children) {
                if (!doDFS(child, sortedOrder))
                    return false;
        }
        node.visited = true;
        node.visiting=false;
        sortedOrder.add(0,node.nodeId);
        return true;

    }

    public static void main(String[] args) {
       /* List<Integer> jobs = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        Integer[][] depsArray = new Integer[][] {{3, 1}, {8, 1}, {8, 7}, {5, 7}, {5, 2},{1, 4},
                {6, 7},{1,2},{7, 6}
        };*/
        List<Integer> jobs = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
        Integer[][] depsArray = new Integer[][] {{1, 2}, {1, 3}, {3, 2}, {4, 2}, {4, 3},{2,4}};
        List<Integer[]> deps = new ArrayList<Integer[]>();
        fillDeps(depsArray, deps);
        System.out.println (getSortedOrder(jobs,deps).toString());
    }
    static void fillDeps(Integer[][] depsArray, List<Integer[]> deps) {
        for (Integer[] depArray : depsArray) {
            deps.add(depArray);
        }
    }
}
