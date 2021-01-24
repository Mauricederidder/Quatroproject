package ui;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.Date;

import domain.Course;
import domain.Module;
import domain.Status;

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

public class CodeCademyAddModuleLogic {
    
    protected static EventHandler<MouseEvent> eventHandlerMouseClickedAddModule(TextField textFieldModuleVersion, TextField textFieldModuleName, TextField textFieldModuleDescription, TextField textFieldModuleContactName, TextField textFieldModuleContactEmail, Course linkedScene) {
        EventHandler<MouseEvent> eventHandlerMouseClick = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) { 

                String version = textFieldModuleVersion.getText();
                String modulename = textFieldModuleName.getText();
                String moduleDescription = textFieldModuleDescription.getText();
                String moduleContactName = textFieldModuleContactName.getText();
                String moduleContactEmail = textFieldModuleContactEmail.getText();
                // DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/mm/dd");  
                // LocalDateTime now = LocalDateTime.now();  
                // String test = String.valueOf(dtf.format(now));
                Date date = Date.valueOf("2020-01-22");

                Status active = Status.Active;
                // Double v = Double.valueOf(Version);
                double x = Double.parseDouble(version);


                Module newModule = new Module(x, moduleDescription, moduleContactName, moduleContactEmail, linkedScene, active,date, modulename); 
               
                ModuleRepo r = new ModuleRepo();
                r.create(newModule); 
                CodeCademyStage.getStage().setScene(CodeCademyClickedCourseStatistics.codeCademyClickedCourseStatisticsSceneBuilder(linkedScene));
            }
        };
        return eventHandlerMouseClick;
    }

}
