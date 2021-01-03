package ui;
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


public class CodeCademyLandingSceneLogic {
    
    protected static Label headerLabel() {
        Label headerText = new Label("Codecademy");
        headerText.setFont(Font.font("Arial", 30));
        return headerText;
    }
    
    protected static Text informationText() {
        Text informationText = new Text();
        informationText.setText(
                "orem ipsum dolor sit amet, consectetur adipiscing elit.\n Vivamus id suscipit eros.\n Fusce felis est, ultrices quis leo eget, aliquam lobortis ipsum.\n Etiam laoreet nisl nec metus lobortis, in convallis felis viverra.\n Vestibulum fermentum dictum posuere.");
        informationText.setFont(Font.font("Arial", 15));
        return informationText;
    }

    protected static Button regularButton() {
        Button standardButton = new Button();
        standardButton.setStyle("-fx-border-width:1px; -fx-border-color:#18ab29; -fx-background-color:#44c767;-fx-font-size:17px;");
        standardButton.addEventFilter(MouseEvent.MOUSE_ENTERED, eventHandlerMouseOver(standardButton));
        standardButton.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerMouseClick(standardButton));
        standardButton.addEventFilter(MouseEvent.MOUSE_EXITED, eventHandlerMouseOut(standardButton));
        standardButton.setAlignment(Pos.CENTER);
        standardButton.setMinHeight(30);
        standardButton.setMinWidth(70);
        return standardButton;
    }

    // Returns an EventHandler so the button goes to a different color when hovering.
    protected static EventHandler<MouseEvent> eventHandlerMouseOver(Button standardButton) {
        EventHandler<MouseEvent> eventHandlerMouseOver = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                standardButton.setStyle(
                        "-fx-border-width:1px; -fx-border-color:#18ab29; -fx-background-color:#5cbf2a;-fx-font-size:17px;");
            }
        };
        return eventHandlerMouseOver;
    }

    // Returns an EventHandler so the button reverts to the original button style.
    protected static EventHandler<MouseEvent> eventHandlerMouseOut(Button standardButton) {
        EventHandler<MouseEvent> eventHandlerMouseOut = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                standardButton.setStyle(
                        "-fx-border-width:1px; -fx-border-color:#18ab29; -fx-background-color:#44c767;-fx-font-size:17px;");
                standardButton.setEffect(null);
            }
        };
        return eventHandlerMouseOut;
    }

    // Returns an EventHandler so the button goes to a different color when clicking
    // and also gives it a shadow effect.
    protected static EventHandler<MouseEvent> eventHandlerMouseClick(Button standardButton) {
        EventHandler<MouseEvent> eventHandlerMouseClick = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                standardButton.setStyle(
                        "-fx-border-width:1px; -fx-border-color:#18ab29; -fx-background-color:#5cbf2a;-fx-font-size:17px;");
                standardButton.setEffect(new DropShadow());
                CodeCademyStage.getStage().setScene(OverviewPersonScene.overviewPersonScene());;
            }
        };
        return eventHandlerMouseClick;
    }

    // if you need to add fillerpanes for the GridPane
    protected static Pane fillerPane() {
        Pane fillerPane = new Pane();
        fillerPane.setMinHeight(10);
        fillerPane.setMinWidth(10);
        return fillerPane;
    }
}
