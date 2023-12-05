package com.example.mazegame;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
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

        Image image = new Image("file:src/assets/opening.jpg");
        Image image1 = new Image("file:src/assets/menu.jpg");

        ImageView imageView = new ImageView(image);
        ImageView imageView1 = new ImageView(image1);

        Font font = Font.loadFont("file:src/fonts/PantonNarrow-Trial-Regular.ttf",0);

        transition = createAndSetupTransition();

        //Scene 1
        Label label = createDynamicLabel("Welcome to Maze", font, 5, -100);
        label.getStyleClass().add("welcome");

        Label label2 = createDynamicLabel("Temukan  Jalan  Pulang  dan  Menangkan  Permainan", font, 0, 10);
        label2.getStyleClass().add("kata");

        Button startButton = new Button("START");
        startButton.getStyleClass().add("tombol-start");
        startButton.setFont(font);
        startButton.setMaxWidth(150);
        startButton.setTranslateX(0);
        startButton.setTranslateY(100);
        setupHoverEffect(startButton,null,20, 0);

        startButton.setOnAction(e -> switchToScene2());

        imageView.setFitWidth(bounds.getWidth());
        imageView.setFitHeight(bounds.getHeight());

        StackPane root = new StackPane();
        root.getChildren().add(imageView);
        root.getChildren().add(startButton);
        root.getChildren().add(label);
        root.getChildren().add(label2);

        //Scene 2
        Label label3 = createDynamicLabel("C H O O S E   Y O U R   D I F F I C U L T Y", font, 0, -200);
        label3.getStyleClass().add("kata-menu");

        //easy
        Circle circle = createCircle(10,-140,-50);
        Label menuEasy = createDynamicLabel("E A S Y", font, -60, -50);
        setupHoverEffect(menuEasy, circle,10, -60);
        menuEasy.getStyleClass().add("easy-menu");

        menuEasy.setOnMouseClicked(e -> {
            switchToMazeSolverApp();
        });

        //medium
        Circle circle1 = createCircle(10,-140,20);
        Label menuMedium = createDynamicLabel("M E D I U M", font, -30, 20);
        setupHoverEffect(menuMedium, circle1, 10, -30);
        menuMedium.getStyleClass().add("easy-menu");

        //hard
        Circle circle2 = createCircle(10, -140, 90);
        Label menuHard = createDynamicLabel("H A R D", font, -60, 90);
        setupHoverEffect(menuHard, circle2, 10, -60);
        menuHard.getStyleClass().add("easy-menu");

        imageView1.setFitWidth(bounds.getWidth());
        imageView1.setFitHeight(bounds.getHeight());

        StackPane layout2 = new StackPane();
        layout2.getChildren().add(imageView1);
        layout2.getChildren().add(label3);
        layout2.getChildren().add(circle);
        layout2.getChildren().add(circle1);
        layout2.getChildren().add(circle2);
        layout2.getChildren().add(menuEasy);
        layout2.getChildren().add(menuMedium);
        layout2.getChildren().add(menuHard);

        scene2 = new Scene(layout2, bounds.getWidth(), bounds.getHeight());
        scene2.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

        scene = new Scene(root, bounds.getWidth(), bounds.getHeight());
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

        stage.setScene(scene);
        stage.setTitle("Maze Games");
        stage.show();
    }

    private Circle createCircle(int radius, int x, int y){
        Circle circle = new Circle();
        circle.setRadius(radius);
        circle.setTranslateX(x);
        circle.setTranslateY(y);
        circle.setFill(Color.RED);

        return circle;
    }

    private Label createDynamicLabel(String text, Font font, int x, int y) {
        Label label = new Label(text);
        label.setFont(font);
        label.setTranslateX(x);
        label.setTranslateY(y);

        return label;
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

    private void setupHoverEffect(Node node, Circle circle, double setByX, int setTranslateX) {

        if (circle != null){
            node.setOnMouseEntered(e -> {
                configureAndPlayTransition(node, setByX);
                circle.setFill(Color.GREEN);
                stage.getScene().setCursor(Cursor.HAND);
            });

            node.setOnMouseExited(e -> {
                stage.getScene().setCursor(Cursor.DEFAULT);
                circle.setFill(Color.RED);
                transition.stop();
                node.setTranslateX(setTranslateX);
            });
        } else {
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
    }

    private void switchToMazeSolverApp() {
        MazeSolverApp mazeSolverApp = new MazeSolverApp();
        mazeSolverApp.start(new Stage());
        stage.close();  // Tutup stage saat ini (HelloApplication)
    }

    public void switchToScene2(){
        stage.setScene(scene2);
    }

    public static void main(String[] args) {
        launch();
    }
}