package ui;

import java.time.LocalDate;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class codeCademyAddModuleLogic {
    
    protected static EventHandler<MouseEvent> eventHandlerMouseClickedAddModule(String Version, String Modulename, String ModuleDescription, String ModuleContactName, String ModuleContactEmail, Course linkedScene) {
        EventHandler<MouseEvent> eventHandlerMouseClick = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
                LocalDate now = LocalDate.now();     
                Date current = java.sql.Date.valueOf(dtf.format(now));   
                Status active = Status.Active;
                Double v = Double.valueOf(Version);
                Module newModule = new Module(v, ModuleDescription, ModuleContactName, ModuleContactEmail, linkedScene, active, current, Modulename); 
                ModuleRepo r = new ModuleRepo();
                r.create(newModule); 
                CodeCademyStage.getStage().setScene(CodeCademyClickedCourseStatistics.CodeCademyClickedCourseStatisticsSceneBuilder(linkedScene));
            }
        };
        return eventHandlerMouseClick;
    }

}
