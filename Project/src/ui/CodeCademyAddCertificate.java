package ui;

import domain.Course;
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
import javafx.scene.control.ComboBox;
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

public class CodeCademyAddCertificate {
    private static Course linkedCourse;

    protected static Scene CodeCademyAddCertificateSceneBuilder(Course course) {
        linkedCourse = course;
        Scene codeCademyAddCertificateScene = new Scene(codeCademyScrollPane());
        return codeCademyAddCertificateScene;
    }

    protected static ScrollPane codeCademyScrollPane(){
        ScrollPane s = new ScrollPane(); 
        s.setContent(codeCademyAddCertificateLayout());
        s.pannableProperty().set(true);
        s.fitToWidthProperty().set(true);
        s.fitToHeightProperty().set(true);
        return s;
    }

    protected static BorderPane codeCademyAddCertificateLayout() {
        BorderPane root = new BorderPane();
        root.setMinSize(800, 900);
        root.setTop(codeCademYAddCertificateGridHeader());
        root.setCenter(codeCademyAddCertificateCenterLayout());
        return root;
    }

    protected static FlowPane codeCademyAddCertificateCenterLayout(){
        FlowPane rootToo = new FlowPane();
        rootToo.setVgap(10);
        rootToo.setHgap(10);
        rootToo.getChildren().add(codeCademyAddCertificateTextfieldVbox());
        rootToo.setAlignment(Pos.TOP_CENTER);
        return rootToo;
    }

    protected static GridPane codeCademYAddCertificateGridHeader(){
        GridPane headerGrid = new GridPane();
        Label emptyLabel = new Label();
        headerGrid.setPadding(new Insets(30,10,50,10));
        headerGrid.setHgap(30);
        headerGrid.add(codeCademyAddcertificateBackButton(), 0, 0);
        headerGrid.add(emptyLabel,0,1);
        headerGrid.add(codeCademyAddCertificateSceneHeader(),0,2);
        headerGrid.setAlignment(Pos.TOP_CENTER);
        return headerGrid;
    }

    protected static Button codeCademyAddcertificateBackButton(){
        Button button = new Button("Back");
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, CodeCademyAddCertificateLogic.eventHandlerBack(linkedCourse));
        button.setAlignment(Pos.TOP_LEFT);
        return button;
    }
    
    protected static VBox codeCademyAddCertificateSceneHeader(){
        VBox headerVbox = new VBox();
        headerVbox.getChildren().add(codeCademyAddCertificateHeaderTitle());
        return headerVbox;
    }

    protected static Label codeCademyAddCertificateHeaderTitle(){
        Label title = new Label("Add Certificate");
        title.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(),40));
        return title;
    }

    protected static VBox codeCademyAddCertificateTextfieldVbox(){
        VBox vbox = new VBox();
        Button addCertificateButton = codeCademyAddCertificateButton();
        TextField textfieldNaam = codeCademAddCertificateTextFieldCName();
        ComboBox comboboxGrade = codeCademyAddCertificateComboBoxCertificateTag();
        vbox.getChildren().add(codeCademyAddCertificateTextFieldLabelCertificateName());
        vbox.getChildren().add(textfieldNaam);
        vbox.getChildren().add(new Label(""));
        vbox.getChildren().add(codeCademyAddCertificateTextFieldLabelCertificateTag());
        vbox.getChildren().add(comboboxGrade);
        vbox.getChildren().add(new Label(""));
      //  vbox.getChildren().add(codeCademyAddCourseAddModulesOverview());
        vbox.getChildren().add(addCertificateButton);
        addCertificateButton.addEventHandler(MouseEvent.MOUSE_CLICKED, CodeCademyAddCertificateLogic.EventHandlerMouseClickAddCertificate(textfieldNaam,comboboxGrade,linkedCourse));
        return vbox;
    }
    protected static Label codeCademyAddCertificateTextFieldLabelCertificateName(){
        Label TextFieldLabelOne = new Label("Certificate name: ");
        TextFieldLabelOne.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(),16));
        TextFieldLabelOne.setTextFill(Color.web("#000000", 1.0));
        return TextFieldLabelOne;
    }

    protected static TextField codeCademAddCertificateTextFieldCName(){
        TextField TextFieldCertificatename = new TextField();
        TextFieldCertificatename.setText("Certificate name");
        return TextFieldCertificatename;
    }

    protected static Label codeCademyAddCertificateTextFieldLabelCertificateTag(){
        Label TextFieldLabelOne = new Label("Certificate Difficulty: ");
        TextFieldLabelOne.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(),16));
        TextFieldLabelOne.setTextFill(Color.web("#000000", 1.0));
        return TextFieldLabelOne;
    }

    protected static ComboBox codeCademyAddCertificateComboBoxCertificateTag(){
        ComboBox ComboBox = new ComboBox();
        ComboBox.getItems().addAll(
            "Beginner",
            "Advanced",      
            "Expert"
        );
        ComboBox.getSelectionModel().selectFirst();
        return ComboBox;
    }

    protected static Button codeCademyAddCertificateButton(){
        Button button = new Button("Add Certificate");
        button.setStyle("-fx-background-color:#000000");
        button.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(),16));
        button.setTextFill(Color.web("#FFFFFF"));;
        button.setMaxHeight(50);
        button.setMaxWidth(450);
        return button;
    }

}
