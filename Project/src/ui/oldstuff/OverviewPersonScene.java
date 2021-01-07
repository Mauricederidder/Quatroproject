package ui.oldstuff;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

import database.CRUD;
import domain.Student;

public class OverviewPersonScene {

    protected static Scene overviewPersonScene() {
        Scene overviewPersonScene = new Scene(overviewPersonRootLayout());
        return overviewPersonScene;
    }

    protected static BorderPane overviewPersonRootLayout() {
        BorderPane root = new BorderPane();
        root.setMinSize(400, 300);
        root.getChildren().add(overviewPersonMenuBar());
        root.getChildren().add(overviewPersonVBoxAllPeople());
        return root;
    }

    protected static VBox overviewPersonVBoxAllPeople(){
        VBox vertical = new VBox();
        vertical.getChildren().add(new Label("Overzicht personen"));
        for (Student student : new CRUD().readTest()) {
            Label label = new Label();
            label.setText(student.getEmail());
            vertical.getChildren().add(label);
        }
        return vertical;
    }

    protected static HBox overviewPersonMenuBar(){
        HBox menu = new HBox();
        for(Button button : overviewPersonMenuButton()){
            menu.getChildren().add(button);
        }
        return menu;
    }    

    protected static ArrayList<Button> overviewPersonMenuButton(){
        ArrayList<Button> menuBar = new ArrayList<>();
        Button home = CodeCademyLandingSceneLogic.regularButton();
        home.setText("Home");
        Button createPerson = CodeCademyLandingSceneLogic.regularButton();
        createPerson.setText("Aanmaken");
        Button updatePerson = CodeCademyLandingSceneLogic.regularButton();
        updatePerson.setText("Update");
        Button deletePerson = CodeCademyLandingSceneLogic.regularButton();
        deletePerson.setText("Delete");
        menuBar.add(home);
        menuBar.add(createPerson);
        menuBar.add(updatePerson);
        menuBar.add(deletePerson);
        return menuBar;
    }

    
}
