module com.example.mazegame {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jgrapht.core;
//    requires javafx.web;

//    requires org.controlsfx.controls;
//    requires com.dlsc.formsfx;
//    requires net.synedra.validatorfx;
//    requires org.kordamp.ikonli.javafx;
//    requires org.kordamp.bootstrapfx.core;
//    requires eu.hansolo.tilesfx;
//    requires com.almasb.fxgl.all;

    opens com.example.mazegame to javafx.fxml;
    exports com.example.mazegame;
    exports com.example.mazegame.Graph;
    opens com.example.mazegame.Graph to javafx.fxml;
    exports com.example.mazegame.Maze;
    opens com.example.mazegame.Maze to javafx.fxml;
    exports com.example.mazegame.ds;
    opens com.example.mazegame.ds to javafx.fxml;
}