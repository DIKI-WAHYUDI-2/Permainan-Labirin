package com.example.mazegame;

import javafx.application.Application;
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
    private Maze maze;
    private boolean[][] visited;
    private int playerRow;
    private int playerCol;
    private boolean isSolving;

    private static final int CELL_SIZE = 30;
    private static final int MAZE_WIDTH = 13;
    private static final int MAZE_HEIGHT = 10;

    @Override
    public void start(Stage primaryStage) {
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        BorderPane root = new BorderPane();
        Canvas canvas = new Canvas(MAZE_WIDTH * CELL_SIZE, MAZE_HEIGHT * CELL_SIZE);
        root.setCenter(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        Label dfsButton = new Label("DFS");
        dfsButton.setOnMouseClicked(event -> solveMaze(gc));
        root.setBottom(dfsButton);

        initializeMaze();
        drawMaze(gc);
        drawPlayer(gc);

        canvas.setOnKeyPressed(e -> movePlayer(e.getCode(), gc));

        Scene scene = new Scene(root, bounds.getWidth(), bounds.getHeight());
        scene.setOnKeyPressed(e -> movePlayer(e.getCode(), gc));

        primaryStage.setScene(scene);
        primaryStage.setTitle("Maze Solver");
        primaryStage.show();
    }

    public void initializeMaze() {
        visited = new boolean[MAZE_HEIGHT][MAZE_WIDTH];
        playerRow = 0;
        playerCol = 0;

         char[][] mazeArray = {

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
        maze = new Maze(mazeArray);
    }

    public void drawMaze(GraphicsContext gc) {
        for (int j = 0; j < MAZE_WIDTH; j++) {
            for (int i = 0; i < MAZE_HEIGHT; i++) {
                Color color;
                switch (maze.getMaze()[i][j]) {
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

    public void drawPlayer(GraphicsContext gc) {
        gc.setFill(Color.RED);
        gc.fillOval(playerCol * CELL_SIZE, playerRow * CELL_SIZE, CELL_SIZE, CELL_SIZE);
    }

    public boolean isValidMove(int row, int col) {
        if (row >= 0 && row < MAZE_HEIGHT && col >= 0 && col < MAZE_WIDTH) {
            return maze.getMaze()[row][col] == '.' || maze.getMaze()[row][col] == '*';
        }
        return false;
    }

    public void movePlayer(KeyCode code, GraphicsContext gc) {
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

    public void solveMaze(GraphicsContext gc) {
        isSolving = true;
        MazeSolver mazeSolver = new MazeSolver(maze, visited, playerRow, playerCol, this, gc);
        new Thread(mazeSolver).start();
    }

    public void setSolving(boolean solving) {
        isSolving = solving;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
