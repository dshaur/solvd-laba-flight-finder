package com.solvd.block3.graphs;

import java.util.*;

public class Graph {
    private Map<Integer, Map<Integer, Double>> adjacencyMap;

    public Graph() {
        adjacencyMap = new HashMap<>(); // Create a new empty adjacency map
    }

    /**
     * Adds an edge to the graph between the source and destination vertices with the given weight.
     *
     * @param source      the source airport
     * @param destination the destination airport
     * @param weight      the price of the edge
     */
    public void addEdge(int source, int destination, double weight) {
        // Add the edge between source and destination with the given weight
        adjacencyMap.computeIfAbsent(source, k -> new HashMap<>()).put(destination, weight);
        adjacencyMap.computeIfAbsent(destination, k -> new HashMap<>()).put(source, weight);
    }

    /**
     * Finds the shortest path from the source vertex to the destination vertex using Dijkstra's algorithm.
     *
     * @param source      the source vertex
     * @param destination the destination vertex
     * @return the shortest path as a list of vertices
     */
    public List<Integer> shortestPath(int source, int destination) {
        // Initialize data structures for storing distances, previous vertices, and visited vertices
        Map<Integer, Double> distance = new HashMap<>();
        Map<Integer, Integer> previous = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        // Priority queue for storing vertices with their distances
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingDouble(n -> n.distance));
        queue.add(new Node(source, 0.0)); // Add the source vertex with distance 0

        distance.put(source, 0.0); // Set the distance of the source vertex to 0
        previous.put(source, null); // Set the previous vertex of the source vertex to null

        while (!queue.isEmpty()) {
            Node curr = queue.poll(); // Get the vertex with the smallest distance from the queue
            int currentVertex = curr.vertex;

            if (currentVertex == destination) {
                break; // If we reach the destination vertex, we have found the shortest path
            }

            if (visited.contains(currentVertex)) {
                continue; // Skip the vertex if it has already been visited
            }

            visited.add(currentVertex); // Mark the vertex as visited

            Map<Integer, Double> neighbors = adjacencyMap.get(currentVertex);
            if (neighbors == null) {
                continue; // Skip the vertex if it has no neighbors
            }

            for (Map.Entry<Integer, Double> neighbor : neighbors.entrySet()) {
                int neighborVertex = neighbor.getKey();
                double weight = neighbor.getValue();
                double newDistance = distance.get(currentVertex) + weight;

                // Update the distance and previous vertex if a shorter path is found
                if (!distance.containsKey(neighborVertex) || newDistance < distance.get(neighborVertex)) {
                    distance.put(neighborVertex, newDistance);
                    previous.put(neighborVertex, currentVertex);
                    queue.add(new Node(neighborVertex, newDistance));
                }
            }
        }

        // Build the shortest path from the previous vertices
        return buildPath(previous, destination);
    }

    /**
     * Builds the shortest path from the previous vertices.
     *
     * @param previous    the map of previous vertices
     * @param destination the destination vertex
     * @return the shortest path as a list of vertices
     */
    private List<Integer> buildPath(Map<Integer, Integer> previous, int destination) {
        List<Integer> path = new ArrayList<>();
        Integer curr = destination;

        // Traverse the previous vertices from the destination to the source to build the path
        while (curr != null) {
            path.add(0, curr);
            curr = previous.get(curr);
        }
        return path;
    }

    private static class Node {

        /**
         * ID of the airport
         */
        private int vertex;

        /**
         * Price of the flight
         */
        private double distance;

        public Node(int vertex, double distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

}
