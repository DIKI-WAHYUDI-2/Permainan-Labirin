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
}