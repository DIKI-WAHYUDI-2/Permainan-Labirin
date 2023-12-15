package com.example.mazegame;

import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;

public class MazeSolver implements Runnable {
    private Maze maze;
    private boolean[][] visited;
    private int startRow;
    private int startCol;
    private MazeApp mazeApp;
    private GraphicsContext gc;

    public MazeSolver(Maze maze, boolean[][] visited, int startRow, int startCol, MazeApp mazeApp, GraphicsContext gc) {
        this.maze = maze;
        this.visited = visited;
        this.startRow = startRow;
        this.startCol = startCol;
        this.mazeApp = mazeApp;
        this.gc = gc;
    }

    @Override
    public void run() {
        depthFirstSearch(startRow, startCol);
        mazeApp.setSolving(false);
    }

    private boolean depthFirstSearch(int row, int col) {

        if (isValidMove(row, col) && !visited[row][col]) {
            visited[row][col] = true;


            if (row == maze.getMaze().length - 1 && col == maze.getMaze()[0].length - 1) {
                maze.getMaze()[row][col] = '*';
                Platform.runLater(() -> {
                    mazeApp.drawMaze(gc);
                    mazeApp.drawPlayer(gc);
                });

                return true;
            }

            maze.getMaze()[row][col] = '*';
            Platform.runLater(() -> {
                mazeApp.drawMaze(gc);
                mazeApp.drawPlayer(gc);
            });

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //Atas
            if (depthFirstSearch(row - 1, col)) return true;
            //Kanan
            if (depthFirstSearch(row, col + 1)) return true;
            //Bawah
            if (depthFirstSearch(row + 1, col)) return true;
            //Kiri
            if (depthFirstSearch(row, col - 1)) return true;

            maze.getMaze()[row][col] = ' ';
            visited[row][col] = false;
            Platform.runLater(() -> {
                mazeApp.drawMaze(gc);
                mazeApp.drawPlayer(gc);
            });

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private boolean isValidMove(int row, int col) {
        if (row >= 0 && row < maze.getMaze().length && col >= 0 && col < maze.getMaze()[0].length) {
            return maze.getMaze()[row][col] == '.' || maze.getMaze()[row][col] == '*';
        }
        return false;
    }
}
