package ui;

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

    protected static Scene CodeCademyClickedCourseStatisticsSceneBuilder() {
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
        rootToo.getChildren().add(codeCademyClickedCourseStatisticsBestMatchingCourseVbox());
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
        Label title = new Label("Course - entercoursename");
        title.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(), 36));
        return title;
    }

    protected static Label codeCademyClickedCourseStatisticsAmountOfPeopleLabel() {
        Label amountOfPeopleLabel = new Label("Beehaald door: 3482 cursisten");
        amountOfPeopleLabel.setFont(
                Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Regular.ttf").toExternalForm(), 22));
        return amountOfPeopleLabel;
    }

    protected static VBox codeCademyClickedCourseStatisticsBestMatchingCourseVbox() {
        VBox matchingCourseVbox = new VBox();
        matchingCourseVbox.getChildren().add(codeCademyClickedCourseStatisticsBestMatchingCourseGridPane());

        return matchingCourseVbox;
    }

    protected static GridPane codeCademyClickedCourseStatisticsBestMatchingCourseGridPane() {
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
        //fillerdata
        Label FirstColumnSecondRow = codeCademyClickedCourseStatisticsAmountofPeopleDummyDataOne();
        Label SecondColumnSecondRow = codeCademyClickedCourseStatisticsAmountofPeopleDummyDataTwo();
        Label ThirdColumnSecondRow = codeCademyClickedCourseStatisticsAmountofPeopleDummyDataThree();
        Label FourthColumnSecondRow = codeCademyClickedCourseStatisticsAmountofPeopleDummyDataFour();
        FirstColumnSecondRow.setPadding(new Insets(25, 10, 25, 10));
        SecondColumnSecondRow.setPadding(new Insets(25, 10, 25, 10));
        ThirdColumnSecondRow.setPadding(new Insets(25, 10, 25, 10));
        FourthColumnSecondRow.setPadding(new Insets(25, 10, 25, 10));
        //fillerendofdata
        FirstColumnFirstRow.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        SecondColumnFirstRow.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        ThirdColumnFirstRow.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        FourthColumnFirstRow.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        //fillerdata
        FirstColumnSecondRow.setMaxSize(170, 40);
        SecondColumnSecondRow.setMaxSize(170, 40);
        ThirdColumnSecondRow.setMaxSize(170, 40);
        FourthColumnSecondRow.setMaxSize(170, 40);
        //fillerendofdata
        matchingCourse.setStyle("-fx-background-color:#000000");
        matchingCourse.setVgap(20);
        matchingCourse.setHgap(10);
        matchingCourse.add(tableHeaderLabel, 0, 1);
        matchingCourse.setColumnSpan(tableHeaderLabel, 4);
        matchingCourse.add(FirstColumnFirstRow, 0, 2);
        matchingCourse.add(SecondColumnFirstRow, 1, 2);
        matchingCourse.add(ThirdColumnFirstRow, 2, 2);
        matchingCourse.add(FourthColumnFirstRow, 3, 2);
        //fillerdata
        matchingCourse.add(FirstColumnSecondRow, 0, 3);
        matchingCourse.add(SecondColumnSecondRow, 1, 3);
        matchingCourse.add(ThirdColumnSecondRow, 2, 3);
        matchingCourse.add(FourthColumnSecondRow, 3, 3);
        //fillerendofdata
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
    protected static Label codeCademyClickedCourseStatisticsAmountofPeopleDummyDataOne() {
        Label label = new Label("1");
        label.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Regular.ttf").toExternalForm(), 14));
        label.setTextFill(Color.web("#FFFFFF", 1.0));
        label.setStyle("-fx-background-color:#404040");
        return label;
    }
    protected static Label codeCademyClickedCourseStatisticsAmountofPeopleDummyDataTwo() {
        Label label = new Label("Html for beginners");
        label.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Regular.ttf").toExternalForm(), 14));
        label.setTextFill(Color.web("#FFFFFF", 1.0));
        label.setStyle("-fx-background-color:#404040");
        return label;
    }
    protected static Label codeCademyClickedCourseStatisticsAmountofPeopleDummyDataThree() {
        Label label = new Label("352");
        label.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Regular.ttf").toExternalForm(), 14));
        label.setTextFill(Color.web("#FFFFFF", 1.0));
        label.setStyle("-fx-background-color:#404040");
        return label;
    }
    protected static Label codeCademyClickedCourseStatisticsAmountofPeopleDummyDataFour() {
        Label label = new Label("Html,Beginner");
        label.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Regular.ttf").toExternalForm(), 14));
        label.setTextFill(Color.web("#FFFFFF", 1.0));
        label.setStyle("-fx-background-color:#404040");
        return label;
    }
    // end of filler data

}
