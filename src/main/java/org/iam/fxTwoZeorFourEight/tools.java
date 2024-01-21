package org.iam.fxTwoZeorFourEight;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 把部分复制重复的代码在此类中实现，通过调用此类的实现来避免写一堆重复的代码
 * <p>
 *  通过单例模式实现
 * @author Iammm
 * @Time 2024/1/21 11:30
 */
public class tools {
    //获取用户系统语言
    private static final String LANG = System.getProperty("user.language");
    //设置支持的语言列表
    private static final String[] LANGS= new String[]{"en", "zh"};
    private  static tools instance;
    private tools(){}

    /**
     * 获取实例
     *
     * @return {@link tools}
     */
    public static tools getInstance(){
        if (instance==null){
            instance=new tools();
        }
        return  instance;
    }

    /**
     * 改变场景
     *
     * @param stage  窗口对象
     * @param fxml   FXML路径
     * @param Title  标题
     * @param width  宽度
     * @param height 高度
     * @throws IOException ioexception读取fxml可能引发的错误
     */
    public void changeScene(Stage stage, URL fxml,String Title,int width,int height) throws IOException {
        //获取语言
        System.out.println("LANG = " + LANG);
        Locale locale = null;
        //判断语言是否支持
        if (Arrays.stream(LANGS).anyMatch(LANG::equalsIgnoreCase)) {
            locale = new Locale(LANG);
        } else {
            locale = new Locale("en");
        }
        ResourceBundle bundle = ResourceBundle.getBundle("org/iam/fxTwoZeorFourEight/FX2048", locale);

        FXMLLoader fxmlLoader = new FXMLLoader(fxml);

        //设置资源包
        fxmlLoader.setResources(bundle);

        //加载fxml
        Scene scene = new Scene(fxmlLoader.load(), width, height);
        stage.setTitle(Title);
        stage.setScene(scene);
        stage.show();
    }
}
