package org.iam.fxTwoZeorFourEight;

/**
 * ai 写的，垃圾玩意慢的一批还有致命错误
 * @author new bing
 *
 * @Time 2024/1/21 15:20
 */
import java.util.Random;
import java.util.Scanner;

public class command2048 {
    private static int[][] board = new int[4][4];
    private static Random random = new Random();

    public static void main(String[] args) {
        // 初始化游戏/棋盘状态
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                board[i][j] = 0;
            }
        }

        // 添加一个随机数
        addRandomNumber();
        addRandomNumber();

        // 画出棋盘的当前状态
        drawBoard();

        // 游戏主循环
        while (true) {
            // 读取用户输入，进行移动
            System.out.println("请输入操作（w/s/a/d）：");
            char operation = new Scanner(System.in).next().charAt(0);
            if (operation == 'w') {
                // 向上移动
                moveUp();
            } else if (operation == 's') {
                // 向下移动
                moveDown();
            } else if (operation == 'a') {
                // 向左移动
                moveLeft();
            } else if (operation == 'd') {
                // 向右移动
                moveRight();
            }

            // 添加一个随机数
            addRandomNumber();

            // 画出棋盘的当前状态
            drawBoard();
        }
    }

    // 在空位置随机添加一个2或者4
    private static void addRandomNumber() {
        // 随机一个空位置（i，j）
        int i, j;
        do {
            i = random.nextInt(4);
            j = random.nextInt(4);
        } while (board[i][j] != 0);

        // 生成2或者4
        board[i][j] = (random.nextInt(2) + 1) * 2;
    }

    // 画出当前棋盘状态
    private static void drawBoard() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println("\n");
        }
    }

    // 向上移动
    // 向上移动
    private static void moveUp() {
        for (int j = 0; j < 4; j++) {
            int lastNonZeroFound = -1;
            for (int i = 0; i < 4; i++) {
                if (board[i][j] != 0) {
                    if (lastNonZeroFound != -1 && board[lastNonZeroFound][j] == board[i][j]) {
                        // 合并两个相同的数字
                        board[lastNonZeroFound][j] *= 2;
                        board[i][j] = 0;
                        lastNonZeroFound = -1;
                    } else if (lastNonZeroFound + 1 != i) {
                        // 移动数字
                        board[lastNonZeroFound + 1][j] = board[i][j];
                        board[i][j] = 0;
                        lastNonZeroFound++;
                    } else {
                        lastNonZeroFound = i;
                    }
                }
            }
        }
    }


    // 向下移动
    // 向下移动
    private static void moveDown() {
        for (int j = 0; j < 4; j++) {
            int lastNonZeroFound = -1;
            for (int i = 3; i >= 0; i--) {
                if (board[i][j] != 0) {
                    if (lastNonZeroFound != -1 && board[lastNonZeroFound][j] == board[i][j]) {
                        board[lastNonZeroFound][j] *= 2;
                        board[i][j] = 0;
                        lastNonZeroFound = -1;
                    } else if (lastNonZeroFound - 1 != i) {
                        board[lastNonZeroFound - 1][j] = board[i][j];
                        board[i][j] = 0;
                        lastNonZeroFound--;
                    } else {
                        lastNonZeroFound = i;
                    }
                }
            }
        }
    }

    // 向左移动
    private static void moveLeft() {
        for (int i = 0; i < 4; i++) {
            int lastNonZeroFound = -1;
            for (int j = 0; j < 4; j++) {
                if (board[i][j] != 0) {
                    if (lastNonZeroFound != -1 && board[i][lastNonZeroFound] == board[i][j]) {
                        board[i][lastNonZeroFound] *= 2;
                        board[i][j] = 0;
                        lastNonZeroFound = -1;
                    } else if (lastNonZeroFound + 1 != j) {
                        board[i][lastNonZeroFound + 1] = board[i][j];
                        board[i][j] = 0;
                        lastNonZeroFound++;
                    } else {
                        lastNonZeroFound = j;
                    }
                }
            }
        }
    }

    // 向右移动
    private static void moveRight() {
        for (int i = 0; i < 4; i++) {
            int lastNonZeroFound = -1;
            for (int j = 3; j >= 0; j--) {
                if (board[i][j] != 0) {
                    if (lastNonZeroFound != -1 && board[i][lastNonZeroFound] == board[i][j]) {
                        board[i][lastNonZeroFound] *= 2;
                        board[i][j] = 0;
                        lastNonZeroFound = -1;
                    } else if (lastNonZeroFound - 1 != j) {
                        board[i][lastNonZeroFound - 1] = board[i][j];
                        board[i][j] = 0;
                        lastNonZeroFound--;
                    } else {
                        lastNonZeroFound = j;
                    }
                }
            }
        }
    }
}
