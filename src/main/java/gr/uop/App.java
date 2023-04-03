package gr.uop;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {




        // Initializing items
        Label label1 = new Label("Κελσίου");
        Label label2 = new Label("Φαρενάιτ");

        label1.setPadding(new Insets(10));
        label2.setPadding(new Insets(10));

        HBox hBox = new HBox();
        VBox buttonBox = new VBox();

        TextField tfCelsius = new TextField();
        TextField tfFahrenheit = new TextField();

        tfCelsius.setMaxWidth(70);
        tfFahrenheit.setMaxWidth(70);

        Button celToFahr = new Button("->");
        Button fahrToCel = new Button("<-");
        Button clear = new Button("Καθαρισμός");
        
        //hBox settings
        hBox.setPadding(new Insets(10));
        hBox.getChildren().addAll(label1, tfCelsius,buttonBox, tfFahrenheit, label2);
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);

        //buttonBox settings
        buttonBox.setPadding(new Insets(10));
        buttonBox.getChildren().addAll(celToFahr,fahrToCel);
        buttonBox.setAlignment(Pos.CENTER);

        //clear button settings
        clear.setPadding(new Insets(10,10,10,10));
        
        BorderPane pane = new BorderPane();
        
        

        //Item placement on BorderPane
        
        pane.setCenter(hBox);
        pane.setBottom(clear);
        



        //BorderPane settings
       
        BorderPane.setAlignment(hBox, Pos.CENTER);
        BorderPane.setAlignment(clear, Pos.TOP_CENTER);
        
        







        // showing the BorderPane
        Scene scene = new Scene(pane, 400, 180);
        stage.setMinWidth(400);
        stage.setMinHeight(180); 
        stage.setTitle("Μετατροπές θερμοκρασίας");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}