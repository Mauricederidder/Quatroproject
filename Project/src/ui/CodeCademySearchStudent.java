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
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class CodeCademySearchStudent {

    protected static Scene codeCademySearchStudentSceneBuilder(){
        Scene codeCademySearchStudentScene = new Scene(codeCademyScrollPane());
        return codeCademySearchStudentScene;
    }

    protected static ScrollPane codeCademyScrollPane(){
        ScrollPane s = new ScrollPane(); 
        s.setContent(codeCademySearchStudentLayout());
        s.pannableProperty().set(true);
        s.fitToWidthProperty().set(true);
        s.fitToHeightProperty().set(true);
        return s;
    }


    protected static BorderPane codeCademySearchStudentLayout() {
        BorderPane root = new BorderPane();
        root.setMinSize(800, 900);
        root.setTop(codeCademySearchStudentHeader());
        root.setCenter(codeCademySearchStudentCenterLayout());
        return root;
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
        GridPane headerGrid = new GridPane();
        Label emptyLabel = new Label();
        headerGrid.setPadding(new Insets(30,10,50,10));
        headerGrid.setHgap(30);
        headerGrid.add(emptyLabel,0,1);
        headerGrid.add(codeCademySearchStudentSceneHeader(),0,2);
        headerGrid.setAlignment(Pos.TOP_CENTER);
        return headerGrid;
    }
    
    protected static VBox codeCademySearchStudentSceneHeader(){
        VBox headerVbox = new VBox();
        headerVbox.getChildren().add(codeCademySearchStudentsSceneHeaderLabel());
        return headerVbox;
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


