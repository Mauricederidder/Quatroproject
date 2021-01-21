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

public class CodeCademyAddCertificate {

    protected static Scene CodeCademyAddCertificateSceneBuilder(){
        Scene codeCademyAddCertificateScene = new Scene(codeCademyAddCertificateLayout());
        return codeCademyAddCertificateScene;
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
        headerGrid.add(emptyLabel,0,1);
        headerGrid.add(codeCademyAddCertificateSceneHeader(),0,2);
        headerGrid.setAlignment(Pos.TOP_CENTER);
        return headerGrid;
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
        vbox.getChildren().add(codeCademyAddCertificateTextFieldLabelCertificateName());
        vbox.getChildren().add(codeCademAddCertificateTextFieldCName());
        vbox.getChildren().add(new Label(""));
        vbox.getChildren().add(codeCademyAddCertificateTextFieldLabelCertificateTag());
        vbox.getChildren().add(codeCademyAddCertificateTextFieldCertificateTag());
        vbox.getChildren().add(new Label(""));
      //  vbox.getChildren().add(codeCademyAddCourseAddModulesOverview());
        vbox.getChildren().add(codeCademyAddCertificateButton());
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
        Label TextFieldLabelOne = new Label("Certificate tag: ");
        TextFieldLabelOne.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(),16));
        TextFieldLabelOne.setTextFill(Color.web("#000000", 1.0));
        return TextFieldLabelOne;
    }

    protected static TextField codeCademyAddCertificateTextFieldCertificateTag(){
        TextField TextFieldCertificatename = new TextField();
        TextFieldCertificatename.setText("Certificate tag");
        return TextFieldCertificatename;
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
