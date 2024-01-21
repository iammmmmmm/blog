package org.iam.fxTwoZeorFourEight;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

/**
 * @author Iammm
 * @Time 2024/1/21 11:28
 */
public class Game {
    int oldX = 0;
    int oldY = 0;
    gameIml gm;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;
    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;
    @FXML // fx:id="canvas"
    private GridPane canvas; // Value injected by FXMLLoader

    @FXML
    void canvasKeyPress(KeyEvent event) {
        System.out.println("test pre");
        switch (event.getCode()) {
            case UP, W -> gm.up();
            case DOWN, S -> gm.down();
            case LEFT, A -> gm.left();
            case RIGHT, D -> gm.right();
        }
        reprint();
    }

    @FXML
    void canvasMouseDragged(MouseEvent event) {
        System.out.println("test dra");
        var x = (int) event.getX();
        var y = (int) event.getY();
        if (x > oldX) {
            // move right
            gm.right();
        } else if (x < oldX) {
            // move left
            gm.left();
        }
        if (y > oldY) {
            // move down
            gm.down();
        } else if (y < oldY) {
            // move up
            gm.up();
        }
        oldX = x;
        oldY = y;
        reprint();
    }


    private void reprint() {

    }

    void print() {
        var a= gameIml.getGameCanvas();
        for (int row = 0; row < a.length; row++) {
            for (int c = 0; c < a[0].length; c++) {
                var button=new Button(a[row][c]+"");
                button.setPrefSize(50, 50);
                button.setAlignment(Pos.CENTER);
                canvas.add(button, c, row);
            }
        }
        canvas.autosize();
    }

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert canvas != null : "fx:id=\"canvas\" was not injected: check your FXML file 'Game.fxml'.";
        this.gm = gameIml.getInstance();

// 创建列约束
        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setPercentWidth(50);
        columnConstraints.setFillWidth(true);

// 创建行约束
        RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setPercentHeight(50);
        rowConstraints.setFillHeight(true);

// 将约束添加到GridPane
        canvas.getColumnConstraints().add(columnConstraints);
        canvas.getRowConstraints().add(rowConstraints);

        canvas.setGridLinesVisible(true);

        canvas.setMinSize(400, 400);
        canvas.setPrefSize(400, 400);

        canvas.setVgap(5);
        canvas.setHgap(5);

        print();
    }

}

// TODO 实现游戏逻辑
class gameIml {

    private static final int size = 4;
    private static final gameIml gameIml = new gameIml(size);
    private static int[][] gameCanvas;

    private gameIml(int size) {
        // 初始化数组
        gameCanvas = new int[gameIml.size][size];
        Arrays.stream(gameCanvas).forEach(a -> Arrays.fill(a, 0));
    }

    public static int[][] getGameCanvas() {
        return gameCanvas;
    }

    public static gameIml getInstance() {
        return gameIml;
    }

    void up() {

    }

    void down() {

    }

    void left() {

    }

    void right() {

    }

    void addRandom() {

    }

    void checkGameOver() {

    }

}