package org.iam.fxTwoZeorFourEight;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

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