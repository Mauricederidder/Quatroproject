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

public class codeCademyAddModule {

    protected static Scene CodeCademyAddModuleSceneBuilder(){
        Scene codeCademyAllCoursesScene = new Scene(codeCademyAddModuleLayout());
        return codeCademyAllCoursesScene;
    }

    protected static BorderPane codeCademyAddModuleLayout() {
        BorderPane root = new BorderPane();
        root.setMinSize(800, 900);
        root.setTop(codeCademyAddModuleGridHeader());
        root.setCenter(codeCademyAddModuleCenterLayout());
        return root;
    }

    protected static FlowPane codeCademyAddModuleCenterLayout(){
        FlowPane rootToo = new FlowPane();
        rootToo.setVgap(10);
        rootToo.setHgap(10);
        rootToo.getChildren().add(codeCademyAddModuleTextfieldVbox());
        rootToo.setAlignment(Pos.TOP_CENTER);
        return rootToo;
    }

    protected static GridPane codeCademyAddModuleGridHeader(){
        GridPane headerGrid = new GridPane();
        Label emptyLabel = new Label();
        headerGrid.setPadding(new Insets(30,10,50,10));
        headerGrid.setHgap(30);
        headerGrid.add(emptyLabel,0,1);
        headerGrid.add(codeCademyAddModuleSceneHeader(),0,2);
        headerGrid.setAlignment(Pos.TOP_CENTER);
        return headerGrid;
    }
    
    protected static VBox codeCademyAddModuleSceneHeader(){
        VBox headerVbox = new VBox();
        headerVbox.getChildren().add(codeCademyAddModuleHeaderTitle());
        return headerVbox;
    }

    protected static Label codeCademyAddModuleHeaderTitle(){
        Label title = new Label("Add Module");
        title.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(),40));
        return title;
    }

    protected static VBox codeCademyAddModuleTextfieldVbox(){
        VBox vbox = new VBox();
        vbox.getChildren().add(codeCademyAddModuleTextFieldLabelCourseName());
        vbox.getChildren().add(codeCademyAddModuleTextFieldCourseName());
        vbox.getChildren().add(new Label(""));
        vbox.getChildren().add(codeCademyAddModuleTextFieldLabelCourseTag());
        vbox.getChildren().add(codeCademyAddModuleTextFieldCourseTag());
        vbox.getChildren().add(new Label(""));
        vbox.getChildren().add(codeCademyAddModuleButton());
        return vbox;
    }
    protected static Label codeCademyAddModuleTextFieldLabelCourseName(){
        Label TextFieldLabelOne = new Label("Module name: ");
        TextFieldLabelOne.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(),16));
        TextFieldLabelOne.setTextFill(Color.web("#000000", 1.0));
        return TextFieldLabelOne;
    }

    protected static TextField codeCademyAddModuleTextFieldCourseName(){
        TextField TextFieldCoursename = new TextField();
        TextFieldCoursename.setText("Module name");
        return TextFieldCoursename;
    }

    protected static Label codeCademyAddModuleTextFieldLabelCourseTag(){
        Label TextFieldLabelOne = new Label("Module tags: ");
        TextFieldLabelOne.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(),16));
        TextFieldLabelOne.setTextFill(Color.web("#000000", 1.0));
        return TextFieldLabelOne;
    }

    protected static TextField codeCademyAddModuleTextFieldCourseTag(){
        TextField TextFieldCoursename = new TextField();
        TextFieldCoursename.setText("Module tags");
        return TextFieldCoursename;
    }

    protected static Button codeCademyAddModuleButton(){
        Button button = new Button("Add Module");
        button.setStyle("-fx-background-color:#000000");
        button.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(),16));
        button.setTextFill(Color.web("#FFFFFF"));;
        button.setMaxHeight(50);
        button.setMaxWidth(450);
        return button;
    }

}


