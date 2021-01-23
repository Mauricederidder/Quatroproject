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

    protected static Scene CodeCademyAddModuleSceneBuilder() {
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

    protected static FlowPane codeCademyAddModuleCenterLayout() {
        FlowPane rootToo = new FlowPane();
        rootToo.setVgap(10);
        rootToo.setHgap(10);
        rootToo.getChildren().add(codeCademyAddModuleTextfieldVbox());
        rootToo.setAlignment(Pos.TOP_CENTER);
        return rootToo;
    }

    protected static GridPane codeCademyAddModuleGridHeader() {
        GridPane headerGrid = new GridPane();
        Label emptyLabel = new Label();
        headerGrid.setPadding(new Insets(30, 10, 50, 10));
        headerGrid.setHgap(30);
        headerGrid.add(emptyLabel, 0, 1);
        headerGrid.add(codeCademyAddModuleSceneHeader(), 0, 2);
        headerGrid.setAlignment(Pos.TOP_CENTER);
        return headerGrid;
    }

    protected static VBox codeCademyAddModuleSceneHeader() {
        VBox headerVbox = new VBox();
        headerVbox.getChildren().add(codeCademyAddModuleHeaderTitle());
        return headerVbox;
    }

    protected static Label codeCademyAddModuleHeaderTitle() {
        Label title = new Label("Add Module");
        title.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(), 40));
        return title;
    }

    protected static VBox codeCademyAddModuleTextfieldVbox(){
        VBox vbox = new VBox();
        TextField textFieldModuleName = codeCademyAddModuleTextFieldModuleName(); 
        TextField TextFieldModuletag = codeCademyAddModuleTextFieldModuleTag() ;
        Button addModuleButton = codeCademyAddModuleButton();

        vbox.getChildren().add(codeCademyAddModuleTextFieldLabelModuleName());
        vbox.getChildren().add(textFieldModuleName);
        vbox.getChildren().add(new Label(""));
        vbox.getChildren().add(codeCademyAddModuleTextFieldLabelModuleTag());
        vbox.getChildren().add(TextFieldModuletag);
        vbox.getChildren().add(new Label(""));
        vbox.getChildren().add(codeCademyAddModuleButton());
        vbox.getChildren().add(addModuleButton);
        String name = textFieldModuleName.getText();
        String tag = TextFieldModuletag.getText();
        addModuleButton.addEventHandler(MouseEvent.MOUSE_CLICKED, codeCademyAddModuleLogic.eventHandlerMouseClickedAddModule(name,tag));
        return vbox;
    }

    protected static Label codeCademyAddModuleTextFieldLabelModuleName() {
        Label TextFieldLabelOne = new Label("Module name: ");
        TextFieldLabelOne
                .setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(), 16));
        TextFieldLabelOne.setTextFill(Color.web("#000000", 1.0));
        return TextFieldLabelOne;
    }

    protected static TextField codeCademyAddModuleTextFieldModuleName() {
        TextField TextFieldModulename = new TextField();
        TextFieldModulename.setText("Module name");
        return TextFieldModulename;
    }

    protected static Label codeCademyAddModuleTextFieldLabelModuleTag() {
        Label TextFieldLabelOne = new Label("Module tags: ");
        TextFieldLabelOne
                .setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(), 16));
        TextFieldLabelOne.setTextFill(Color.web("#000000", 1.0));
        return TextFieldLabelOne;
    }

    protected static TextField codeCademyAddModuleTextFieldModuleTag() {
        TextField TextFieldModuleTag = new TextField();
        TextFieldModuleTag.setText("Module tags");
        return TextFieldModuleTag;
    }

    protected static Button codeCademyAddModuleButton() {
        Button button = new Button("Add Module");
        button.setStyle("-fx-background-color:#000000");
        button.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(), 16));
        button.setTextFill(Color.web("#FFFFFF"));
        ;
        button.setMaxHeight(50);
        button.setMaxWidth(450);
        return button;
    }

}
