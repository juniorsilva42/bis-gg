package br.com.bisgg.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class AdjacencyList {

    LinkedList<Node> nodes = new LinkedList<>();
    private Map<Node, LinkedList<Edges>> adj = new HashMap<Node, LinkedList<Edges>>();
    private LinkedList<Edges> edgesList;
    private LinkedList<Edges> edges;
    private AdjacencyList newList;

    public void addEdge (Node from, Node to) {

        nodes.add(from);
        if (!adj.containsKey(from)) {
            edgesList = new LinkedList<>();
            adj.put(from, edgesList);
        } else {
            edgesList = adj.get(from);
            adj.put(to, edgesList);
        }
    }

}
