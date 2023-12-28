package com.example.mazegame.Maze;

import com.example.mazegame.Graph.Graph;
import com.example.mazegame.MainApp;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MazeApp extends Application {
    private Maze maze;
    private boolean[][] visited;
    private int playerRow;
    private int playerCol;
    private boolean isSolving;
    private Image youWinImage;
    private String level;
    private int CELL_SIZE;
    private int MAZE_WIDTH;
    private int MAZE_HEIGHT;

    public int getMAZE_WIDTH() {
        return MAZE_WIDTH;
    }

    public int getMAZE_HEIGHT() {
        return MAZE_HEIGHT;
    }

    public MazeApp(String level) {
        this.level = level;
    }



    @Override
    public void start(Stage primaryStage) {

        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        youWinImage = new Image("file:src/assets/you-win1.png");

        maze = new Maze();

        if (level.equals("easy")){
            maze.switchMaze(level);
            CELL_SIZE = 50;
        } else if (level.equals("medium")) {
            maze.switchMaze(level);
            CELL_SIZE = 18;
        } else if (level.equals("hard")) {
            maze.switchMaze(level);
            CELL_SIZE = 8;
        }

        MAZE_WIDTH = maze.getMaze()[0].length;
        MAZE_HEIGHT = maze.getMaze().length;

        StackPane root = new StackPane();
        root.setBackground(Background.fill(Color.BLACK));
        Canvas canvas = new Canvas(MAZE_WIDTH * CELL_SIZE, MAZE_HEIGHT * CELL_SIZE);
        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        Label dfsButton = new Label("DFS");
        dfsButton.setTextFill(Color.ORANGE);
        dfsButton.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/Bobby-Jones-Soft.otf"), 50));
        dfsButton.setTranslateX(640);
        dfsButton.setTranslateY(-300);

        dfsButton.setOnMouseEntered(e -> primaryStage.getScene().setCursor(Cursor.HAND));
        dfsButton.setOnMouseExited(e -> primaryStage.getScene().setCursor(Cursor.DEFAULT));

        dfsButton.setOnMouseClicked(event -> solveMaze(gc));
        root.getChildren().add(dfsButton);

        initializeMaze();
        drawMaze(gc);
        drawPlayer(gc);

        canvas.setOnKeyPressed(e -> movePlayer(e.getCode(), gc));

        Scene scene = new Scene(root, bounds.getWidth(), bounds.getHeight()-20);
        scene.setFill(Color.BLACK);
        scene.setOnKeyPressed(e -> movePlayer(e.getCode(), gc));

        primaryStage.setScene(scene);
        primaryStage.setTitle("Maze Solver");
        primaryStage.show();
    }

    public void initializeMaze() {
        visited = new boolean[MAZE_HEIGHT][MAZE_WIDTH];
        playerRow = 0;
        playerCol = 0;
        maze.getMaze();
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
                        color = Color.BLUE.darker();
                        break;
                    case '*':
                        color = Color.GREEN;
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

    public boolean isValidMovePlayer(int row, int col) {
        if (row >= 0 && row < MAZE_HEIGHT && col >= 0 && col < MAZE_WIDTH) {
            return maze.getMaze()[row][col] == '.' || maze.getMaze()[row][col] == '*' || maze.getMaze()[row][col] == ' ';
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

            if (isValidMovePlayer(newRow, newCol)) {
                playerRow = newRow;
                playerCol = newCol;

                drawMaze(gc);
                drawPlayer(gc);

                if (playerRow == getMAZE_HEIGHT()-1 && playerCol == getMAZE_WIDTH()-1) {
                    drawYouWin(gc);
                    setSolving(true);  // Set isSolving ke true agar tidak bisa bergerak lagi setelah menang
                }
            }
        }
    }

    public void drawYouWin(GraphicsContext gc) {
        // Menggambar gambar "You Win" di tengah kanvas
        double x = (MAZE_WIDTH * CELL_SIZE - youWinImage.getWidth()) / 2;
        double y = (MAZE_HEIGHT * CELL_SIZE - youWinImage.getHeight()) / 2;
        gc.drawImage(youWinImage, x, y);
    }

    public void solveMaze(GraphicsContext gc) {
        isSolving = true;
        Graph graph = new Graph(maze.getMaze() ,maze,this,gc);
        new Thread(graph).start();
    }

    public void setSolving(boolean solving) {
        isSolving = solving;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
