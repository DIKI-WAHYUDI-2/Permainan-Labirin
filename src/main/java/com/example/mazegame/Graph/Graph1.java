package com.example.mazegame.Graph;

import java.util.*;

public class Graph1 {

    private LinkedList<Vertice> vertice;
    private LinkedList<Edge> edges;
    public Graph1(char[][] maze){
        vertice = new LinkedList<>();
        edges = new LinkedList<>();
        addVerticesAndEdges(maze);
    }

    private void addVertice(char[][] maze){
        int rows = maze.length;
        int cols = maze[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (maze[i][j] == '.'){
                    Vertice vertex = new Vertice(i,j);
                    vertice.add(vertex);
                }
            }
        }
    }

    private void addEdges(Vertice vertex, char[][] maze) {
        int rows = vertex.getRow();
        int cols = vertex.getCol();

        // Check neighboring vertices
        if (rows > 0 && maze[rows - 1][cols] == '.') {
            Vertice neighbor = new Vertice(rows - 1, cols);
            edges.add(new Edge(vertex, neighbor));
        }

        if (rows < maze.length - 1 && maze[rows + 1][cols] == '.') {
            Vertice neighbor = new Vertice(rows + 1, cols);
            edges.add(new Edge(vertex, neighbor));
        }

        if (cols > 0 && maze[rows][cols - 1] == '.') {
            Vertice neighbor = new Vertice(rows, cols - 1);
            edges.add(new Edge(vertex, neighbor));
        }

        if (cols < maze[0].length - 1 && maze[rows][cols + 1] == '.') {
            Vertice neighbor = new Vertice(rows, cols + 1);
            edges.add(new Edge(vertex, neighbor));
        }
    }

    private void addVerticesAndEdges(char[][] maze) {
        int rows = maze.length;
        int cols = maze[0].length;

        // Add vertices
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (maze[i][j] == '.') {
                    Vertice vertex = new Vertice(i, j);
                    vertice.add(vertex);

                    // Check neighboring vertices and add edges
                    addEdges(vertex, maze);
                }
            }
        }
    }

    public void printVertices() {
        System.out.println("All Vertices:");

        for (Vertice vertex : vertice) {
            System.out.println("(" + vertex.getRow() + ", " + vertex.getCol() + ")");
        }
    }

    public void printEdges() {
        System.out.println("All Edges:");

        for (Edge edge : edges) {
            System.out.println(edge.getStart() + " -> " + edge.getEnd());
        }
    }
    public static void main(String[] args) {
        char[][] maze = {
                {'.', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'},
                {'.', '.', '0', '.', '0', '.', '0', '.', '.', '.', '.', '.', '0'},
                {'0', '.', '0', '.', '.', '.', '0', '.', '0', '0', '0', '.', '0'},
                {'0', '.', '.', '.', '0', '0', '0', '.', '.', '.', '.', '.', '0'},
                {'0', '.', '0', '.', '.', '.', '.', '.', '0', '0', '0', '.', '0'},
                {'0', '.', '0', '.', '0', '0', '0', '.', '0', '.', '.', '.', '0'},
                {'0', '.', '0', '.', '0', '.', '.', '.', '0', '0', '0', '.', '0'},
                {'0', '.', '0', '.', '0', '0', '0', '.', '0', '.', '0', '.', '0'},
                {'0', '.', '.', '.', '.', '.', '.', '.', '.', '.', '0', '.', '0'},
                {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '.', '.'}
        };

        Graph1 graph1 = new Graph1(maze);
        graph1.printVertices();
        graph1.printEdges();
    }
}
