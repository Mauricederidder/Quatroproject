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

public class codeCademyStudentFollowedCourse {

    protected static Scene codeCademyStudentFollowedCourseSceneBuilder() {
        Scene codeCademyAllCoursesScene = new Scene(codeCademyStudentFollowedCourseLayout());
        return codeCademyAllCoursesScene;
    }

    protected static BorderPane codeCademyStudentFollowedCourseLayout() {
        BorderPane root = new BorderPane();
        root.setMinSize(800, 900);
        root.setTop(codeCademyStudentFollowedCourseGridHeader());
        root.setCenter(codeCademyStudentFollowedCourseCenterLayout());
        return root;
    }

    protected static GridPane codeCademyStudentFollowedCourseGridHeader() {
        GridPane headerGrid = new GridPane();
        Label emptyLabel = new Label();
        headerGrid.setPadding(new Insets(30, 10, 50, 10));
        headerGrid.setHgap(30);
        headerGrid.add(emptyLabel, 0, 1);
        headerGrid.add(codeCademyStudentFollowedCourseSceneHeader(), 0, 2);
        headerGrid.setAlignment(Pos.TOP_CENTER);
        return headerGrid;
    }

    protected static VBox codeCademyStudentFollowedCourseSceneHeader() {
        VBox headerVbox = new VBox();
        headerVbox.getChildren().add(codeCademyStudentFollowedCourseHeaderTitle());
        return headerVbox;
    }

    protected static Label codeCademyStudentFollowedCourseHeaderTitle() {
        Label title = new Label("*Entername* - *ClickedCourse* overzicht");
        title.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(), 40));
        return title;
    }

    protected static FlowPane codeCademyStudentFollowedCourseCenterLayout() {
        FlowPane rootToo = new FlowPane();
        rootToo.setVgap(10);
        rootToo.setHgap(10);
        rootToo.getChildren().add(codeCademyStudentFollowedCourseTables());
        rootToo.setAlignment(Pos.TOP_CENTER);
        return rootToo;
    }

    protected static GridPane codeCademyStudentFollowedCourseTables() {
        GridPane tablesGrid = new GridPane();
        tablesGrid.getColumnConstraints().add(new ColumnConstraints(30));
        tablesGrid.getColumnConstraints().add(new ColumnConstraints(160));
        tablesGrid.getColumnConstraints().add(new ColumnConstraints(170));
        tablesGrid.getColumnConstraints().add(new ColumnConstraints(170));
        Label tableHeaderLabel = codeCademyStudentFollowedCourseHeaderLabel();
        Label FirstColumnFirstRow = codeCademyStudentFollowedCourseFirstColumn();
        Label SecondColumnFirstRow = codeCademyStudentFollowedCourseSecondColumn();
        Label ThirdColumnFirstRow = codeCademyStudentFollowedCourseThirdColumn();
        // start of filler data
        Label FirstColumnSecondRow = codeCademyStudentFollowedCourseFirstColumnSecondRow();
        Label SecondColumnSecondRow = codeCademyStudentFollowedCourseSecondColumnSecondRow();
        Label ThirdColumnSecondRow = codeCademyStudentFollowedCourseThirdColumnSecondRow();
        FirstColumnSecondRow.setPadding(new Insets(15, 10, 15, 10));
        SecondColumnSecondRow.setPadding(new Insets(15, 10, 15, 10));
        ThirdColumnSecondRow.setPadding(new Insets(15, 10, 15, 10));
        // end of filler data
        FirstColumnFirstRow.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        SecondColumnFirstRow.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        ThirdColumnFirstRow.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        // fillerdata
        FirstColumnSecondRow.setMaxSize(170, 40);
        SecondColumnSecondRow.setMaxSize(170, 40);
        ThirdColumnSecondRow.setMaxSize(170, 40);
        // fillerendofdata
        tablesGrid.setStyle("-fx-background-color:#000000");
        tablesGrid.setVgap(20);
        tablesGrid.setHgap(10);
        tablesGrid.add(tableHeaderLabel, 1, 0);
        tablesGrid.setColumnSpan(tableHeaderLabel, 4);
        tablesGrid.add(FirstColumnFirstRow, 1, 1);
        tablesGrid.add(SecondColumnFirstRow, 2, 1);
        tablesGrid.add(ThirdColumnFirstRow, 3, 1);
        // fillerdata
        tablesGrid.add(FirstColumnSecondRow, 1, 2);
        tablesGrid.add(SecondColumnSecondRow, 2, 2);
        tablesGrid.add(ThirdColumnSecondRow, 3, 2);
        // fillerendofdata
        return tablesGrid;
    }

    protected static Label codeCademyStudentFollowedCourseHeaderLabel() {
        Label label = new Label("Modules");
        label.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(), 28));
        label.setTextFill(Color.web("#FFFFFF", 1.0));
        return label;
    }

    protected static Label codeCademyStudentFollowedCourseFirstColumn() {
        Label label = new Label("Module number");
        label.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(), 16));
        label.setTextFill(Color.web("#FFFFFF", 1.0));
        return label;
    }

    protected static Label codeCademyStudentFollowedCourseSecondColumn() {
        Label label = new Label("Module name");
        label.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(), 16));
        label.setTextFill(Color.web("#FFFFFF", 1.0));
        return label;
    }

    protected static Label codeCademyStudentFollowedCourseThirdColumn() {
        Label label = new Label("Module progress");
        label.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(), 16));
        label.setTextFill(Color.web("#FFFFFF", 1.0));
        return label;
    }

    // start of filler data
    protected static Label codeCademyStudentFollowedCourseFirstColumnSecondRow() {
        Label label = new Label("Module number");
        label.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(), 16));
        label.setTextFill(Color.web("#FFFFFF", 1.0));
        label.setStyle("-fx-background-color:#404040");
        return label;
    }

    protected static Label codeCademyStudentFollowedCourseSecondColumnSecondRow() {
        Label label = new Label("Module name");
        label.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(), 16));
        label.setTextFill(Color.web("#FFFFFF", 1.0));
        label.setStyle("-fx-background-color:#404040");
        return label;
    }

    protected static Label codeCademyStudentFollowedCourseThirdColumnSecondRow() {
        Label label = new Label("Module progress");
        label.setFont(Font.loadFont(CodeCademyStage.class.getResource("Montserrat-Bold.ttf").toExternalForm(), 16));
        label.setTextFill(Color.web("#FFFFFF", 1.0));
        label.setStyle("-fx-background-color:#404040");
        return label;
    }

}
