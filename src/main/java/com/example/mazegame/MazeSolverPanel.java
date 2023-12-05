package com.example.mazegame;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MazeSolverPanel extends Canvas implements Runnable {
    private char[][] maze = {
            {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'},
            {'.', '.', '0', '.', '0', '.', '0', '.', '.', '.', '.', '.', '0'},
            {'0', '.', '0', '.', '.', '.', '0', '.', '0', '0', '0', '.', '0'},
            {'0', '.', '.', '.', '0', '0', '0', '.', '.', '.', '.', '.', '0'},
            {'0', '.', '0', '.', '.', '.', '.', '.', '0', '0', '0', '.', '0'},
            {'0', '.', '0', '.', '0', '0', '0', '.', '0', '.', '.', '.', '0'},
            {'0', '.', '0', '.', '0', '.', '.', '.', '0', '0', '0', '.', '0'},
            {'0', '.', '0', '.', '0', '0', '0', '.', '0', '.', '0', '.', '0'},
            {'0', '.', '.', '.', '.', '.', '.', '.', '.', '.', '0', '.', '0'},
            {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '.', '0'}
    };

    private boolean[][] visited;
    private GraphicsContext gc;

    public MazeSolverPanel(double width, double height) {
        super(width, height);
        this.visited = new boolean[maze.length][maze[0].length];
        this.gc = getGraphicsContext2D();
    }

    public char[][] getMaze() {
        return maze;
    }

    public void drawMaze() {
        double cellWidth = getWidth() / maze[0].length;
        double cellHeight = getHeight() / maze.length;

        for (int j = 0; j < maze[0].length; j++) {
            for (int i = 0; i < maze.length; i++) {
                Color color;
                switch (maze[i][j]) {
                    case '.':
                        color = Color.WHITE;
                        break;
                    case '0':
                        color = Color.BLACK;
                        break;
                    case '*':
                        color = Color.BLUE;
                        break;
                    default:
                        color = Color.WHITE;
                        break;
                }
                gc.setFill(color);
                gc.fillRect(j * cellWidth, i * cellHeight, cellWidth, cellHeight);
                gc.setStroke(Color.BLACK);
                gc.setLineWidth(1.0);
                gc.strokeRect(j * cellWidth, i * cellHeight, cellWidth, cellHeight);
            }
        }
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        MazeSolver mazeSolver = new MazeSolver(maze, this);

        if (mazeSolver.solveMaze()) {
            System.out.println("SOLVED maze");
        } else {
            System.out.println("Could NOT SOLVE maze");
        }
    }

    private class MazeSolver {
        private char[][] maze;
        private MazeSolverPanel mazeSolverPanel;

        public MazeSolver(char[][] maze, MazeSolverPanel mazeSolverPanel) {
            this.maze = maze;
            this.mazeSolverPanel = mazeSolverPanel;
        }

        public boolean solveMaze() {
            return depthFirstSearch(0, 0);
        }

        private boolean isValidSpot(int r, int c) {
            if (r >= 0 && r < maze.length && c >= 0 && c < maze[0].length) {
                return maze[r][c] == '.';
            }
            return false;
        }

        private boolean depthFirstSearch(int r, int c) {
            if (isValidSpot(r, c) && !visited[r][c]) {
                visited[r][c] = true;

                if (r == maze.length - 1 && c == maze[0].length - 1) {
                    maze[r][c] = '*';
                    mazeSolverPanel.drawMaze();
                    sleep();
                    return true;
                }

                maze[r][c] = '*';
                mazeSolverPanel.drawMaze();
                sleep();

                if (depthFirstSearch(r - 1, c)) {
                    return true;
                }

                if (depthFirstSearch(r, c + 1)) {
                    return true;
                }

                if (depthFirstSearch(r + 1, c)) {
                    return true;
                }

                if (depthFirstSearch(r, c - 1)) {
                    return true;
                }

                maze[r][c] = ' ';
                visited[r][c] = false;
                mazeSolverPanel.drawMaze();
                sleep();
            }
            return false;
        }

        private void sleep() {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

