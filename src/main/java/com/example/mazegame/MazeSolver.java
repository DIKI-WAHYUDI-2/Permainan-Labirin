package com.example.mazegame;

import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;

public class MazeSolver implements Runnable {
    private Maze maze;
    private boolean[][] visited;
    private int startRow;
    private int startCol;
    private MazeEasy mazeEasy;
    private GraphicsContext gc;

    public MazeSolver(Maze maze, boolean[][] visited, int startRow, int startCol, MazeEasy mazeEasy, GraphicsContext gc) {
        this.maze = maze;
        this.visited = visited;
        this.startRow = startRow;
        this.startCol = startCol;
        this.mazeEasy = mazeEasy;
        this.gc = gc;
    }

    @Override
    public void run() {
        depthFirstSearch(startRow, startCol);
        mazeEasy.setSolving(false);
    }

    private boolean depthFirstSearch(int row, int col) {

        if (isValidMove(row, col) && !visited[row][col]) {
            visited[row][col] = true;


            if (row == maze.getMazeEasy().length - 1 && col == maze.getMazeEasy()[0].length - 1) {
                maze.getMazeEasy()[row][col] = '*';
                Platform.runLater(() -> {
                    mazeEasy.drawMaze(gc);
                    mazeEasy.drawPlayer(gc);
                });

                return true;
            }

            maze.getMazeEasy()[row][col] = '*';
            Platform.runLater(() -> {
                mazeEasy.drawMaze(gc);
                mazeEasy.drawPlayer(gc);
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

            maze.getMazeEasy()[row][col] = ' ';
            visited[row][col] = false;
            Platform.runLater(() -> {
                mazeEasy.drawMaze(gc);
                mazeEasy.drawPlayer(gc);
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
        if (row >= 0 && row < maze.getMazeEasy().length && col >= 0 && col < maze.getMazeEasy()[0].length) {
            return maze.getMazeEasy()[row][col] == '.' || maze.getMazeEasy()[row][col] == '*';
        }
        return false;
    }
}
