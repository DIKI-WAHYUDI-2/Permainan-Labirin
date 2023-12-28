package com.example.mazegame;

import com.example.mazegame.Maze.MazeApp;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class MainApp extends Application {

    private Stage stage;
    private Scene scene,scene2;
    private TranslateTransition transition;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;

        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();


        Image image = new Image("file:src/assets/layout-1.jpg");
        Image image2 = new Image("file:src/assets/layout-2.jpg");

        ImageView imageView = new ImageView(image);
        ImageView imageView2 = new ImageView(image2);

        transition = createAndSetupTransition();

        //Scene 1
        Label label = new Label();
        label.setText("MAZZ");
        label.setTranslateX(-50);
        label.setTranslateY(-100);
        label.setTextFill(Color.WHITE);
        label.setRotate(-8);
        label.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/Bobby-Jones-Soft.otf"), 110));


        Label label2 = new Label();
        label2.setText("Y");
        label2.setTranslateX(90);
        label2.setTranslateY(-129);
        label2.setTextFill(Color.WHITE);
        label2.setRotate(10);
        label2.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/Bobby-Jones-Soft.otf"), 150));

        Label startButton = new Label();
        startButton.setText("START");
        startButton.setTranslateX(0);
        startButton.setTranslateY(140);
        startButton.setTextFill(Color.ORANGE);
        startButton.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/Mokoto-Demo.ttf"), 50));

        setupHoverEffect(startButton,5, 0);

        startButton.setOnMouseClicked(e -> switchToScene2());

        imageView.setFitWidth(bounds.getWidth());
        imageView.setFitHeight(bounds.getHeight());

        StackPane root = new StackPane();
        root.getChildren().add(imageView);
        root.getChildren().add(startButton);
        root.getChildren().add(label);
        root.getChildren().add(label2);

        //Scene 2
        Label difficultWord = new Label();
        difficultWord.setText("CHOOSE YOUR DIFFICULTY");
        difficultWord.setTextFill(Color.WHITE);
        difficultWord.setTranslateX(80);
        difficultWord.setTranslateY(-165);
        difficultWord.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/Mokoto-Demo.ttf"), 50));

        //easy
        Label easyMenu = new Label();
        easyMenu.setText("EASY");
        easyMenu.setTranslateX(100);
        easyMenu.setTranslateY(-23);
        easyMenu.setTextFill(Color.ORANGE);
        easyMenu.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/Bobby-Jones-Soft.otf"), 60));
        setupHoverEffect(easyMenu, 5, 100);

        easyMenu.setOnMouseClicked(e -> {
            MazeApp level = new MazeApp("easy");
            level.start(new Stage());
            stage.close();
        });

        //medium
        Label mediumMenu = new Label();
        mediumMenu.setText("MEDIUM");
        mediumMenu.setTranslateX(100);
        mediumMenu.setTranslateY(73);
        mediumMenu.setTextFill(Color.ORANGE);
        mediumMenu.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/Bobby-Jones-Soft.otf"), 60));
        setupHoverEffect(mediumMenu, 5, 100);

        mediumMenu.setOnMouseClicked(e -> {
            MazeApp level = new MazeApp("medium");
            level.start(new Stage());
            stage.close();
        });

        //hard
        Label hardMenu = new Label();
        hardMenu.setText("HARD");
        hardMenu.setTranslateX(100);
        hardMenu.setTranslateY(165);
        hardMenu.setTextFill(Color.ORANGE);
        hardMenu.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/Bobby-Jones-Soft.otf"), 60));
        setupHoverEffect(hardMenu, 5, 100);

        hardMenu.setOnMouseClicked(e -> {
            MazeApp level = new MazeApp("hard");
            level.start(new Stage());
            stage.close();
        });

        Label title = new Label();
        title.setText("MAZZ");
        title.setTextFill(Color.WHITE);
        title.setTranslateX(-480);
        title.setTranslateY(-230);
        title.setRotate(-8);
        title.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/Bobby-Jones-Soft.otf"), 110));

        Label title2 = new Label();
        title2.setText("Y");
        title2.setTextFill(Color.WHITE);
        title2.setTranslateX(-338);
        title2.setTranslateY(-260);
        title2.setRotate(10);
        title2.setFont(Font.loadFont(getClass().getResourceAsStream("/fonts/Bobby-Jones-Soft.otf"), 150));

        imageView2.setFitWidth(bounds.getWidth());
        imageView2.setFitHeight(bounds.getHeight());

        StackPane layout2 = new StackPane();
        layout2.getChildren().add(imageView2);
        layout2.getChildren().add(difficultWord);
        layout2.getChildren().add(easyMenu);
        layout2.getChildren().add(mediumMenu);
        layout2.getChildren().add(hardMenu);
        layout2.getChildren().add(title);
        layout2.getChildren().add(title2);

        scene2 = new Scene(layout2, bounds.getWidth(), bounds.getHeight()-20);

        scene = new Scene(root, bounds.getWidth(), bounds.getHeight()-20);

        stage.setScene(scene);
        stage.setTitle("Maze Games");
        stage.show();
    }
    private TranslateTransition createAndSetupTransition() {
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.millis(200));

        return transition;
    }
    private void configureAndPlayTransition(Node node, double customSetByX) {
        transition.setNode(node);
        transition.setByX(customSetByX);
        transition.play();
    }
    private void setupHoverEffect(Node node, double setByX, int setTranslateX) {

            node.setOnMouseEntered(e -> {
                configureAndPlayTransition(node, setByX);
                stage.getScene().setCursor(Cursor.HAND);
            });

            node.setOnMouseExited(e -> {
                stage.getScene().setCursor(Cursor.DEFAULT);
                transition.stop();
                node.setTranslateX(setTranslateX);
            });
    }

    public void switchToScene2(){
        stage.setScene(scene2);
    }
    public static void main(String[] args) {
        launch();
    }
}