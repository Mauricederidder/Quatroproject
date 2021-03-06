package ui;

import java.util.ArrayList;
import java.util.List;

import database.StudentRepo;
import domain.Student;
import domain.Certificate;
import domain.Course;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.effect.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class CodeCademyAccountInformation {

    private static Student student;

    protected static Scene codeCademyAccountInformationSceneBuilder(Student studentArg) {
        student = studentArg;
        Scene codeCademyAllCoursesScene = new Scene(codeCademyScrollPane());
        return codeCademyAllCoursesScene;
    }

    protected static ScrollPane codeCademyScrollPane(){
        ScrollPane s = new ScrollPane(); 
        s.setContent(codeCademyAccountInformationLayout());
        s.pannableProperty().set(true);
        s.fitToWidthProperty().set(true);
        s.fitToHeightProperty().set(true);
        return s;
    }

    protected static BorderPane codeCademyAccountInformationLayout() {
        BorderPane root = new BorderPane();
        root.setMinSize(800, 900);
        root.setTop(codeCademyAccountInformationGridHeader());
        root.setCenter(codeCademyAccountInformationCenterLayout());
        return root;
    }

    protected static GridPane codeCademyAccountInformationGridHeader() {
        GridPane headerGrid = new GridPane();
        Label emptyLabel = new Label();
        headerGrid.setPadding(new Insets(30, 10, 50, 10));
        headerGrid.setHgap(30);
        headerGrid.add(codeCademyAccountInformationBackButton(), 0 ,0);
        headerGrid.add(emptyLabel, 0, 1);
        headerGrid.add(codeCademyAccountInformationSceneHeader(), 0, 2);
        headerGrid.setAlignment(Pos.TOP_CENTER);
        return headerGrid;
    }

    protected static VBox codeCademyAccountInformationSceneHeader() {
        VBox headerVbox = new VBox();
        headerVbox.getChildren().add(codeCademyAccountInformationHeaderTitle());
        return headerVbox;
    }

    protected static Button codeCademyAccountInformationBackButton(){
        Button button = new Button("Back");
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, CodeCademyAccountInformationLogic.eventHandlerBack());
        button.setAlignment(Pos.TOP_LEFT);
        return button;
    }

    protected static Label codeCademyAccountInformationHeaderTitle() {
        Label title = new Label("Account Information - "+ student.getName());
        title.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(), 40));
        return title;
    }

    protected static FlowPane codeCademyAccountInformationCenterLayout() {
        FlowPane rootToo = new FlowPane();
        rootToo.setVgap(10);
        rootToo.setHgap(10);
        rootToo.getChildren().add(codeCademyAccountInformationContentHbox());
        rootToo.setAlignment(Pos.TOP_CENTER);
        return rootToo;
    }

    protected static HBox codeCademyAccountInformationContentHbox() {
        HBox hbox = new HBox();
        hbox.getChildren().add(codeCademyAccountInformationCertificatesVbox());
        hbox.getChildren().add(new Label("                      "));
        hbox.getChildren().add(codeCademyAccountInformationFollowedCourseVbox());
        return hbox;
    }

    protected static VBox codeCademyAccountInformationCertificatesVbox() {
        VBox vbox = new VBox();
        vbox.getChildren().add(codeCademyAccountInformationCertificatesHeader());
        vbox.getChildren().add(codeCademyAllCoursesCertificatesGridPaneTables());
        return vbox;
    }

    protected static Label codeCademyAccountInformationCertificatesHeader() {
        Label Label = new Label("Completed certificates");
        Label.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(), 16));
        Label.setTextFill(Color.web("#000000", 1.0));
        return Label;
    }

    protected static GridPane codeCademyAllCoursesCertificatesGridPaneTables() {
        // Make TABLE
        GridPane tablesGrid = new GridPane();
        tablesGrid.getColumnConstraints().add(new ColumnConstraints(30));
        Label tableHeaderLabel = codeCademyAccountInformationCertificatesTableHeader();
        Label FirstColumnFirstRow = codeCademyAccountInformationCertificatesTablFirstColumn();

        FirstColumnFirstRow.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
       
        tablesGrid.setStyle("-fx-background-color:#000000");
        tablesGrid.setVgap(20);
        tablesGrid.setHgap(10);
        tablesGrid.add(tableHeaderLabel, 1, 0);
        tablesGrid.setColumnSpan(tableHeaderLabel,2);
        tablesGrid.add(FirstColumnFirstRow, 1, 1);
        // Fill in DATA
        StudentRepo studentRepo = new StudentRepo();
        List<Course> courses = studentRepo.getStudentCourse(student.getStudentId());
        for (int i = 0; i < courses.size(); i++) {

            Label FirstColumnSecondRow = codeCademyAccountInformationCertificatesFillerData(courses.get(i));
            FirstColumnSecondRow.setPadding(new Insets(25, 10, 25, 10));
            FirstColumnSecondRow.setMaxSize(170, 40);
            tablesGrid.add(FirstColumnSecondRow, 1, 2+i);
            FirstColumnSecondRow.addEventHandler(MouseEvent.MOUSE_CLICKED, CodeCademyAccountInformationLogic.showStudentCourseInformation(courses.get(i),student));
        }
        return tablesGrid;
    }

    protected static Label codeCademyAccountInformationCertificatesTableHeader() {
        Label Label = new Label("Courses");
        Label.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(), 18));
        Label.setTextFill(Color.web("#FFFFFF", 1.0));
        return Label;
    }

    protected static Label codeCademyAccountInformationCertificatesTablFirstColumn() {
        Label Label = new Label("Course name");
        Label.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(), 14));
        Label.setTextFill(Color.web("#FFFFFF", 1.0));
        return Label;
    }

    protected static Label codeCademyAccountInformationCertificatesFillerData(Course course) {
        Label Label = new Label(course.getCourseName());
        Label.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(), 12));
        Label.setTextFill(Color.web("#FFFFFF", 1.0));
        Label.setStyle("-fx-background-color:#404040");
        return Label;
    }

    protected static VBox codeCademyAccountInformationFollowedCourseVbox() {
        VBox vbox = new VBox();
        vbox.getChildren().add(codeCademyAccountInformationFollowedCourseHeader());
        vbox.getChildren().add(codeCademyAllCoursesFollowedCourseGridPaneTables());
        return vbox;
    }

    protected static Label codeCademyAccountInformationFollowedCourseHeader() {
        Label TextFieldLabelOne = new Label("Earned certificates");
        TextFieldLabelOne.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(), 18));
        TextFieldLabelOne.setTextFill(Color.web("#000000", 1.0));
        return TextFieldLabelOne;
    }
    
    protected static GridPane codeCademyAllCoursesFollowedCourseGridPaneTables() {
        GridPane tablesGrid = new GridPane();
        tablesGrid.getColumnConstraints().add(new ColumnConstraints(30));
        Label tableHeaderLabel = codeCademyAccountInformationFollowedCourseTableHeader();
        Label FirstColumnFirstRow = codeCademyAccountInformationFollowedCourseTablFirstColumn();
        FirstColumnFirstRow.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        tablesGrid.setStyle("-fx-background-color:#000000");
        tablesGrid.setVgap(20);
        tablesGrid.setHgap(10);
        tablesGrid.add(tableHeaderLabel, 1, 0);
        tablesGrid.add(FirstColumnFirstRow, 1, 1);
        tablesGrid.setColumnSpan(tableHeaderLabel, 5);

        // Fill in data
        StudentRepo studentRepo = new StudentRepo();
        List<Certificate> certificates = studentRepo.getStudentCertificate(student.getStudentId());

        for (int i = 0; i < certificates.size(); i++) {
            Label FirstColumnSecondRow = codeCademyAccountInformationFollowedCourseTablesFillerData(certificates.get(i));
            FirstColumnSecondRow.setPadding(new Insets(25, 10, 25, 10));
            FirstColumnSecondRow.setMaxSize(170, 40);
           
            tablesGrid.add(FirstColumnSecondRow, 1, 2+i);
         
        }
        return tablesGrid;
    }

    protected static Label codeCademyAccountInformationFollowedCourseTableHeader() {
        Label Label = new Label("Certificates");
        Label.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(), 18));
        Label.setTextFill(Color.web("#FFFFFF", 1.0));
        return Label;
    }

    protected static Label codeCademyAccountInformationFollowedCourseTablFirstColumn() {
        Label Label = new Label("Certificate name");
        Label.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(), 14));
        Label.setTextFill(Color.web("#FFFFFF", 1.0));
        return Label;
    }
    protected static Label codeCademyAccountInformationFollowedCourseTablesFillerData(Certificate certificate){
        Label Label = new Label(certificate.getName());
        Label.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(), 12));
        Label.setTextFill(Color.web("#FFFFFF", 1.0));
        Label.setStyle("-fx-background-color:#404040");
        return Label;
    }

}
