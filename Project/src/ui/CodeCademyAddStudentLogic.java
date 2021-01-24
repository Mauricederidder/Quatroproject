package ui;

import java.sql.Date;

import database.CertificateRepo;
import database.ModuleRepo;
import database.StudentRepo;
import domain.Certificate;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import Logic.Validation;


public class CodeCademyAddStudentLogic {

    protected static EventHandler<MouseEvent> eventHandlerBack() {
        EventHandler<MouseEvent> eventHandlerMouseOver = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                CodeCademyStage.getStage().setScene(CodeCademySearchStudent.codeCademySearchStudentSceneBuilder());
            }
        };
        return eventHandlerMouseOver;
    }

    protected static EventHandler<MouseEvent> EventHandlerMouseClickAddStudent(TextField email, TextField naam,
            ComboBox gender, TextField address, TextField contactCity, TextField postalCode, Label error) {
        EventHandler<MouseEvent> eventHandlerMouseOver = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                Validation v = new Validation();
               
                String studentEmail = email.getText();
                String studentNaam = naam.getText();
                String gend = String.valueOf(gender.getValue());
                String adres = address.getText();
                String studentContactCity = contactCity.getText();
                String studentPostalCode = postalCode.getText();
                String country = "Netherlands";
                Date dayofBirth = Date.valueOf("1997-02-16");  


                
                Student student = new Student(studentEmail, studentNaam, dayofBirth, gend,
                adres, studentContactCity, country, studentPostalCode, 0);
                if (v.validatePerson(student)){
                    StudentRepo s = new StudentRepo();
                    s.create(student);
                    CodeCademyStage.getStage().setScene(CodeCademySearchStudent.codeCademySearchStudentSceneBuilder());
                } else {
                    error.setVisible(true);
                }
    
            }
        };
        return eventHandlerMouseOver;

        

    }

}
