package ui;

import database.StudentRepo;
import domain.Course;
import domain.Student;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.effect.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

public class CodeCademySearchStudentLogic {
        // Returns an EventHandler so the button goes to a different color when hovering.
        protected static EventHandler<MouseEvent> searchStudentEventHandler(TextField text) {
            EventHandler<MouseEvent> eventHandlerMouseOver = new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    StudentRepo studentRepo = new StudentRepo();
                    CodeCademyStage.getStage().setScene(CodeCademyAccountInformation.CodeCademyAccountInformationSceneBuilder(studentRepo.get(text.getText())));
                }
            };
            return eventHandlerMouseOver;
        }

        protected static EventHandler<MouseEvent> eventHandlerBack() {
            EventHandler<MouseEvent> eventHandlerMouseOver = new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    CodeCademyStage.getStage().setScene(CodeCademyLandingScene.codeCademyLandingScene());;
                }
            };
            return eventHandlerMouseOver;
        }
}
