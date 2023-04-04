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
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        // Initializing items
        Label label1 = new Label("Κελσίου   ");
        Label label2 = new Label("Φαρενάιτ");
        Label message = new Label();
        message.setStyle("-fx-text-fill: red;");

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

        //Button Actions and Events
        celToFahr.setEffect(null);  //The buttons did a weird
        fahrToCel.setEffect(null);  //animation on hover so we disabled it
        
        celToFahr.setOnAction((e) ->{
            if(tfCelsius.getText().isEmpty()){
                message.setText("Please enter a value in Celsius");
            }
            else{
                try{
                    int value = Integer.parseInt(tfCelsius.getText());
                    tfFahrenheit.setText(Cel_Fahr(value));
                    message.setText("");
                }
                catch(Exception exception){
                    message.setText("The value entered has to be an integer");
                }
               
            }
        });

        fahrToCel.setOnAction((e) ->{
            if(tfFahrenheit.getText().isEmpty()){
                message.setText("Please enter a value in Fahrenheit");
                
            }
            else{
                try{
                    int value = Integer.parseInt(tfFahrenheit.getText());
                    tfCelsius.setText(Fahr_Cel(value));
                    message.setText("");
                }
                catch(Exception exception){
                    message.setText("The value entered has to be an integer");
                }
                
            }
        });

        clear.setOnAction((e) ->{
            message.setText("");
            tfCelsius.setText("");
            tfFahrenheit.setText("");
        });

        //text fields on enter
        tfCelsius.setOnAction((e)->{
            if(tfCelsius.getText().isEmpty()){
                message.setText("Please enter a value in Celsius");
            }
            else{
                tfFahrenheit.setText(Cel_Fahr(Integer.parseInt(tfCelsius.getText())));
            }
        });

        tfFahrenheit.setOnAction((e) ->{
            if(tfFahrenheit.getText().isEmpty()){
                message.setText("Please enter a value in Fahrenheit");
            }
            else{
                tfCelsius.setText(Fahr_Cel(Integer.parseInt(tfFahrenheit.getText())));
            }
        });

        //hBox settings
        hBox.setPadding(new Insets(10));
        hBox.getChildren().addAll(label1, tfCelsius,buttonBox, tfFahrenheit, label2);
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);

        //a vbox that acts as a container for each element
        VBox container = new VBox(hBox,message, clear);
        container.setSpacing(10);
        container.setAlignment(Pos.CENTER);

        //buttonBox settings
        buttonBox.setPadding(new Insets(10));
        buttonBox.getChildren().addAll(celToFahr,fahrToCel);
        buttonBox.setAlignment(Pos.CENTER);

        //clear button settings
        clear.setPadding(new Insets(10,10,10,10));
        
        //Item placement on BorderPane
        BorderPane pane = new BorderPane();
        pane.setCenter(container);
        
        //BorderPane settings
        BorderPane.setAlignment(container, Pos.CENTER);
        BorderPane.setAlignment(clear, Pos.TOP_CENTER);
        
        // showing the BorderPane
        Scene scene = new Scene(pane, 420, 200);
        stage.setMinWidth(500);
        stage.setMinHeight(220); 
        stage.setTitle("Μετατροπές θερμοκρασίας");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }



//The two methods used to make the cast

    String Cel_Fahr(int value){
        double result;
        result = ((value*9)/5) + 32;
        return Integer.toString((int)Math.round(result));
    }


    String Fahr_Cel(int value){
        double result;
        result = (5* (value-32))/9;
        return Integer.toString((int)Math.round(result));
    }
}