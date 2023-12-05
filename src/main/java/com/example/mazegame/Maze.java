package com.example.mazegame;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Maze extends Application {
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

    private Circle player;
    private MazeSolver mazeSolver;

    @Override
    public void start(Stage stage) throws Exception {

        double screenWidth = Screen.getPrimary().getVisualBounds().getWidth();
        double screenHeight = Screen.getPrimary().getVisualBounds().getHeight();
        // Menghitung ukuran sel berdasarkan ukuran layar dan maze
        double cellSize = Math.min(screenWidth / maze[0].length, screenHeight / maze.length);

        mazeSolver = new MazeSolver(maze);

        player = new Circle(cellSize / 2, Color.RED);

        GridPane gridPane = new GridPane();

        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[0].length; col++) {
                Rectangle cell = new Rectangle(cellSize, cellSize);

                // Set warna berdasarkan karakter pada maze
                if (maze[row][col] == '0') {
                    cell.setFill(Color.BLACK);
                } else if (maze[row][col] == '.') {
                    cell.setFill(Color.WHITE);
                }

                gridPane.add(cell, col, row);
            }
        }

        Label dfsButton = new Label();
        dfsButton.setText("DFS");
        dfsButton.setTranslateX(950);
        dfsButton.setTranslateY(50);


        gridPane.add(player, 0, 1);
        gridPane.getChildren().add(dfsButton);

        StackPane root = new StackPane();
        root.getChildren().add(gridPane);

        Scene scene = new Scene(root, bounds.getWidth(), bounds.getHeight()-20);

        scene.setOnKeyPressed(event -> {
            KeyCode code = event.getCode();
            movePlayer(code);
        });

        dfsButton.setOnMouseEntered(e -> {
            stage.getScene().setCursor(Cursor.HAND);
        });

        dfsButton.setOnMouseExited(e -> {
            stage.getScene().setCursor(Cursor.DEFAULT);
        });

        dfsButton.setOnMouseClicked(e -> {
            mazeSolver.solveMaze();
        });

        stage.setScene(scene);
        stage.setTitle("MAZE");
        stage.show();
    }

    private void movePlayer(KeyCode code) {
        int currentRow = GridPane.getRowIndex(player);
        int currentCol = GridPane.getColumnIndex(player);

        switch (code) {
            case UP:
                if (currentRow > 0 && maze[currentRow - 1][currentCol] == '.') {
                    GridPane.setRowIndex(player, currentRow - 1);
                }
                break;
            case DOWN:
                if (currentRow < maze.length - 1 && maze[currentRow + 1][currentCol] == '.') {
                    GridPane.setRowIndex(player, currentRow + 1);
                }
                break;
            case LEFT:
                if (currentCol > 0 && maze[currentRow][currentCol - 1] == '.') {
                    GridPane.setColumnIndex(player, currentCol - 1);
                }
                break;
            case RIGHT:
                if (currentCol < maze[0].length - 1 && maze[currentRow][currentCol + 1] == '.') {
                    GridPane.setColumnIndex(player, currentCol + 1);
                }
                break;
        }
    }
}

