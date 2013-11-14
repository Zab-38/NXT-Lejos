package com.josh.javafx;
import java.util.Calendar;

import com.josh.math.PrimedeterminatorV1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
 
public class HelloWorld extends Application {
	PrimedeterminatorV1 primeDeterminator= new PrimedeterminatorV1();
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");
        
        VBox vBox = new VBox();
        final TextField textField = new TextField();
        final Label answerLabel = new Label();
        
        Button btn = new Button();
        btn.setText("Test Prime");
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                
            	String text = textField.getText();
            	
            	int testNumber = Integer.parseInt(text);
            	
            	
            	answerLabel.setText(new Boolean(  primeDeterminator.isPrimeNumber(testNumber)).toString());
            }
        });
        
        vBox.getChildren().add(btn);
        vBox.getChildren().add(textField);
        vBox.getChildren().add(answerLabel);
        
        StackPane root = new StackPane();
        root.getChildren().add(vBox);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}