package app.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GraphModel {

    private final Map<Integer, Set<Integer>> adjacencyList;

    public GraphModel() {
        this.adjacencyList = new HashMap<>();
    }

    public void addVertex(int vertex) {
        adjacencyList.putIfAbsent(vertex, new HashSet<>());
    }

    public void addEdge(int vertex1, int vertex2) {
        addVertex(vertex1);
        addVertex(vertex2);
        adjacencyList.get(vertex1).add(vertex2);
        adjacencyList.get(vertex2).add(vertex1);
    }

    public void removeVertex(int vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            System.out.println("Vertex does not exist.");
            return;
        }
        adjacencyList.remove(vertex);
        for (Set<Integer> edges : adjacencyList.values()) {
            edges.remove(vertex);
        }
    }

    public void removeEdge(int source, int destination) {
        if (!adjacencyList.containsKey(source)) {
            System.out.println("Source vertex does not exist. Edge not removed.");
            return;
        }
        if (!adjacencyList.containsKey(destination)) {
            System.out.println("Destination vertex does not exist. Edge not removed.");
            return;
        }
        boolean removedFromSource = adjacencyList.get(source).remove(destination);
        adjacencyList.get(destination).remove(source);

        if (!removedFromSource) {
        System.out.println("Edge from " + source + " to " + destination + " does not exist.");
    }
    }

    public boolean hasVertex(int vertex) {
        return adjacencyList.containsKey(vertex);
    }

    public boolean hasEdge(int source, int destination) {
        return adjacencyList.containsKey(source) && adjacencyList.get(source).contains(destination);
    }

    public Map<Integer, Set<Integer>> getAdjacencyList() {
        return adjacencyList;
    }

    public void createTestGraph() {
        addVertex(0);
        addVertex(1);
        addVertex(2);
        addVertex(3);
        addVertex(4);
        addVertex(5);
        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(0, 3);
        addEdge(1, 2);
        addEdge(2, 3);
        addEdge(3, 4);
        addEdge(1, 3);
        addEdge(4, 5);
        addEdge(3, 5);
    }
}

