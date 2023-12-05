package com.example.mazegame;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MazeSolverApp extends Application {

    private static final int CELL_SIZE = 30;
    private static final int MAZE_WIDTH = 13;
    private static final int MAZE_HEIGHT = 10;

    private char[][] maze = {

            {'.', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'},
            {'.', '.', '0', '.', '0', '.', '0', '.', '.', '.', '.', '.', '0'},
            {'0', '.', '0', '.', '.', '.', '0', '.', '0', '0', '0', '.', '0'},
            {'0', '.', '.', '.', '0', '0', '0', '.', '.', '.', '.', '.', '0'},
            {'0', '.', '0', '.', '.', '.', '.', '.', '0', '0', '0', '.', '0'},
            {'0', '.', '0', '.', '0', '0', '0', '.', '0', '.', '.', '.', '0'},
            {'0', '.', '0', '.', '0', '.', '.', '.', '0', '0', '0', '.', '0'},
            {'0', '.', '0', '.', '0', '0', '0', '.', '0', '.', '0', '.', '0'},
            {'0', '.', '.', '.', '.', '.', '.', '.', '.', '.', '0', '.', '0'},
            {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '.', '.'} // row = 9/ col = 12
    };

    private boolean[][] visited;
    private int playerRow = 0;
    private int playerCol = 0;


    @Override
    public void start(Stage primaryStage) {

        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        BorderPane root = new BorderPane();
        Canvas canvas = new Canvas(MAZE_WIDTH * CELL_SIZE, MAZE_HEIGHT * CELL_SIZE);
        root.setCenter(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Add DFS button
        Label dfsButton = new Label("DFS");
        dfsButton.setOnMouseClicked(event -> solveMaze(gc));
        root.setBottom(dfsButton);

        initializeMaze();
        drawMaze(gc);
        drawPlayer(gc);

        // Handle player movement
        canvas.setOnKeyPressed(e -> movePlayer(e.getCode(), gc));

        Scene scene = new Scene(root, bounds.getWidth(), bounds.getHeight());
        scene.setOnKeyPressed(e -> movePlayer(e.getCode(), gc));  // Tambahkan handler ke event scene

        primaryStage.setScene(scene);
        primaryStage.setTitle("Maze Solver");
        primaryStage.show();
    }

    private void initializeMaze() {
        visited = new boolean[MAZE_HEIGHT][MAZE_WIDTH];
        playerRow = 0;
        playerCol = 0;
    }

    private void drawMaze(GraphicsContext gc) {
        for (int j = 0; j < MAZE_WIDTH; j++) {
            for (int i = 0; i < MAZE_HEIGHT; i++) {
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
                gc.fillRect(j * CELL_SIZE, i * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                gc.setStroke(Color.BLACK);
                gc.strokeRect(j * CELL_SIZE, i * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            }
        }
    }

    private void drawPlayer(GraphicsContext gc) {
        gc.setFill(Color.RED);
        gc.fillOval(playerCol * CELL_SIZE, playerRow * CELL_SIZE, CELL_SIZE, CELL_SIZE);
    }


    private boolean isSolving = false;
    private void movePlayer(KeyCode code, GraphicsContext gc) {
        if (!isSolving) {
            int rowChange = 0;
            int colChange = 0;

            switch (code) {
                case UP:
                    rowChange = -1;
                    break;
                case DOWN:
                    rowChange = 1;
                    break;
                case LEFT:
                    colChange = -1;
                    break;
                case RIGHT:
                    colChange = 1;
                    break;
            }

            int newRow = playerRow + rowChange;
            int newCol = playerCol + colChange;

            if (isValidMove(newRow, newCol)) {
                playerRow = newRow;
                playerCol = newCol;

                drawMaze(gc);
                drawPlayer(gc);
            }
        }
    }


    private boolean isValidMove(int row, int col) {
        if (row >= 0 && row < MAZE_HEIGHT && col >= 0 && col < MAZE_WIDTH) {
            return maze[row][col] == '.' || maze[row][col] == '*'; // Ijinkan pemain melewati jalur solusi yang berwarna biru
        }
        return false;
    }

    private void solveMaze(GraphicsContext gc) {
        isSolving = true;
        MazeSolver mazeSolver = new MazeSolver(maze, visited, playerRow, playerCol, this, gc);
        new Thread(mazeSolver).start();
    }


    private class MazeSolver implements Runnable {
        private char[][] maze;
        private boolean[][] visited;
        private MazeSolverApp mazeSolverApp;
        private GraphicsContext gc;
        private int startRow;
        private int startCol;

        public MazeSolver(char[][] maze, boolean[][] visited, int startRow, int startCol, MazeSolverApp mazeSolverApp, GraphicsContext gc) {
            this.maze = maze;
            this.visited = visited;
            this.startRow = startRow;
            this.startCol = startCol;
            this.mazeSolverApp = mazeSolverApp;
            this.gc = gc;
        }

        @Override
        public void run() {
            depthFirstSearch(startRow, startCol);
            isSolving = false;
        }

        private boolean depthFirstSearch(int row, int col) {
            if (isValidMove(row, col) && !visited[row][col]) {
                visited[row][col] = true;

                if (row == MAZE_HEIGHT - 1 && col == MAZE_WIDTH - 1) {
                    maze[row][col] = '*';
                    Platform.runLater(() -> {
                        drawMaze(gc);
                        drawPlayer(gc);
                    });

                    return true; // Hentikan rekursi jika goal ditemukan
                }

                maze[row][col] = '*';
                Platform.runLater(() -> {
                    drawMaze(gc);
                    drawPlayer(gc);
                });

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (depthFirstSearch(row - 1, col)) return true;
                if (depthFirstSearch(row, col + 1)) return true;
                if (depthFirstSearch(row + 1, col)) return true;
                if (depthFirstSearch(row, col - 1)) return true;

                maze[row][col] = ' ';
                visited[row][col] = false;
                Platform.runLater(() -> {
                    drawMaze(gc);
                    drawPlayer(gc);
                });

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

