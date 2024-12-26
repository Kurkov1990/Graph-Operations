package app.controller;

import app.model.GraphModel;
import app.view.GraphView;

import java.util.Map;
import java.util.Set;


public class GraphController {
    private final GraphModel graphModel;
    private final GraphView graphView;

    public GraphController() {
        this.graphModel = new GraphModel();
        this.graphView = new GraphView();
    }

    public void printGraph() {
        System.out.println("Graph Adjacency List: ");
        for (Map.Entry<Integer, Set<Integer>> entry : graphModel.getAdjacencyList().entrySet()) {
            int vertex = entry.getKey();
            Set<Integer> neighbors = entry.getValue();
            for (int neighbor : neighbors) {
                if (vertex < neighbor) {
                    System.out.println(vertex + " -- " + neighbor);
                }
            }
        }
    }

    public void startApp() {
        graphModel.createTestGraph();
        graphView.showMessage("Show test Undirected Graph: ");
        printGraph();
        while (true) {
            int choice = graphView.getMenuChoice();
            switch (choice) {
                case 1 -> graphModel.addVertex(graphView.getVertexInput("Enter vertex to add: "));
                case 2 -> {
                    int source = graphView.getVertexInput("Enter source vertex: ");
                    int destination = graphView.getVertexInput("Enter destination vertex: ");
                    graphModel.addEdge(source, destination);
                }
                case 3 -> graphModel.removeVertex(graphView.getVertexInput("Enter vertex to remove: "));
                case 4 -> {
                    int source = graphView.getVertexInput("Enter source vertex: ");
                    int destination = graphView.getVertexInput("Enter destination vertex: ");
                    graphModel.removeEdge(source, destination);
                }
                case 5 ->
                        graphView.showResult("\nVertex exists: " + graphModel.hasVertex(graphView.getVertexInput("Enter vertex to check: ")));
                case 6 -> {
                    int source = graphView.getVertexInput("Enter source vertex: ");
                    int destination = graphView.getVertexInput("Enter destination vertex: ");
                    graphView.showResult("\nEdge exists: " + graphModel.hasEdge(source, destination));
                }
                case 7 -> printGraph();
                case 8 -> {
                    graphView.showMessage("\nExiting...");
                    return;
                }
                default -> graphView.showMessage("Invalid option. Please try again.");
            }
        }
    }
}

