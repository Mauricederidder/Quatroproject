package ui;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import database.CertificateRepo;
import database.CourseRepo;
import domain.Course;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.effect.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class CodeCademyAllCoursesScene {


    protected static Scene codeCademyAllCoursesSceneBuilder(){
        Scene codeCademyAllCoursesScene = new Scene(codeCademyScrollPane());
        return codeCademyAllCoursesScene;
    }

    protected static ScrollPane codeCademyScrollPane(){
        ScrollPane s = new ScrollPane(); 
        s.setContent(codeCademyAllCoursesLayout());
        s.pannableProperty().set(true);
        s.fitToWidthProperty().set(true);
        s.fitToHeightProperty().set(true);
        return s;
    }

    protected static BorderPane codeCademyAllCoursesLayout() {
        BorderPane root = new BorderPane();
        root.setMinSize(800, 900);
        root.setTop(codeCademyAllCoursesGridHeader());
        root.setCenter(codeCademyAllCoursesCenterLayout());
        return root;
    }

    protected static FlowPane codeCademyAllCoursesCenterLayout(){
        FlowPane rootToo = new FlowPane();
        rootToo.setVgap(10);
        rootToo.setHgap(10);
        rootToo.getChildren().add(codeCademyAllCoursesGridPaneVBox());
        rootToo.getChildren().add(codeCademyAllCoursesGridPaneTopCoursesVBox());
        rootToo.getChildren().add(codeCademyAllCoursesGridPaneMostCertificatesTables());
        return rootToo;
    }

    protected static GridPane codeCademyAllCoursesGridHeader(){
        GridPane headerGrid = new GridPane();
        Label emptyLabel = new Label();
        headerGrid.setPadding(new Insets(30,10,50,10));
        headerGrid.setHgap(30);
        headerGrid.add(emptyLabel,0,1);
        headerGrid.add(codeCademyAllCoursesSceneHeader(),0,2);
        headerGrid.setAlignment(Pos.TOP_CENTER);
        return headerGrid;
    }
    
    protected static VBox codeCademyAllCoursesSceneHeader(){
        VBox headerVbox = new VBox();
        headerVbox.getChildren().add(codeCademyAllCourseHeaderTitle());
        return headerVbox;
    }

    protected static Label codeCademyAllCourseHeaderTitle(){
        Label title = new Label("All courses");
        title.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(),40));
        //title.setFont(font);
        return title;
    }
    
    protected static Label codeCademyLandingSceneEmptyLabel(){
        Label emptyLabel = new Label();
        return emptyLabel;
    }
    
    protected static VBox codeCademyAllCoursesGridPaneVBox(){
        VBox box = new VBox();
        box.getChildren().add(codeCademyAllCoursesGridPaneTables());
        return box;
    }


    protected static GridPane codeCademyAllCoursesGridPaneTables(){
        GridPane tablesGrid = new GridPane();
        tablesGrid.getColumnConstraints().add(new ColumnConstraints(30));
        tablesGrid.getColumnConstraints().add(new ColumnConstraints(180));

        for (int i = 0; i < 3; i++) {
            ColumnConstraints column = new ColumnConstraints(190);
            tablesGrid.getColumnConstraints().add(column);
        }

        Button addButton = new Button("addshit");
        addButton.addEventHandler(MouseEvent.MOUSE_CLICKED, CodeCademyLandingSceneLogic.eventHandlerAddcourses());

        // First, create the table.
        Label tableHeaderLabel = codeCademyAllCoursesGridPaneTableLabelCourseCompletion();
        Label firstColumnFirstRow = codeCademyAllCoursesGridPaneTableLabelFirstColumn();
        Label secondColumnFirstRow = codeCademyAllCoursesGridPaneTableLabelSecondColumn();
        Label thirdColumnFirstRow = codeCademyAllCoursesGridPaneTableLabelThirdColumn();
        Label fourthColumnFirstRow = codeCademyAllCoursesGridPaneTableLabelFourthColumn();
        
        tablesGrid.add(tableHeaderLabel,1,0);
        tablesGrid.setColumnSpan(tableHeaderLabel, 5);

        tablesGrid.add(firstColumnFirstRow,1,1);
        tablesGrid.add(secondColumnFirstRow,2,1);
        tablesGrid.add(thirdColumnFirstRow,3,1);
        tablesGrid.add(fourthColumnFirstRow,4,1);

        tablesGrid.setStyle("-fx-background-color:#000000");
        tablesGrid.setVgap(20);
        tablesGrid.setHgap(10);

        firstColumnFirstRow.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE  );
        secondColumnFirstRow.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE );
        thirdColumnFirstRow.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE  );
        fourthColumnFirstRow.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE );

        tablesGrid.add(addButton,5,3);
        
        // Then fill in the DATA
        CourseRepo courseRepo = new CourseRepo();
        for (int i = 1; i < courseRepo.get().size() + 1; i++) {

            Label firstColumnSecondRow = codeCademyAllCoursesGridPaneTupelsLabelFirstColumn(courseRepo.get(i));
            Label secondColumnSecondRow = codeCademyAllCoursesGridPaneTupelsLabelSecondColumn(courseRepo.get(i));
            Label thirdColumnSecondRow = codeCademyAllCoursesGridPaneTupelsLabelThirdColumn(courseRepo.get(i));
            Label fourthColumnSecondRow = codeCademyAllCoursesGridPaneTupelsLabelFourthColumn(courseRepo.get(i));

            firstColumnSecondRow.setPadding(new Insets(25,10,25,10));
            secondColumnSecondRow.setPadding(new Insets(25,10,25,10));
            thirdColumnSecondRow.setPadding(new Insets(25,10,25,10));
            fourthColumnSecondRow.setPadding(new Insets(25,10,25,10));

            firstColumnSecondRow.addEventHandler(MouseEvent.MOUSE_CLICKED, CodeCademyAllCoursesLogic.eventHandlerMouseOver(courseRepo.get(i)));

            firstColumnSecondRow.setMaxSize(170,40);
            secondColumnSecondRow.setMaxSize(170,40);
            thirdColumnSecondRow.setMaxSize(170,40);
            fourthColumnSecondRow.setMaxSize(170,40);
            
            tablesGrid.add(firstColumnSecondRow,1,2+i);
            tablesGrid.add(secondColumnSecondRow,2,2+i);
            tablesGrid.add(thirdColumnSecondRow,3,2+i);
            tablesGrid.add(fourthColumnSecondRow,4,2+i);
        }

        return tablesGrid;
    }

    protected static Label codeCademyAllCoursesGridPaneTableLabelCourseCompletion(){
        Label courseCompletionRateLabel = new Label("Course completion rate");
        courseCompletionRateLabel.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(),28));
        courseCompletionRateLabel.setTextFill(Color.web("#FFFFFF", 1.0));
        return courseCompletionRateLabel;
    }

    protected static Label codeCademyAllCoursesGridPaneTableLabelFirstColumn(){
        Label courseCompletionRateLabelFirstColumn = new Label("Course");
        courseCompletionRateLabelFirstColumn.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(),16));
        courseCompletionRateLabelFirstColumn.setTextFill(Color.web("#FFFFFF", 1.0));
        return courseCompletionRateLabelFirstColumn;
    }

    protected static Label codeCademyAllCoursesGridPaneTableLabelSecondColumn(){
        Label courseCompletionRateLabelSecondColumn = new Label("Students");
        courseCompletionRateLabelSecondColumn.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(),16));
        courseCompletionRateLabelSecondColumn.setTextFill(Color.web("#FFFFFF", 1.0));
        return courseCompletionRateLabelSecondColumn;
    }

    protected static Label codeCademyAllCoursesGridPaneTableLabelThirdColumn(){
        Label courseCompletionRateLabelThirdColumn = new Label("Men Completion %");
        courseCompletionRateLabelThirdColumn.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(),16));
        courseCompletionRateLabelThirdColumn.setTextFill(Color.web("#FFFFFF", 1.0));
        return courseCompletionRateLabelThirdColumn;
    }

    protected static Label codeCademyAllCoursesGridPaneTableLabelFourthColumn(){
        Label courseCompletionRateLabelFourthColumn = new Label("Women Completion %");
        courseCompletionRateLabelFourthColumn.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(),16));
        courseCompletionRateLabelFourthColumn.setTextFill(Color.web("#FFFFFF", 1.0));
        return courseCompletionRateLabelFourthColumn;
    }
    //filler data
    protected static Label codeCademyAllCoursesGridPaneTupelsLabelFirstColumn(Course course){
        // Course fill in data
        Label courseCompletionRateLabelFirstColumn = new Label(course.getCourseName());
        courseCompletionRateLabelFirstColumn.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(),14));
        courseCompletionRateLabelFirstColumn.setTextFill(Color.web("#FFFFFF", 1.0));
        courseCompletionRateLabelFirstColumn.setStyle("-fx-background-color:#404040");
        return courseCompletionRateLabelFirstColumn;
    }

    protected static Label codeCademyAllCoursesGridPaneTupelsLabelSecondColumn(Course course){
        CourseRepo courseRepo = new CourseRepo();
        Label courseCompletionRateLabelSecondColumn = new Label( courseRepo.studentsPerCourse( course.getCourseId() ).toString() );
        courseCompletionRateLabelSecondColumn.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(),14));
        courseCompletionRateLabelSecondColumn.setTextFill(Color.web("#FFFFFF", 1.0));
        courseCompletionRateLabelSecondColumn.setStyle("-fx-background-color:#404040");
        return courseCompletionRateLabelSecondColumn;
    }

    protected static Label codeCademyAllCoursesGridPaneTupelsLabelThirdColumn(Course course){
        CertificateRepo certificateRepo = new CertificateRepo();
        
        Label courseCompletionRateLabelThirdColumn = new Label(certificateRepo.completionBasedOnGender(course.getCourseId()).get(0).toString() + "%");
        courseCompletionRateLabelThirdColumn.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(),14));
        courseCompletionRateLabelThirdColumn.setTextFill(Color.web("#FFFFFF", 1.0));
        courseCompletionRateLabelThirdColumn.setStyle("-fx-background-color:#404040");
        return courseCompletionRateLabelThirdColumn;
    }

    protected static Label codeCademyAllCoursesGridPaneTupelsLabelFourthColumn(Course course){
        CertificateRepo certificateRepo = new CertificateRepo();
        Label courseCompletionRateLabelFourthColumn = new Label(certificateRepo.completionBasedOnGender(course.getCourseId() ).get(1).toString() + "%" );
        courseCompletionRateLabelFourthColumn.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(),14));
        courseCompletionRateLabelFourthColumn.setTextFill(Color.web("#FFFFFF", 1.0));
        courseCompletionRateLabelFourthColumn.setStyle("-fx-background-color:#404040");
        return courseCompletionRateLabelFourthColumn;
    }
    // end of filler data
    protected static VBox codeCademyAllCoursesGridPaneTopCoursesVBox(){
        VBox box = new VBox();
        box.getChildren().add(codeCademyAllCoursesGridPaneTopCoursesTables());
        return box;
    }

    protected static GridPane codeCademyAllCoursesGridPaneTopCoursesTables(){
        // Set up table
        GridPane tablesGrid = new GridPane();
        tablesGrid.getColumnConstraints().add(new ColumnConstraints(30));
        tablesGrid.getColumnConstraints().add(new ColumnConstraints(80));
        tablesGrid.getColumnConstraints().add(new ColumnConstraints(200));
        tablesGrid.getColumnConstraints().add(new ColumnConstraints(80));
        tablesGrid.getColumnConstraints().add(new ColumnConstraints(30));

        Label tableHeaderLabel = codeCademyAllCoursesGridPaneTableLabelTopCourses();
        Label firstColumnFirstRow = codeCademyAllCoursesGridPaneTopCoursesFirstColumn();
        Label secondColumnFirstRow = codeCademyAllCoursesGridPaneTopCoursesSecondColumn();
        Label thirdColumnFirstRow = codeCademyAllCoursesGridPaneTopCoursesThirdColumn();

        firstColumnFirstRow.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE  );
        secondColumnFirstRow.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE );
        thirdColumnFirstRow.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE  );

        tablesGrid.setStyle("-fx-background-color:#000000");
        tablesGrid.setVgap(20);
        tablesGrid.setHgap(10);
        tablesGrid.add(tableHeaderLabel,1,0);
        tablesGrid.setColumnSpan(tableHeaderLabel, 5);

        tablesGrid.add(firstColumnFirstRow,1,1);
        tablesGrid.add(secondColumnFirstRow,2,1);
        tablesGrid.add(thirdColumnFirstRow,3,1);

        // Then fill in the DATA
        CourseRepo courseRepo = new CourseRepo();
        for (int i = 1; i < courseRepo.top5Courses().size() + 1; i++) {

            Label firstColumnSecondRow = codeCademyTopCoursesGridPaneTupelsLabelFirstColumn(courseRepo.get(i));
            Label secondColumnSecondRow = codeCademyTopCoursesGridPaneTupelsLabelSecondColumn(courseRepo.get(i));
            Label thirdColumnSecondRow = codeCademyTopCoursesGridPaneTupelsLabelThirdColumn(courseRepo.get(i));
            
            firstColumnSecondRow.setPadding(new Insets(25,10,25,10));
            secondColumnSecondRow.setPadding(new Insets(25,10,25,10));
            thirdColumnSecondRow.setPadding(new Insets(25,10,25,10));

            firstColumnSecondRow.setMaxSize(170,40);
            secondColumnSecondRow.setMaxSize(170,40);
            thirdColumnSecondRow.setMaxSize(170,40);

            tablesGrid.add(firstColumnSecondRow,1,2+i);
            tablesGrid.add(secondColumnSecondRow,2,2+i);
            tablesGrid.add(thirdColumnSecondRow,3,2+i);
     
        }
        return tablesGrid;
    }
    protected static Label codeCademyTopCoursesGridPaneTupelsLabelFirstColumn(Course course){
        // Course fill in data
        Label courseCompletionRateLabelFirstColumn = new Label(course.getCourseId().toString());
        courseCompletionRateLabelFirstColumn.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(),14));
        courseCompletionRateLabelFirstColumn.setTextFill(Color.web("#FFFFFF", 1.0));
        courseCompletionRateLabelFirstColumn.setStyle("-fx-background-color:#404040");
        return courseCompletionRateLabelFirstColumn;
    }

    protected static Label codeCademyTopCoursesGridPaneTupelsLabelSecondColumn(Course course){
        CourseRepo courseRepo = new CourseRepo();
        Label courseCompletionRateLabelSecondColumn = new Label(course.getCourseName());
        courseCompletionRateLabelSecondColumn.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(),14));
        courseCompletionRateLabelSecondColumn.setTextFill(Color.web("#FFFFFF", 1.0));
        courseCompletionRateLabelSecondColumn.setStyle("-fx-background-color:#404040");
        return courseCompletionRateLabelSecondColumn;
    }

    protected static Label codeCademyTopCoursesGridPaneTupelsLabelThirdColumn(Course course){
        CourseRepo courseRepo = new CourseRepo();
        Label courseCompletionRateLabelThirdColumn = new Label( courseRepo.studentsPerCourse( course.getCourseId() ).toString() );
        courseCompletionRateLabelThirdColumn.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(),14));
        courseCompletionRateLabelThirdColumn.setTextFill(Color.web("#FFFFFF", 1.0));
        courseCompletionRateLabelThirdColumn.setStyle("-fx-background-color:#404040");
        return courseCompletionRateLabelThirdColumn;
    }

    protected static Label codeCademyAllCoursesGridPaneTableLabelTopCourses(){
        Label courseCompletionRateLabel = new Label("Top rated courses");
        courseCompletionRateLabel.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(),28));
        courseCompletionRateLabel.setTextFill(Color.web("#FFFFFF", 1.0));
        return courseCompletionRateLabel;
    }

    protected static Label codeCademyAllCoursesGridPaneTopCoursesFirstColumn(){
        Label courseCompletionRateLabelFirstColumn = new Label("Ranking");
        courseCompletionRateLabelFirstColumn.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(),16));
        courseCompletionRateLabelFirstColumn.setTextFill(Color.web("#FFFFFF", 1.0));
        return courseCompletionRateLabelFirstColumn;
    }

    protected static Label codeCademyAllCoursesGridPaneTopCoursesSecondColumn(){
        Label courseCompletionRateLabelSecondColumn = new Label("Course");
        courseCompletionRateLabelSecondColumn.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(),16));
        courseCompletionRateLabelSecondColumn.setTextFill(Color.web("#FFFFFF", 1.0));
        return courseCompletionRateLabelSecondColumn;
    }

    protected static Label codeCademyAllCoursesGridPaneTopCoursesThirdColumn(){
        Label courseCompletionRateLabelThirdColumn = new Label("Students");
        courseCompletionRateLabelThirdColumn.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(),16));
        courseCompletionRateLabelThirdColumn.setTextFill(Color.web("#FFFFFF", 1.0));
        return courseCompletionRateLabelThirdColumn;
    }
    
    protected static VBox codeCademyAllCoursesGridPaneMostCertificatesVBox(){
        VBox box = new VBox();
        box.getChildren().add(codeCademyAllCoursesGridPaneTopCoursesTables());
        return box;
    }

    protected static GridPane codeCademyAllCoursesGridPaneMostCertificatesTables(){
        // set up the table
        GridPane tablesGrid = new GridPane();
        tablesGrid.getColumnConstraints().add(new ColumnConstraints(30));
        tablesGrid.getColumnConstraints().add(new ColumnConstraints(80));
        tablesGrid.getColumnConstraints().add(new ColumnConstraints(200));
        tablesGrid.getColumnConstraints().add(new ColumnConstraints(80));
        tablesGrid.getColumnConstraints().add(new ColumnConstraints(30));

        Label tableHeaderLabel = codeCademyAllCoursesGridPaneTableLabelMostCertificates();
        Label firstColumnFirstRow = codeCademyAllCoursesGridPaneMostCertificatesFirstColumn();
        Label secondColumnFirstRow = codeCademyAllCoursesGridPaneMostCertificatesSecondColumn();
        Label thirdColumnFirstRow = codeCademyAllCoursesGridPaneMostCertificatesThirdColumn();

        firstColumnFirstRow.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE  );
        secondColumnFirstRow.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE );
        thirdColumnFirstRow.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE  );

        tablesGrid.setStyle("-fx-background-color:#000000");
        tablesGrid.setVgap(20);
        tablesGrid.setHgap(10);
        tablesGrid.add(tableHeaderLabel,1,0);
        tablesGrid.setColumnSpan(tableHeaderLabel, 5);

        tablesGrid.add(firstColumnFirstRow,1,1);
        tablesGrid.add(secondColumnFirstRow,2,1);
        tablesGrid.add(thirdColumnFirstRow,3,1);

        // Then fill in the DATA
        CourseRepo courseRepo = new CourseRepo();
        CertificateRepo certificateRepo = new CertificateRepo();
        Iterator iterator = certificateRepo.mostCertificatesGiven().entrySet().iterator();
        int i = 0;
        while (iterator.hasNext()) {
            i++;
            Map.Entry pair = (Map.Entry)iterator.next();
            

            
            Label firstColumnSecondRow = codeCademyMostCertificatesGridPaneTupelsLabelFirstColumn(i);
            Label secondColumnSecondRow = codeCademyMostCertificatesGridPaneTupelsLabelSecondColumn(pair.getKey());
            Label thirdColumnSecondRow = codeCademyMostCertificatesGridPaneTupelsLabelThirdColumn(pair.getValue());
            
            firstColumnSecondRow.setPadding(new Insets(25,10,25,10));
            secondColumnSecondRow.setPadding(new Insets(25,10,25,10));
            thirdColumnSecondRow.setPadding(new Insets(25,10,25,10));

            firstColumnSecondRow.setMaxSize(170,40);
            secondColumnSecondRow.setMaxSize(170,40);
            thirdColumnSecondRow.setMaxSize(170,40);

            tablesGrid.add(firstColumnSecondRow,1,2+i);
            tablesGrid.add(secondColumnSecondRow,2,2+i);
            tablesGrid.add(thirdColumnSecondRow,3,2+i);
        }
           
        
        
        return tablesGrid;
    }

    protected static Label codeCademyMostCertificatesGridPaneTupelsLabelFirstColumn(Integer i){
        // Course fill in data
        Label courseCompletionRateLabelFirstColumn = new Label(i.toString());
        courseCompletionRateLabelFirstColumn.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(),14));
        courseCompletionRateLabelFirstColumn.setTextFill(Color.web("#FFFFFF", 1.0));
        courseCompletionRateLabelFirstColumn.setStyle("-fx-background-color:#404040");
        return courseCompletionRateLabelFirstColumn;
    }

    protected static Label codeCademyMostCertificatesGridPaneTupelsLabelSecondColumn(Object value ){
        CourseRepo courseRepo = new CourseRepo();
        Label courseCompletionRateLabelSecondColumn = new Label(value.toString());
        courseCompletionRateLabelSecondColumn.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(),14));
        courseCompletionRateLabelSecondColumn.setTextFill(Color.web("#FFFFFF", 1.0));
        courseCompletionRateLabelSecondColumn.setStyle("-fx-background-color:#404040");
        return courseCompletionRateLabelSecondColumn;
    }

    protected static Label codeCademyMostCertificatesGridPaneTupelsLabelThirdColumn(Object value){
        CourseRepo courseRepo = new CourseRepo();
        Label courseCompletionRateLabelThirdColumn = new Label(value.toString());
        courseCompletionRateLabelThirdColumn.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(),14));
        courseCompletionRateLabelThirdColumn.setTextFill(Color.web("#FFFFFF", 1.0));
        courseCompletionRateLabelThirdColumn.setStyle("-fx-background-color:#404040");
        return courseCompletionRateLabelThirdColumn;
    }

    protected static Label codeCademyAllCoursesGridPaneTableLabelMostCertificates(){
        Label courseCompletionRateLabel = new Label("Most certificates given out");
        courseCompletionRateLabel.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(),28));
        courseCompletionRateLabel.setTextFill(Color.web("#FFFFFF", 1.0));
        return courseCompletionRateLabel;
    }

    protected static Label codeCademyAllCoursesGridPaneMostCertificatesFirstColumn(){
        Label courseCompletionRateLabelFirstColumn = new Label("Ranking");
        courseCompletionRateLabelFirstColumn.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(),16));
        courseCompletionRateLabelFirstColumn.setTextFill(Color.web("#FFFFFF", 1.0));
        return courseCompletionRateLabelFirstColumn;
    }

    protected static Label codeCademyAllCoursesGridPaneMostCertificatesSecondColumn(){
        Label courseCompletionRateLabelSecondColumn = new Label("Course");
        courseCompletionRateLabelSecondColumn.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(),16));
        courseCompletionRateLabelSecondColumn.setTextFill(Color.web("#FFFFFF", 1.0));
        return courseCompletionRateLabelSecondColumn;
    }

    protected static Label codeCademyAllCoursesGridPaneMostCertificatesThirdColumn(){
        Label courseCompletionRateLabelThirdColumn = new Label("Certificates");
        courseCompletionRateLabelThirdColumn.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(),16));
        courseCompletionRateLabelThirdColumn.setTextFill(Color.web("#FFFFFF", 1.0));
        return courseCompletionRateLabelThirdColumn;
    }

}
