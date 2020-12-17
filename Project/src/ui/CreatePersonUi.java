package ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


//extends Application
public class CreatePersonUi  {

    // @Override
    // public void start(Stage window) throws Exception {
        public void startCreatePerson() throws Exception{
        
        // TODO Auto-generated method stub
        BorderPane layout = new BorderPane();

        Label test = new Label("testtt");
        layout.getChildren().add(test);
        layout.getChildren().add(new TextArea());
        
        layout.getChildren().add(new Label("TESTETS"));
        layout.getChildren().add(new TextArea());

        layout.getChildren().add(new Label("TESTETS"));
        layout.getChildren().add(new TextArea());

        Scene createPersonScene = new Scene(layout, 350,250);

        
        Stage createPersonStage = new Stage();
        createPersonStage.setScene(createPersonScene);    
        createPersonStage.show();
      //  window.setScene(new Scene(layout, 350, 250));
       // window.show();

    }

    // public static void main(String[] args) throws Exception {
    //     launch(CreatePersonUi.class);
    //     // hey ik ben luuk :) <3😎
    // }
}
