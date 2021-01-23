package ui;

import domain.Course;
import domain.Module;
import domain.Status;
import domain.Student;
import database.ModuleRepo;
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
import javafx.scene.text.Text;

public class CodeCademyAccountInformationLogic {

        protected static EventHandler<MouseEvent> showStudentCourseInformation(Course course, Student student) {
            EventHandler<MouseEvent> showStudentCourseInformation = new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    CodeCademyStage.getStage().setScene(codeCademyStudentFollowedCourse.codeCademyStudentFollowedCourseSceneBuilder(course,student));
                }
            };
            return showStudentCourseInformation;
        }
}
