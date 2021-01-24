package ui;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.effect.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class CodeCademySearchStudent {

    protected static Scene CodeCademySearchStudentSceneBuilder(){
        Scene codeCademySearchStudentScene = new Scene(codeCademySearchStudentLayout());
        return codeCademySearchStudentScene;
    }

    protected static BorderPane codeCademySearchStudentLayout() {
        BorderPane root = new BorderPane();
        root.setMinSize(400, 400);
        root.setTop(codeCademySearchStudentHeader());
        root.setCenter(codeCademySearchStudentsSceneGridPane());
        return root;
    }

    protected static FlowPane codeCademyPreviousButtonLayout(){
        FlowPane button = new FlowPane();
        Button backButton = codeCademyPreviousButton();
        backButton.addEventHandler(MouseEvent.MOUSE_CLICKED, CodeCademySearchStudentLogic.eventHandlerBack());
        button.getChildren().add(backButton);
        button.setAlignment(Pos.TOP_LEFT);
        return button;
    }

    protected static Button codeCademyPreviousButton(){
        Button button = new Button("Back");
        return button;
    }

    protected static FlowPane codeCademySearchStudentCenterLayout(){
        FlowPane rootToo = new FlowPane();
        rootToo.setVgap(10);
        rootToo.setHgap(10);
        rootToo.getChildren().add(codeCademySearchStudentsSceneGridPane());
        rootToo.setAlignment(Pos.TOP_CENTER);
        return rootToo;
    }

    protected static GridPane codeCademySearchStudentHeader(){
        Button button = new Button();
        GridPane headerGrid = new GridPane();
        Label emptyLabel = new Label();
        headerGrid.setPadding(new Insets(30,10,50,10));
        headerGrid.setHgap(30);
        headerGrid.add(emptyLabel,0,1);
        headerGrid.add(codeCademySearchStudentsBackButton(), 0, 0);
        headerGrid.add(codeCademySearchStudentSceneHeader(),0,2);
        headerGrid.setAlignment(Pos.TOP_CENTER);
        return headerGrid;
    }
    
    protected static VBox codeCademySearchStudentSceneHeader(){
        VBox headerVbox = new VBox();
        headerVbox.getChildren().add(codeCademySearchStudentsSceneHeaderLabel());
        return headerVbox;
    }

    protected static Button codeCademySearchStudentsBackButton(){
        Button button = new Button("Back");
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, CodeCademySearchStudentLogic.eventHandlerBack());
        button.setAlignment(Pos.TOP_LEFT);
        return button;
    }

    protected static Label codeCademySearchStudentsSceneHeaderLabel(){
        Label label = new Label("Account information");
        label.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(),34));
        label.setTextFill(Color.web("#000000", 1.0));
        return label;
    }

    protected static GridPane codeCademySearchStudentsSceneGridPane(){
        GridPane grid = new GridPane();

        TextField text = new TextField("Enter name");
        text.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(),14));
        
        grid.add(text,0,0);

        grid.add(new Label("     "),1,0);

        Button button = new Button("Find account");
        button.setStyle("-fx-background-color:#000000");
        button.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(),16));
        button.setTextFill(Color.web("#FFFFFF"));;
        button.setMaxHeight(50);
        button.setMaxWidth(450);
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, CodeCademySearchStudentLogic.searchStudentEventHandler(text));

        grid.add(button,2,0);

        return grid;
    }

}


