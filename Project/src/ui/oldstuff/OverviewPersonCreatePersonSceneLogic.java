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
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import database.CRUD;

public class OverviewPersonCreatePersonSceneLogic {


    protected static EventHandler<MouseEvent> eventMouseClick(Button standardButton) {
        EventHandler<MouseEvent> eventMouseClick = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                TextArea emailTextArea = OverviewPersonCreatePersonScene.space.getChildren().get(1);
                String email = "test";
                 new CRUD().create(email);

                CodeCademyStage.getStage().setScene(OverviewPersonScene.overviewPersonScene());;
            }
        };
        return eventMouseClick;
    }
}
