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


public class CodeCademyLandingSceneLogic {
    

    // Returns an EventHandler so the button goes to a different color when hovering.
    protected static EventHandler<MouseEvent> eventHandlerAllCourses() {
        EventHandler<MouseEvent> eventHandlerMouseOver = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                CodeCademyStage.getStage().setScene(CodeCademyAllCoursesScene.CodeCademyAllCoursesSceneBuilder());;
            }
        };
        return eventHandlerMouseOver;
    }

    protected static EventHandler<MouseEvent> eventHandlerStudentSearch() {
        EventHandler<MouseEvent> eventHandlerMouseOver = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                CodeCademyStage.getStage().setScene(CodeCademySearchStudent.CodeCademySearchStudentSceneBuilder());;
            }
        };
        return eventHandlerMouseOver;
    }

    protected static EventHandler<MouseEvent> eventHandlerAddcourses() {
        EventHandler<MouseEvent> eventHandlerMouseOver = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                CodeCademyStage.getStage().setScene(CodeCademyAddCourse.CodeCademyAddCourseSceneBuilder());;
            }
        };
        return eventHandlerMouseOver;
    }


}
