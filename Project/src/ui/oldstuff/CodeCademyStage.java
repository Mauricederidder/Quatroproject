package ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class CodeCademyStage extends Application {
    private static Stage guiStage;
    @Override
    public void start(Stage mainStage) throws Exception {
        guiStage = mainStage;
        // TODO Auto-generated method stub
        guiStage.setTitle("Codecademy");
        guiStage.setScene(CodeCademyLandingScene.codeCademyLandingScene());
        guiStage.show();
    }
    
    public static Stage getStage(){
        return guiStage;
    }
    public static void main(String[] args) throws Exception {
        launch(CodeCademyStage.class);
    }


}
