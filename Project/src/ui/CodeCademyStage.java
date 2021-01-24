package ui;

import database.CourseRepo;
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
        guiStage.setTitle("Maurice de Ridder 2168234, Luuk Bartels 2169707, Noah Christiaan de Keijzer 2167874, Dani Heyl 2169961");
        guiStage.setMaximized(true);

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
