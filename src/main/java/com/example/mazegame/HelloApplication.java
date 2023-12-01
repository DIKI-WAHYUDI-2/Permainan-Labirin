package com.example.mazegame;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private Stage stage;
    private Scene scene,scene2;

    @Override
    public void start(Stage stage) throws IOException {

        this.stage = stage;

        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        Image image = new Image("file:src/icon/opening.jpg");
        Image image1 = new Image("file:src/icon/menu.jpg");

        ImageView imageView = new ImageView(image);
        ImageView imageView1 = new ImageView(image1);

        Font font = Font.loadFont("file:src/fonts/PantonNarrow-Trial-Regular.ttf",0);

        //Scene 1
        Label label = new Label();
        label.getStyleClass().add("welcome");
        label.setFont(font);
        label.setText("Welcome to Maze");
        label.setTranslateX(5);
        label.setTranslateY(-100);

        Label label2 = new Label();
        label2.getStyleClass().add("kata");
        label2.setFont(font);
        label2.setText("Temukan  Jalan  Pulang  dan  Menangkan  Permainan");
        label2.setTranslateX(0);
        label2.setTranslateY(10);

        Button startButton = new Button("START");
        startButton.getStyleClass().add("tombol-start");
        startButton.setFont(font);
        startButton.setMaxWidth(150);
        startButton.setTranslateX(0);
        startButton.setTranslateY(100);
        startButton.setOnAction(e -> switchToScene2());

        imageView.setFitWidth(bounds.getWidth());
        imageView.setFitHeight(bounds.getHeight());

        StackPane root = new StackPane();
        root.getChildren().add(imageView);
        root.getChildren().add(startButton);
        root.getChildren().add(label);
        root.getChildren().add(label2);

        //Scene 2
        Label label3 = new Label();
        label3.setFont(font);
        label3.setText("CHOOSE YOUR DIFFICULTY!");
        label3.setTranslateX(0);
        label3.setTranslateY(-150);
        label3.getStyleClass().add("kata-menu");

        imageView1.setFitWidth(bounds.getWidth());
        imageView1.setFitHeight(bounds.getHeight());

        StackPane layout2 = new StackPane();
        layout2.getChildren().add(imageView1);
        layout2.getChildren().add(label3);

        scene2 = new Scene(layout2, bounds.getWidth(), bounds.getHeight());
        scene2.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

        scene = new Scene(root, bounds.getWidth(), bounds.getHeight());
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

        stage.setScene(scene);
        stage.setTitle("Maze Games");
        stage.show();
    }

    public void switchToScene2(){
        stage.setScene(scene2);
    }

    public static void main(String[] args) {
        launch();
    }
}