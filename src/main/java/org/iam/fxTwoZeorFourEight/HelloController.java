package org.iam.fxTwoZeorFourEight;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    public Button startGame;
    @FXML
    public Button exit;
    @FXML
    private Label welcomeText;

    @FXML
    public void onExitClicked(ActionEvent actionEvent) {
        System.exit(0);
    }

    @FXML
    public void onStartGameClicked(ActionEvent actionEvent) throws IOException {
        tools.getInstance().changeScene((Stage) variableCenter.get("stage"), this.getClass().getResource("Game.xml"), "FX2048-Gaming", 320, 200);
    }
}