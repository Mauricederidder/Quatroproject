package ui;

import java.util.ArrayList;
import java.util.List;

import database.CourseRepo;
import database.ModuleRepo;
import domain.Course;
import domain.Module;
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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class CodeCademyClickedCourseStatistics {

    private static Course linkedCourse;

    protected static Scene CodeCademyClickedCourseStatisticsSceneBuilder(Course course) {
        linkedCourse = course;
        Scene codeCademyAllCoursesScene = new Scene(codeCademyClickedCourseStatisticsLayout());
        return codeCademyAllCoursesScene;
    }

    protected static BorderPane codeCademyClickedCourseStatisticsLayout() {
        BorderPane root = new BorderPane();
        root.setMinSize(800, 900);
        root.setTop(codeCademyClickedCourseStatisticsGridHeader());
        root.setCenter(codeCademyClickedCourseStatisticsCenterLayout());
        return root;
    }

    protected static FlowPane codeCademyClickedCourseStatisticsCenterLayout() {
        FlowPane rootToo = new FlowPane();
        rootToo.getChildren().add(codeCademyClickedCourseStatisticsGridPaneAddCertificate());
        rootToo.getChildren().add(codeCademyClickedCourseStatisticsBestMatchingCourseVbox());
        rootToo.getChildren().add(codeCademyClickedCourseStatisticsModulesCompletionGridPane());
        rootToo.setVgap(10);
        rootToo.setHgap(10);
        rootToo.setAlignment(Pos.TOP_CENTER);
        return rootToo;
    }

    protected static GridPane codeCademyClickedCourseStatisticsGridHeader() {
        GridPane headerGrid = new GridPane();
        headerGrid.setPadding(new Insets(30, 10, 50, 10));
        headerGrid.setHgap(30);
        headerGrid.add(codeCademyClickdCourseEmptyLabel(), 0, 1);
        headerGrid.add(codeCademyClickedCourseStatisticsSceneHeader(), 0, 2);
        headerGrid.add(codeCademyClickdCourseEmptyLabel(), 0, 3);
        headerGrid.add(codeCademyClickedCourseStatisticsAmountOfPeopleLabel(), 0, 4);
        headerGrid.setAlignment(Pos.TOP_CENTER);
        return headerGrid;
    }

    protected static Label codeCademyClickdCourseEmptyLabel() {
        Label emptyLabel = new Label();
        return emptyLabel;
    }

    protected static VBox codeCademyClickedCourseStatisticsSceneHeader() {
        VBox headerVbox = new VBox();
        headerVbox.getChildren().add(codeCademyClickedCourseStatisticsHeaderTitle());
        return headerVbox;
    }

    protected static Label codeCademyClickedCourseStatisticsHeaderTitle() {
        
        Label title = new Label("Course -" + linkedCourse.getCourseName());
        title.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(), 36));
        return title;
    }

    protected static Label codeCademyClickedCourseStatisticsAmountOfPeopleLabel() {
        CourseRepo courseRepo = new CourseRepo();
        
        Label amountOfPeopleLabel = new Label("Completed by: " + courseRepo.totalClearedBasedOnCourse(linkedCourse.getCourseId()).toString() + " students");
        amountOfPeopleLabel.setFont(
                Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Regular.ttf").toExternalForm(), 22));
        return amountOfPeopleLabel;
    }

    protected static GridPane codeCademyClickedCourseStatisticsGridPaneAddCertificate() {
        GridPane grid = new GridPane();
        Button button = codeCademyClickedCourseStatisticsAddCertificateButton();
        Label label = codeCademyClickedCourseStatisticsAddCertificateLabel();
        button.setMinWidth(100);
        button.setMaxWidth(250);
        grid.getColumnConstraints().add(new ColumnConstraints(230));
        grid.getColumnConstraints().add(new ColumnConstraints(30));
        grid.add(label, 0, 0);
        grid.add(button, 0, 1);
        return grid;
    }

    protected static Label codeCademyClickedCourseStatisticsAddCertificateLabel() {
        Label addCertificateLabel = new Label("Add a certificate to this course");
        addCertificateLabel.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Regular.ttf").toExternalForm(), 14));
        return addCertificateLabel;
    }

    protected static Button codeCademyClickedCourseStatisticsAddCertificateButton() {
        Button addCertificateButton = new Button("Add Certificate");
        addCertificateButton.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Regular.ttf").toExternalForm(), 14));
        addCertificateButton.setTextFill(Color.web("#ffffff", 1.0));
        addCertificateButton.setStyle("-fx-background-color:#000000;");
        
        return addCertificateButton;
    }

    protected static VBox codeCademyClickedCourseStatisticsBestMatchingCourseVbox() {
        VBox matchingCourseVbox = new VBox();
        matchingCourseVbox.getChildren().add(codeCademyClickedCourseStatisticsBestMatchingCourseGridPane());
        return matchingCourseVbox;
    }

    protected static GridPane codeCademyClickedCourseStatisticsBestMatchingCourseGridPane() {
        // Table header
        GridPane matchingCourse = new GridPane();
        Label tableHeaderLabel = codeCademyClickedCourseStatisticsAmountOfPeopleBestMatchingCoursesLabel();
        matchingCourse.getColumnConstraints().add(new ColumnConstraints(60));
        matchingCourse.getColumnConstraints().add(new ColumnConstraints(190));
        for (int i = 0; i < 2; i++) {
            ColumnConstraints column = new ColumnConstraints(170);
            matchingCourse.getColumnConstraints().add(column);
        }
        Label FirstColumnFirstRow = codeCademyClickedCourseStatisticsAmountOfPeopleBestMatchingCoursesRankingLabel();
        Label SecondColumnFirstRow = codeCademyClickedCourseStatisticsAmountOfPeopleBestMatchingCoursesCourseLabel();
        Label ThirdColumnFirstRow = codeCademyClickedCourseStatisticsAmountOfPeopleBestMatchingCoursesStudentsLabel();
        Label FourthColumnFirstRow = codeCademyClickedCourseStatisticsAmountOfPeopleBestMatchingCoursesStudentsMatchendeTags();
        // fillerendofdata
        matchingCourse.setStyle("-fx-background-color:#000000");
        matchingCourse.setVgap(20);
        matchingCourse.setHgap(10);
        matchingCourse.add(tableHeaderLabel, 0, 1);
        matchingCourse.setColumnSpan(tableHeaderLabel, 4);
        matchingCourse.add(FirstColumnFirstRow, 0, 2);
        matchingCourse.add(SecondColumnFirstRow, 1, 2);
        matchingCourse.add(ThirdColumnFirstRow, 2, 2);
        matchingCourse.add(FourthColumnFirstRow, 3, 2);

        // fillerendofdata
        FirstColumnFirstRow.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        SecondColumnFirstRow.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        ThirdColumnFirstRow.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        FourthColumnFirstRow.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        // TABLE DATA
        // CourseRepo courseRepo = new CourseRepo();
        // courseRepo.matchingCoursesBasedOnTag(courseRepo.);
        CourseRepo courseRepo = new CourseRepo();

        // Vergeef mij voor de zonden die ik heb begaan.
        List bestMatchingCourses = courseRepo.matchingCoursesBasedOnTag( courseRepo.getTagsBasedOnCourse(linkedCourse.getCourseId()).get(0).toString());
        
        for (int i = 0; i < bestMatchingCourses.size(); i++) {

            if(i % 3 == 0){
                
                Label FirstColumnSecondRow = codeCademyClickedCourseStatisticsAmountofPeopleDummyDataOne(i/3);
                Label SecondColumnSecondRow = codeCademyClickedCourseStatisticsAmountofPeopleDummyDataTwo(bestMatchingCourses.get(i/3+2).toString());
                Label ThirdColumnSecondRow = codeCademyClickedCourseStatisticsAmountofPeopleDummyDataThree(bestMatchingCourses.get(i/3+1).toString());
                Label FourthColumnSecondRow = codeCademyClickedCourseStatisticsAmountofPeopleDummyDataFour(bestMatchingCourses.get(i/3).toString());
    
                FirstColumnSecondRow.setPadding(new Insets(25, 10, 25, 10));
                SecondColumnSecondRow.setPadding(new Insets(25, 10, 25, 10));
                ThirdColumnSecondRow.setPadding(new Insets(25, 10, 25, 10));
                FourthColumnSecondRow.setPadding(new Insets(25, 10, 25, 10));
            
                FirstColumnSecondRow.setMaxSize(170, 40);
                SecondColumnSecondRow.setMaxSize(170, 40);
                ThirdColumnSecondRow.setMaxSize(170, 40);
                FourthColumnSecondRow.setMaxSize(170, 40);
                
                matchingCourse.add(FirstColumnSecondRow, 0, 3+i/3);
                matchingCourse.add(SecondColumnSecondRow, 1, 3+i/3);
                matchingCourse.add(ThirdColumnSecondRow, 2, 3+i/3);
                matchingCourse.add(FourthColumnSecondRow, 3, 3+i/3); 
            }  

        }
        return matchingCourse;
    }

    protected static Label codeCademyClickedCourseStatisticsAmountOfPeopleBestMatchingCoursesLabel() {
        Label amountOfPeopleLabel = new Label("Best matching courses");
        amountOfPeopleLabel.setFont(
                Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Regular.ttf").toExternalForm(), 22));
        amountOfPeopleLabel.setTextFill(Color.web("#FFFFFF", 1.0));
        return amountOfPeopleLabel;
    }

    protected static Label codeCademyClickedCourseStatisticsAmountOfPeopleBestMatchingCoursesRankingLabel() {
        Label amountOfPeopleLabel = new Label("Ranking");
        amountOfPeopleLabel.setFont(
                Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Regular.ttf").toExternalForm(), 14));
        amountOfPeopleLabel.setTextFill(Color.web("#FFFFFF", 1.0));
        return amountOfPeopleLabel;
    }

    protected static Label codeCademyClickedCourseStatisticsAmountOfPeopleBestMatchingCoursesCourseLabel() {
        Label amountOfPeopleLabel = new Label("Course");
        amountOfPeopleLabel.setFont(
                Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Regular.ttf").toExternalForm(), 14));
        amountOfPeopleLabel.setTextFill(Color.web("#FFFFFF", 1.0));
        return amountOfPeopleLabel;
    }

    protected static Label codeCademyClickedCourseStatisticsAmountOfPeopleBestMatchingCoursesStudentsLabel() {
        Label amountOfPeopleLabel = new Label("Students");
        amountOfPeopleLabel.setFont(
                Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Regular.ttf").toExternalForm(), 14));
        amountOfPeopleLabel.setTextFill(Color.web("#FFFFFF", 1.0));
        return amountOfPeopleLabel;
    }

    protected static Label codeCademyClickedCourseStatisticsAmountOfPeopleBestMatchingCoursesStudentsMatchendeTags() {
        Label amountOfPeopleLabel = new Label("Matching tags");
        amountOfPeopleLabel.setFont(
                Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Regular.ttf").toExternalForm(), 14));
        amountOfPeopleLabel.setTextFill(Color.web("#FFFFFF", 1.0));
        return amountOfPeopleLabel;
    }

    // filler data
    protected static Label codeCademyClickedCourseStatisticsAmountofPeopleDummyDataOne(Integer i) {
        Label label = new Label( i.toString());
        label.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Regular.ttf").toExternalForm(), 14));
        label.setTextFill(Color.web("#FFFFFF", 1.0));
        label.setStyle("-fx-background-color:#404040");
        return label;
    }

    protected static Label codeCademyClickedCourseStatisticsAmountofPeopleDummyDataTwo(String courseName) {
        Label label = new Label(courseName);
        label.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Regular.ttf").toExternalForm(), 14));
        label.setTextFill(Color.web("#FFFFFF", 1.0));
        label.setStyle("-fx-background-color:#404040");
        return label;
    }

    protected static Label codeCademyClickedCourseStatisticsAmountofPeopleDummyDataThree(String studentAmount) {
        Label label = new Label(studentAmount);
        label.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Regular.ttf").toExternalForm(), 14));
        label.setTextFill(Color.web("#FFFFFF", 1.0));
        label.setStyle("-fx-background-color:#404040");
        return label;
    }

    protected static Label codeCademyClickedCourseStatisticsAmountofPeopleDummyDataFour(String tags) {
        Label label = new Label(tags);
        label.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Regular.ttf").toExternalForm(), 14));
        label.setTextFill(Color.web("#FFFFFF", 1.0));
        label.setStyle("-fx-background-color:#404040");
        return label;
    }
    // end of filler data

    protected static GridPane codeCademyClickedCourseStatisticsModulesCompletionGridPane() {
        GridPane matchingCourse = new GridPane();
        Label tableHeaderLabel = codeCademyClickedCourseStatisticsModulesCompletionHeaderLabel();
        for (int i = 0; i < 2; i++) {
            ColumnConstraints column = new ColumnConstraints(90);
            matchingCourse.getColumnConstraints().add(column);
        }
        Label FirstColumnFirstRow = codeCademyClickedCourseStatisticsModulesCompletionLabelOne();
        Label SecondColumnFirstRow = codeCademyClickedCourseStatisticsModulesCompletionLabelTwo();
        // fillerendofdata
        FirstColumnFirstRow.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        SecondColumnFirstRow.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        // fillerendofdata
        matchingCourse.setStyle("-fx-background-color:#000000");
        matchingCourse.setVgap(20);
        matchingCourse.setHgap(10);
        matchingCourse.add(tableHeaderLabel, 0, 1);
        matchingCourse.setColumnSpan(tableHeaderLabel, 4);
        matchingCourse.add(FirstColumnFirstRow, 0, 2);
        matchingCourse.add(SecondColumnFirstRow, 1, 2);
        

        CourseRepo courseRepo = new CourseRepo();
        ArrayList<Module> modules = courseRepo.getProgress(linkedCourse.getCourseId());
        for (int i = 0; i < modules.size(); i++) {
            
            Label FirstColumnSecondRow = codeCademyClickedCourseStatisticsModulesCompletionLabelSecondRowOne(modules.get(i).getTitle());
            Label SecondColumnSecondRow = codeCademyClickedCourseStatisticsModulesCompletionLabelSecondRowTwo(modules.get(i).getAvarageProgress());
            FirstColumnSecondRow.setPadding(new Insets(25, 10, 25, 10));
            SecondColumnSecondRow.setPadding(new Insets(25, 10, 25, 10));
    
            FirstColumnSecondRow.setMaxSize(190, 40);
            SecondColumnSecondRow.setMaxSize(50, 40);
          
            matchingCourse.add(FirstColumnSecondRow, 0, 3+i);
            matchingCourse.add(SecondColumnSecondRow, 1, 3+i);
        }
        // fillerendofdata
        return matchingCourse;
    }

    protected static Label codeCademyClickedCourseStatisticsModulesCompletionHeaderLabel(){
        Label label = new Label("Modules completion");
        label.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Regular.ttf").toExternalForm(), 18));
        label.setTextFill(Color.web("#FFFFFF", 1.0));
        return label;
    }

    protected static Label codeCademyClickedCourseStatisticsModulesCompletionLabelOne(){
        Label label = new Label("Module name");
        label.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Regular.ttf").toExternalForm(), 12));
        label.setTextFill(Color.web("#FFFFFF", 1.0));
        return label;
    }

    protected static Label codeCademyClickedCourseStatisticsModulesCompletionLabelTwo(){
        Label label = new Label("voortgang");
        label.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Regular.ttf").toExternalForm(), 12));
        label.setTextFill(Color.web("#FFFFFF", 1.0));
        return label;
    }

    protected static Label codeCademyClickedCourseStatisticsModulesCompletionLabelSecondRowOne(String moduleName){
        Label label = new Label(moduleName);
        label.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Regular.ttf").toExternalForm(), 12));
        label.setTextFill(Color.web("#FFFFFF", 1.0));
        label.setStyle("-fx-background-color:#404040");
        return label;
    }

    protected static Label codeCademyClickedCourseStatisticsModulesCompletionLabelSecondRowTwo(String avarageProgress){
        Label label = new Label(avarageProgress);
        label.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Regular.ttf").toExternalForm(), 12));
        label.setTextFill(Color.web("#FFFFFF", 1.0));
        label.setStyle("-fx-background-color:#404040");
        return label;
    }

}
