package ui;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.effect.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class CodeCademyLandingScene {

    protected static Scene codeCademyLandingScene() {
        Scene codeCademyLandingScene = new Scene(codeCademyLandingSceneRootLayout());
        return codeCademyLandingScene;
    }

    protected static BorderPane codeCademyLandingSceneRootLayout() {
        BorderPane root = new BorderPane();
        root.setMinSize(400, 300);
        root.setTop(codeCademyLandingSceneGridPaneHeader());
        root.setCenter(codeCademyLandingSceneGridPaneCenter());
        return root;
    }

    protected static GridPane codeCademyLandingSceneGridPaneHeader() {
        GridPane layout = new GridPane();
        Button overviewPersonButton = CodeCademyLandingSceneLogic.regularButton();
        overviewPersonButton.setText("Cursisten");
        Button codeCademyLandingSceneButton = CodeCademyLandingSceneLogic.regularButton();
        codeCademyLandingSceneButton.setText("Home");

        // layout.setPadding(new Insets(10, 10, 10, 10));
        layout.setMinSize(100, 200);
        layout.add(CodeCademyLandingSceneLogic.headerLabel(), 1, 0, 2, 1);
        layout.add(new Label(""), 0, 1);
        layout.add(codeCademyLandingSceneButton, 0, 2);
        layout.add(overviewPersonButton, 1, 2);
        layout.add(CodeCademyLandingSceneLogic.regularButton(), 2, 2);
        layout.add(CodeCademyLandingSceneLogic.regularButton(), 3, 2);
        layout.setAlignment(Pos.TOP_CENTER);
        return layout;
    }

    protected static GridPane codeCademyLandingSceneGridPaneCenter() {
        GridPane layout = new GridPane();
        layout.add(CodeCademyLandingSceneLogic.informationText(), 0, 0);
        layout.setAlignment(Pos.TOP_CENTER);
        return layout;
    }



}
