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
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import domain.Module;

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
        vbox.getChildren().add(codeCademyAddCourseTextFieldLabelCourseName());
        vbox.getChildren().add(codeCademyAddCourseTextFieldCourseName());
        vbox.getChildren().add(new Label(""));
        vbox.getChildren().add(codeCademyAddCourseTextFieldLabelCourseTag());
        vbox.getChildren().add(codeCademyAddCourseTextFieldCourseTag());
        vbox.getChildren().add(new Label(""));
      //  vbox.getChildren().add(codeCademyAddCourseAddModulesOverview());
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

    protected static Label codeCademyAddCourseTextFieldLabelCourseTag(){
        Label TextFieldLabelOne = new Label("Course tag: ");
        TextFieldLabelOne.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(),16));
        TextFieldLabelOne.setTextFill(Color.web("#000000", 1.0));
        return TextFieldLabelOne;
    }

    protected static TextField codeCademyAddCourseTextFieldCourseTag(){
        TextField TextFieldCoursename = new TextField();
        TextFieldCoursename.setText("Course tag");
        return TextFieldCoursename;
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
    protected static Button codeCademyAddCourseAddModuleButton(){
        Button button = new Button("Add Module");
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

        ModuleRepo moduleRepo = new ModuleRepo();
        List<Module> modules = moduleRepo.get();
        for (int i = 0; i < modules.size() ; i++) {
            grid.add(codeCademyAddCourseAllModules(modules.get(i)), 0, 1+i);
            grid.add(codeCademyAddCourseAddModuleButton(),1,1+i);
        }

        grid.add(new Label(""),0,2);

        //grid.setPadding(new Insets(20,79,20,20));
        return grid;
    }

    protected static Label codeCademyAddCourseAllModules(Module moduleToAdd){
        Label AllModules = new Label(moduleToAdd.getTitle());
        AllModules.setStyle("-fx-background-color:#404040");
        AllModules.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(),14));
        AllModules.setTextFill(Color.web("#FFFFFF"));;
        return AllModules;
    }

}