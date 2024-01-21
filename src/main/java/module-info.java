module org.iam.fxTwoZeorFourEight {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.iam.fxTwoZeorFourEight to javafx.fxml;
    exports org.iam.fxTwoZeorFourEight;
}