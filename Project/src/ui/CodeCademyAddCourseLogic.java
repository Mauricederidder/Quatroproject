package ui;

import java.util.ArrayList;
import java.util.List;

import database.CertificateRepo;
import database.CourseRepo;
import database.ModuleRepo;
import domain.Certificate;
import domain.ContentItem;
import domain.Course;
import domain.Level;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.effect.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import domain.Module;

public class CodeCademyAddCourseLogic {

    // private static List<Module> addedModules = new ArrayList<Module>();

    protected static EventHandler<MouseEvent> EventHandlerMouseClickedAddCourse(TextField courseName,
            TextField courseSubject, ComboBox difficulty, TextField introText, TextField description) {
        EventHandler<MouseEvent> EventHandlerMouseClickedAddCourse = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                String cName = courseName.getText();
                String cSubject = courseSubject.getText();

                Level courseDifficulty = Level.valueOf(String.valueOf(difficulty.getValue()));

                String intText = introText.getText();
                String desc = description.getText();
                
                List<ContentItem> content = new ArrayList<>();
                // content.addAll(addedModules);
                
                Course newCourse = new Course(0,cName,courseDifficulty,cSubject,intText,desc,content);
                
                CourseRepo crepo = new CourseRepo();
                crepo.create(newCourse);
                CodeCademyStage.getStage().setScene(CodeCademyAllCoursesScene.codeCademyAllCoursesSceneBuilder());
            }
        };
        return EventHandlerMouseClickedAddCourse;
    }

    // protected static EventHandler<MouseEvent> EventHandlerMouseClickedAddCourseAddModuleButton(Button button,
    //         Module module) {
    //     EventHandler<MouseEvent> EventHandlerMouseClickedAddCourse = new EventHandler<MouseEvent>() {
    //         @Override
    //         public void handle(MouseEvent e) {
    //             button.setVisible(false);
    //             addedModules.add(module);
                
    //         }


    //     };
    //     return EventHandlerMouseClickedAddCourse;
    // }



}
