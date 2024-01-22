package org.iam.fxTwoZeorFourEight;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.Arrays;
import java.util.Random;
import java.util.ResourceBundle;

/**
 * @author Iammm
 * @Time 2024/1/21 11:28
 */
public class Game {
    public AnchorPane archPane;
    int oldX = 0;
    int oldY = 0;
    gameIml gm;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;
    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;
    @FXML // fx:id="canvas"
    private GridPane canvas; // Value injected by FXMLLoader

    //这个似乎并不起效
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
        var a = gameIml.getGameCanvas();
        for (int row = 0; row < a.length; row++) {
            for (int c = 0; c < a[0].length; c++) {

                canvas.add(new cellPane(a[row][c]), c, row);
            }
        }
        canvas.autosize();
    }

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert canvas != null : "fx:id=\"canvas\" was not injected: check your FXML file 'Game.fxml'.";
        this.gm = gameIml.getInstance();

        print();
    }

}

// TODO 实现游戏逻辑
//我不想实现了，烂尾.jpg
class gameIml {

    private static final int size = 4;
    private static final gameIml gameIml = new gameIml(size);
    private static final Random random = new Random();
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

        checkGameOver();
    }

    void down() {

        checkGameOver();
    }

    void left() {

        checkGameOver();
    }

    void right() {


        checkGameOver();
    }

    boolean addRandom() {
        if (gameCanvas[random.nextInt(size)][random.nextInt(size)] == 0)
            gameCanvas[random.nextInt(size)][random.nextInt(size)] = random.nextInt(2) == 1 ? 4 : 2;

        else return false;
        return true;
    }

    void checkGameOver() {
        for (int i = 0; i < size; i++) {
            for (int i1 = 0; i1 < size; i1++) {
                var temp=gameCanvas[i][i1];
                if ( temp== 0){
                    return;
                }else {
                        return;
                    }
            }

        }
    }

    private void gameOver() {
        System.out.println("Game Over");
        System.exit(0);
    }

}

class cellPane extends Pane {

    public cellPane(int i) {
        Rectangle rectangle = new Rectangle(100, 100);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.BLACK);
        rectangle.setStrokeWidth(1);
        getChildren().add(rectangle);
        Label label = new Label(select(i));

        label.setFont(Font.font(40));
        label.setLayoutX(30);
        label.setLayoutY(30);
        getChildren().add(label);
    }

    private String select(int i) {
        return i == 0 ?
                "" : String.valueOf(i);
    }

}
