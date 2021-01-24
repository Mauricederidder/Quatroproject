package ui;

import java.util.List;

import database.ModuleRepo;
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
import domain.Level;
import domain.Module;

public class CodeCademyAddCourse {
    private static List<Module> modules;

    protected static Scene codeCademyAddCourseSceneBuilder(){
        Scene codeCademyAllCoursesScene = new Scene(codeCademyScrollPane());
        return codeCademyAllCoursesScene;
    }

    protected static ScrollPane codeCademyScrollPane(){
        ScrollPane s = new ScrollPane(); 
        s.setContent(codeCademyAddCourseLayout());
        s.pannableProperty().set(true);
        s.fitToWidthProperty().set(true);
        s.fitToHeightProperty().set(true);
        return s;
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
        Button addCourseButton = codeCademyAddCourseButton();

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
        // vbox.getChildren().add(codeCademyAddCourseGridPane());
        vbox.getChildren().add(new Label(""));
        vbox.getChildren().add(new Label(""));
        vbox.getChildren().add(addCourseButton);

        addCourseButton.addEventHandler(MouseEvent.MOUSE_CLICKED, CodeCademyAddCourseLogic.EventHandlerMouseClickedAddCourse(courseName,courseSubject,difficulty,introText,description));

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
            Level.values()
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
    // protected static Button codeCademyAddCourseAddModuleButton(Module module){
    //     Button button = new Button("Add Module");
    //     button.setStyle("-fx-background-color:#000000");
    //     button.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(),16));
    //     button.setTextFill(Color.web("#FFFFFF"));;
    //     button.setMaxHeight(50);
    //     button.setMaxWidth(450);
    //     button.addEventHandler(MouseEvent.MOUSE_CLICKED, CodeCademyAddCourseLogic.EventHandlerMouseClickedAddCourseAddModuleButton(button, module));
    //     return button;
        
    // }

    // protected static Label codeCademyAddCourseAddModulesOverview(){
    //     Label addModules = new Label("Addable modules");
    //     addModules.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(),22));
    //     addModules.setTextFill(Color.web("#FFFFFF"));;
    //     addModules.setStyle("-fx-background-color:#000000");
    //     addModules.setPadding(new Insets(20,20,20,20));
    //     return addModules;
    // }

    // protected static GridPane codeCademyAddCourseGridPane(){
    //     GridPane grid = new GridPane();
    //     grid.setHgap(15);
    //     grid.setStyle("-fx-background-color:#404040");

    //     ModuleRepo moduleRepo = new ModuleRepo();
    //     modules = moduleRepo.get();
    //     for (int i = 0; i < modules.size() ; i++) {
    //         grid.add(codeCademyAddCourseAllModules(modules.get(i)), 0, 1+i);
    //         grid.add(codeCademyAddCourseAddModuleButton(modules.get(i)),1,1+i);
    //     }

    //     grid.add(new Label(""),0,2);

    //     //grid.setPadding(new Insets(20,79,20,20));
    //     return grid;
    // }

    protected static Label codeCademyAddCourseAllModules(Module moduleToAdd){
        Label AllModules = new Label(moduleToAdd.getTitle());
        AllModules.setStyle("-fx-background-color:#404040");
        AllModules.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(),14));
        AllModules.setTextFill(Color.web("#FFFFFF"));;
        return AllModules;
    }

}