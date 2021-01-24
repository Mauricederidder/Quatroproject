package ui;

import domain.Course;
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

public class CodeCademyClickedCourseStatisticsLogic {

    protected static EventHandler<MouseEvent> EventMouseOnClickAddModuleButton(Course name) {
        EventHandler<MouseEvent> EventMouseOnClickAddModuleButton = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                CodeCademyStage.getStage().setScene(codeCademyAddModule.CodeCademyAddModuleSceneBuilder(name));;
            }
        };
        return EventMouseOnClickAddModuleButton;
    }

    protected static EventHandler<MouseEvent> eventHandlerBack() {
        EventHandler<MouseEvent> eventHandlerMouseOver = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                CodeCademyStage.getStage().setScene(CodeCademyAllCoursesScene.CodeCademyAllCoursesSceneBuilder());
            }
        };
        return eventHandlerMouseOver;
    }
}
