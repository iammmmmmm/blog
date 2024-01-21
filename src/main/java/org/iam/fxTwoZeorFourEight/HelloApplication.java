package org.iam.fxTwoZeorFourEight;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        tools.getInstance().changeScene(stage,this.getClass().getResource("hello-view.fxml"),"FX2048",320,200);
        //交易变量
        variableCenter.put("stage",stage);
    }

    public static void main(String[] args) {
        launch();
    }
}