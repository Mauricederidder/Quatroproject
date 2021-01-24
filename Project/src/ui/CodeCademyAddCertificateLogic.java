package ui;

import database.CertificateRepo;
import database.ModuleRepo;
import domain.Certificate;
import domain.Course;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.effect.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class CodeCademyAddCertificateLogic {


    protected static EventHandler<MouseEvent> EventHandlerMouseClickAddCertificate(TextField naam, ComboBox combo, Course course) {
        EventHandler<MouseEvent> eventHandlerMouseOver = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                String certificateNaam = naam.getText();
                String certificateDifficulty = String.valueOf(combo.getValue());
                int courseId = course.getCourseId();
                Certificate certificate = new Certificate(certificateNaam, certificateDifficulty,courseId);
                CertificateRepo crepo = new CertificateRepo();
                crepo.create(certificate);

                CodeCademyStage.getStage().setScene(CodeCademyClickedCourseStatistics.codeCademyClickedCourseStatisticsSceneBuilder(course));;
            }
        };
        return eventHandlerMouseOver;
    }

    protected static EventHandler<MouseEvent> eventHandlerBack(Course course) {
        EventHandler<MouseEvent> eventHandlerMouseOver = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                CodeCademyStage.getStage().setScene(CodeCademyClickedCourseStatistics.codeCademyClickedCourseStatisticsSceneBuilder(course));
            }
        };
        return eventHandlerMouseOver;
    }



}
