package ui;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.effect.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class CodeCademyLandingScene {    

    protected static Scene codeCademyLandingScene() {
        Scene codeCademyLandingScene = new Scene(codeCademyLandingSceneRootLayout());
        return codeCademyLandingScene;
    }

    protected static BorderPane codeCademyLandingSceneRootLayout() {
        BorderPane root = new BorderPane();
        root.setMinSize(800, 700);
        root.setTop(codeCademyLandingSceneGridHeader());
        root.setCenter(codeCademyLandingSceneGridCenter());
        return root;
    }

    protected static GridPane codeCademyLandingSceneGridHeader(){
        GridPane headerGrid = new GridPane();
        Label emptyLabel = new Label();
        headerGrid.setPadding(new Insets(30,10,50,10));
        headerGrid.setHgap(30);
        headerGrid.add(emptyLabel,0,1);
        headerGrid.add(codeCademyLandingSceneHeader(),0,2);
        headerGrid.setAlignment(Pos.TOP_CENTER);
        return headerGrid;
    }

    protected static VBox codeCademyLandingSceneHeader(){
        VBox headerVbox = new VBox();
        headerVbox.getChildren().add(codeCademyLandingSceneHeaderTitle());
        return headerVbox;
    }

    protected static Label codeCademyLandingSceneHeaderTitle(){
        Label title = new Label("Codecademy Statistics");
        title.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(),40));
        //title.setFont(font);
        return title;
    }
    
    protected static Label codeCademyLandingSceneEmptyLabel(){
        Label emptyLabel = new Label();
        return emptyLabel;
    }

    protected static Button codeCademyLandingSceneButton(){
        Button button = new Button();
        button.setMinSize(155,50);
        button.setStyle("-fx-background-color:#000000;");
        button.setEffect(codeCademyLandingSceneDropShadowButton());
        button.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(),14));
        button.setStyle("-fx-text-fill:white; -fx-background-color:black;");
        return button;
    }

    protected static DropShadow codeCademyLandingSceneDropShadowButton(){
        DropShadow shadow = new DropShadow();
        shadow.setOffsetY(3.0);
        return shadow;
    }

    protected static GridPane codeCademyLandingSceneGridCenter(){
        GridPane centerGrid = new GridPane();
        Button studentenButton = codeCademyLandingSceneButton();
        Button cursussenButton = codeCademyLandingSceneButton();
        Label text = codeCademyLandingSceneGridText();
        studentenButton.setText("Studenten");
        studentenButton.addEventHandler(MouseEvent.MOUSE_CLICKED, CodeCademyLandingSceneLogic.eventHandlerStudentSearch());
        cursussenButton.setText("Cursussen");
        cursussenButton.addEventHandler(MouseEvent.MOUSE_CLICKED, CodeCademyLandingSceneLogic.eventHandlerAllCourses());
        centerGrid.setPadding(new Insets(30,10,430,10));
        centerGrid.setHgap(10);
        centerGrid.setVgap(40);
        centerGrid.add(text,1,0);
        text.setPadding(new Insets(0,0,0,36));
        centerGrid.setColumnSpan(centerGrid.getChildren().get(0),2 );
        centerGrid.add(studentenButton,1,1);
        centerGrid.add(cursussenButton,2,1);
        centerGrid.setAlignment(Pos.CENTER);
        //centerGrid.setGridLinesVisible(true);
        return centerGrid;
    }

    protected static Label codeCademyLandingSceneGridText(){
        Label text = new Label();
        text.setText("Welk overzicht wil je zien?");
        text.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Regular.ttf").toExternalForm(),18));
        return text;
    }

}
