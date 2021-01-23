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

public class codeCademyAddModuleLogic {
    
    protected static EventHandler<MouseEvent> eventHandlerMouseClickedAddModule(String Version, String Modulename, String ModuleDescription, String ModuleContactName, String ModuleContactEmail) {
        EventHandler<MouseEvent> eventHandlerMouseClick = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                Double v = Double.valueOf(Version);
                Module newModule = new Module(V,10,Modulename,ModuleDescription,ModuleContactEmail);


            }
        };
        return eventHandlerMouseClick;
    }

}
