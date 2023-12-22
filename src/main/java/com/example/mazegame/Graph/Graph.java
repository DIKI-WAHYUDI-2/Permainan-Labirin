package com.example.mazegame.Graph;

import javafx.application.Platform;

import java.util.*;

public class Graph {

    private int rows;
    private int cols;
    private List<Vertice>[][] adjacencyList;
    private List<List<Vertice>> dfsGroups;
    public Graph(char[][] maze) {
        this.rows = maze.length;
        this.cols = maze[0].length;
        this.adjacencyList = new ArrayList[rows][cols];
        this.dfsGroups = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                adjacencyList[i][j] = new ArrayList<>();

                if (maze[i][j] == '.') {

                    //atas
                    if (i - 1 >= 0 && maze[i - 1][j] == '.') {
                        adjacencyList[i][j].add(new Vertice(i - 1, j));
                    }
                    //kanan
                    if (j + 1 < cols && maze[i][j + 1] == '.') {
                        adjacencyList[i][j].add(new Vertice(i, j + 1));
                    }
                    //bawah
                    if (i + 1 < rows && maze[i + 1][j] == '.') {
                        adjacencyList[i][j].add(new Vertice(i + 1, j));
                    }
                    //kiri
                    if (j - 1 >= 0 && maze[i][j - 1] == '.') {
                        adjacencyList[i][j].add(new Vertice(i, j - 1));
                    }
                }
            }
        }
    }
    public List<Vertice> getAllVertice() {
        Set<Vertice> allVerticeSet = new HashSet<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                allVerticeSet.addAll(adjacencyList[i][j]);
            }
        }

        List<Vertice> sortedVertices = new ArrayList<>(allVerticeSet);
        Collections.sort(sortedVertices, Comparator.comparingInt(vertice -> vertice.row * cols + vertice.col));

        return sortedVertices;
    }

    public List<Vertice> getNeighbors(Vertice vertice) {
        int row = vertice.row;
        int col = vertice.col;

        return adjacencyList[row][col];
    }

    public void printNodesWithNeighbors() {
        System.out.println("ADJACENCY OF LIST");
        List<Vertice> allVertices = getAllVertice();

        for (Vertice vertice : allVertices) {
            System.out.print("Node (" + vertice.row + ", " + vertice.col + ") -> ");
            List<Vertice> neighbors = getNeighbors(vertice);

            for (Vertice neighbor : neighbors) {
                System.out.print("(" + neighbor.row + ", " + neighbor.col + "), ");
            }

            System.out.println();
        }

        System.out.println();
    }

    public void findRoute(Vertice startVertice, Vertice stopVertice) {
        System.out.println("DFS");
        boolean[][] visited = new boolean[rows][cols];
        dfsGroups.clear();  // Bersihkan kelompok sebelum setiap DFS
        dfs(startVertice, visited, stopVertice, new ArrayList<>());
    }

    private void dfs(Vertice currentVertice, boolean[][] visited, Vertice stopVertice, List<Vertice> currentGroup) {
        int row = currentVertice.row;
        int col = currentVertice.col;

        visited[row][col] = true;
        currentGroup.add(new Vertice(row, col));

        // Print the current group
        System.out.print("{ ");
        for (Vertice vertice : currentGroup) {
            System.out.print("(" + vertice.row + ", " + vertice.col + "), ");
        }
        System.out.println("}");

        // Check if the stop node is reached
        if (currentVertice.equals(stopVertice)) {
            System.out.println("Stop node reached!");
            dfsGroups.add(new ArrayList<>(currentGroup));
            visited[row][col] = false; // Reset visited status for backtracking
            return;
        }

        Platform.runLater(() ->{


        });

        List<Vertice> neighbors = getNeighbors(currentVertice);
        for (Vertice neighbor : neighbors) {
            int neighborRow = neighbor.row;
            int neighborCol = neighbor.col;

            if (!visited[neighborRow][neighborCol]) {
                dfs(neighbor, visited, stopVertice, currentGroup);

                // Setelah menemukan jalur, hentikan pencarian
                if (!dfsGroups.isEmpty()) {
                    return;
                }
            }
        }

        // Backtrack: Remove the last node from the current group dan reset visited status
        currentGroup.remove(currentGroup.size() - 1);
        visited[row][col] = false;
    }


}
