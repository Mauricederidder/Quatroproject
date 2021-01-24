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
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class CodeCademyAddCourse {

    protected static Scene codeCademyAddCourseSceneBuilder(){
        Scene codeCademyAllCoursesScene = new Scene(codeCademyAddCourseLayout());
        return codeCademyAllCoursesScene;
    }

    protected static BorderPane codeCademyAddCourseLayout() {
        BorderPane root = new BorderPane();
        root.setMinSize(800, 900);
        root.setTop(codeCademyAddCourseGridHeader());
        root.setCenter(codeCademyAddCourseCenterLayout());
        return root;
    }

    protected static FlowPane codeCademyAddCourseCenterLayout(){
        FlowPane rootToo = new FlowPane();
        rootToo.setVgap(10);
        rootToo.setHgap(10);
        rootToo.getChildren().add(codeCademyAddCourseTextfieldVbox());
        rootToo.setAlignment(Pos.TOP_CENTER);
        return rootToo;
    }

    protected static GridPane codeCademyAddCourseGridHeader(){
        GridPane headerGrid = new GridPane();
        Label emptyLabel = new Label();
        headerGrid.setPadding(new Insets(30,10,50,10));
        headerGrid.setHgap(30);
        headerGrid.add(emptyLabel,0,1);
        headerGrid.add(codeCademyAddCourseSceneHeader(),0,2);
        headerGrid.setAlignment(Pos.TOP_CENTER);
        return headerGrid;
    }
    
    protected static VBox codeCademyAddCourseSceneHeader(){
        VBox headerVbox = new VBox();
        headerVbox.getChildren().add(codeCademyAddCourseHeaderTitle());
        return headerVbox;
    }

    protected static Label codeCademyAddCourseHeaderTitle(){
        Label title = new Label("Add Course");
        title.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(),40));
        return title;
    }

    protected static VBox codeCademyAddCourseTextfieldVbox(){
        VBox vbox = new VBox();
        TextField courseName = codeCademyAddCourseTextFieldCourseName();
        TextField courseSubject = codeCademyAddCourseTextFieldCourseSubject();
        ComboBox difficulty = codeCademyAddCourseTextFieldCourseDifficulty();
        TextField introText = codeCademyAddCourseTextFieldCourseIntroText();
        TextField description = codeCademyAddCourseTextFieldCourseDescription();

        vbox.getChildren().add(codeCademyAddCourseTextFieldLabelCourseName());
        vbox.getChildren().add(courseName);
        vbox.getChildren().add(new Label(""));
        vbox.getChildren().add(codeCademyAddCourseTextFieldLabelCourseSubject());
        vbox.getChildren().add(courseSubject);
        vbox.getChildren().add(new Label(""));
        vbox.getChildren().add(codeCademyAddCourseTextFieldLabelCourseDifficulty());
        vbox.getChildren().add(difficulty);
        vbox.getChildren().add(new Label(""));
        vbox.getChildren().add(codeCademyAddCourseTextFieldLabelCourseIntoText());
        vbox.getChildren().add(introText);
        vbox.getChildren().add(new Label(""));
        vbox.getChildren().add(codeCademyAddCourseTextFieldLabelCourseDescription());
        vbox.getChildren().add(description);
        vbox.getChildren().add(new Label(""));
        vbox.getChildren().add(codeCademyAddCourseGridPane());
        vbox.getChildren().add(new Label(""));
        vbox.getChildren().add(new Label(""));
        vbox.getChildren().add(codeCademyAddCourseButton());
        return vbox;
    }
    protected static Label codeCademyAddCourseTextFieldLabelCourseName(){
        Label TextFieldLabelOne = new Label("Course name: ");
        TextFieldLabelOne.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(),16));
        TextFieldLabelOne.setTextFill(Color.web("#000000", 1.0));
        return TextFieldLabelOne;
    }

    protected static TextField codeCademyAddCourseTextFieldCourseName(){
        TextField TextFieldCoursename = new TextField();
        TextFieldCoursename.setText("Course name");
        return TextFieldCoursename;
    }

    protected static Label codeCademyAddCourseTextFieldLabelCourseSubject(){
        Label TextFieldLabelOne = new Label("Course subject: ");
        TextFieldLabelOne.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(),16));
        TextFieldLabelOne.setTextFill(Color.web("#000000", 1.0));
        return TextFieldLabelOne;
    }

    protected static TextField codeCademyAddCourseTextFieldCourseSubject(){
        TextField TextFieldCoursename = new TextField();
        TextFieldCoursename.setText("Course subject");
        return TextFieldCoursename;
    }

    protected static Label codeCademyAddCourseTextFieldLabelCourseDifficulty(){
        Label difficulty = new Label("Course Difficulty: ");
        difficulty.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(),16));
        difficulty.setTextFill(Color.web("#000000", 1.0));
        return difficulty;
    }

    protected static ComboBox codeCademyAddCourseTextFieldCourseDifficulty(){
        ComboBox ComboBox = new ComboBox();
        ComboBox.getItems().addAll(
          "Beginner",
          "Advanced",
          "Expert"
          
        );
        ComboBox.getSelectionModel().selectFirst(); 
        return ComboBox;
    }

    protected static Label codeCademyAddCourseTextFieldLabelCourseIntoText(){
        Label label = new Label("Introduction: ");
        label.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(),16));
        label.setTextFill(Color.web("#000000", 1.0));
        return label;
    }

    protected static TextField codeCademyAddCourseTextFieldCourseIntroText(){
        TextField insertIntro = new TextField();
        insertIntro.setText("insert intro");
        return insertIntro;
    }

    protected static Label codeCademyAddCourseTextFieldLabelCourseDescription(){
        Label label = new Label("Description: ");
        label.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(),16));
        label.setTextFill(Color.web("#000000", 1.0));
        return label;
    }

    protected static TextField codeCademyAddCourseTextFieldCourseDescription(){
        TextField Description = new TextField();
        Description.setText("Description");
        return Description;
    }

    protected static Button codeCademyAddCourseButton(){
        Button button = new Button("Add Course");
        button.setStyle("-fx-background-color:#000000");
        button.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(),16));
        button.setTextFill(Color.web("#FFFFFF"));;
        button.setMaxHeight(50);
        button.setMaxWidth(450);
        return button;
    }

    protected static Label codeCademyAddCourseAddModulesOverview(){
        Label addModules = new Label("Addable modules");
        addModules.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(),22));
        addModules.setTextFill(Color.web("#FFFFFF"));;
        addModules.setStyle("-fx-background-color:#000000");
        addModules.setPadding(new Insets(20,20,20,20));
        return addModules;
    }

    protected static GridPane codeCademyAddCourseGridPane(){
        GridPane grid = new GridPane();
        grid.setHgap(15);
        grid.setStyle("-fx-background-color:#404040");
        grid.add(codeCademyAddCourseAllModules(), 0, 1);
        grid.add(codeCademyAddCourseAddModuleButton(),1,1);
        grid.add(new Label(""),0,2);
        grid.add(codeCademyAddCourseAllModulesTest(), 0, 3);
        grid.add(new Label(""),0,4);
        grid.add(codeCademyAddCourseAllModulesTest(), 0, 5);
        //grid.setPadding(new Insets(20,79,20,20));
        return grid;
    }

    protected static Label codeCademyAddCourseAllModules(){
        Label AllModules = new Label("Learning the basics");
        AllModules.setStyle("-fx-background-color:#404040");
        AllModules.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(),14));
        AllModules.setTextFill(Color.web("#FFFFFF"));;
        return AllModules;
    }
    protected static Label codeCademyAddCourseAllModulesTest(){
        Label AllModules = new Label("Getting it down");
        AllModules.setStyle("-fx-background-color:#404040");
        AllModules.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(),14));
        AllModules.setTextFill(Color.web("#FFFFFF"));;
        return AllModules;
    }
    protected static Button codeCademyAddCourseAddModuleButton(){
        Image img = new Image("file:C:\\School\\Leerjaar 1\\Periode 2\\Programmeren 2\\quatro repository\\Quatroproject\\Project\\src\\ui\\plus.png");
        ImageView view = new ImageView(img);
        Button button = new Button();
        button.setGraphic(view);
        button.setStyle("-fx-background-color:#404040;");
        return button;
    }

}
