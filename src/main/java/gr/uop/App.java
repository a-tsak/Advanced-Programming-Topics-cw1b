package gr.uop;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        // making the BorderPane with HBox
        Label label1 = new Label("Κελσίου");
        Label label2 = new Label("Φαρενάιτ");
        HBox hbox = new HBox();
        VBox vbox = new VBox();
        TextField tf1 = new TextField();
        TextField tf2 = new TextField();
        tf1.setMaxWidth(70);
        tf2.setMaxWidth(70);
        hbox.setPadding(new Insets(20));
        hbox.getChildren().addAll(label1, label2, tf1, tf2, vbox);
        hbox.setSpacing(10);
        BorderPane p = new BorderPane();
        p.setLeft(label1);
        p.setRight(label2);

        p.setCenter(hbox);
        // p.setBottom(vb);
        // vb.setCenter(vb);
        p.setAlignment(hbox, Pos.BOTTOM_CENTER);

        p.setAlignment(tf1, Pos.CENTER);
        p.setAlignment(tf2, Pos.CENTER);

        Scene scene = new Scene(p, 400, 180);
        p.setAlignment(label1, Pos.CENTER_LEFT);
        p.setAlignment(label2, Pos.CENTER_RIGHT);
        p.setPadding(new Insets(20));

        // showing the BorderPane
        stage.setTitle("BorderPane");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}