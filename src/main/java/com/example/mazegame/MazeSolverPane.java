//package com.example.mazegame;
//
//import javafx.application.Platform;
//import javafx.scene.canvas.Canvas;
//import javafx.scene.canvas.GraphicsContext;
//import javafx.scene.layout.Pane;
//import javafx.scene.paint.Color;
//
//public class MazeSolverPanel extends Pane implements Runnable {
//    private char[][] maze = {
//            {'.', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'},
//            {'.', '.', '0', '.', '0', '.', '0', '.', '.', '.', '.', '.', '0'},
//            {'0', '.', '0', '.', '.', '.', '0', '.', '0', '0', '0', '.', '0'},
//            {'0', '.', '.', '.', '0', '0', '0', '.', '.', '.', '.', '.', '0'},
//            {'0', '.', '0', '.', '.', '.', '.', '.', '0', '0', '0', '.', '0'},
//            {'0', '.', '0', '.', '0', '0', '0', '.', '0', '.', '.', '.', '0'},
//            {'0', '.', '0', '.', '0', '.', '.', '.', '0', '0', '0', '.', '0'},
//            {'0', '.', '0', '.', '0', '0', '0', '.', '0', '.', '0', '.', '0'},
//            {'0', '.', '.', '.', '.', '.', '.', '.', '.', '.', '0', '.', '0'},
//            {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '.', '.'}
//    };
//
//    private MazeSolver mazeSolver;
//
//    public MazeSolverPanel() {
//        Canvas canvas = new Canvas(30 * maze[0].length, 30 * maze.length);
//        getChildren().add(canvas);
//        setPrefSize(30 * maze[0].length, 30 * maze.length);
//
//        mazeSolver = new MazeSolver(maze,this);
//    }
//
//    public char[][] getMaze() {
//        return maze;
//    }
//
//    public void setMazeSolver(MazeSolver mazeSolver) {
//        this.mazeSolver = mazeSolver;
//    }
//
//    @Override
//    public void run() {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        Platform.runLater(() -> {
//            if (mazeSolver.solveMaze()) {
//                System.out.println("SOLVED maze");
//            } else {
//                System.out.println("Could NOT SOLVE maze");
//            }
//
//            redrawMaze();
//        });
//    }
//
//    private void redrawMaze() {
//        Canvas canvas = (Canvas) getChildren().get(0);
//        GraphicsContext gc = canvas.getGraphicsContext2D();
//        int w = (int) canvas.getWidth() / maze[0].length;
//        int h = (int) canvas.getHeight() / maze.length;
//
//        for (int j = 0; j < maze[0].length; j++) {
//            for (int i = 0; i < maze.length; i++) {
//                Color color;
//                switch (maze[i][j]) {
//                    case '.':
//                        color = Color.WHITE;
//                        break;
//                    case '0':
//                        color = Color.BLACK;
//                        break;
//                    case '*':
//                        color = Color.BLUE;
//                        break;
//                    default:
//                        color = Color.WHITE;
//                        break;
//                }
//                gc.setFill(color);
//                gc.fillRect(j * w, i * h, w, h);
//                gc.setStroke(Color.BLACK);
//                gc.strokeRect(j * w, i * h, w, h);
//            }
//        }
//    }
//}
