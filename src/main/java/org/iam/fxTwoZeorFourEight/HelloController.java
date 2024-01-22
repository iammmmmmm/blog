package org.iam.fxTwoZeorFourEight;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    public Button startGame;
    @FXML
    public Button exit;

    @FXML
    public void onExitClicked() {
        System.exit(0);
    }

    @FXML
    public void onStartGameClicked() throws IOException {
        tools.getInstance().changeScene((Stage) variableCenter.get("stage"), this.getClass().getResource("Game.fxml"), "FX2048-Gaming", 520, 430);
    }
}