---
title: JavaFx 常见问题总结
date: 2024.07.29
tags: 
 - JavaFx
categories:
 - dev
---
# JavaFx 常见问题总结
由我问我我我整理

访问短链：
https://reurl.cc/EjXA3g


部分内容可能有误，还请指出。

注意！本文出现的所有J8均指代jdk8，请勿过度分析

1. 如何解决：错误: 缺少 JavaFX 运行时组件, 需要使用该组件来运行此应用程序
   1) 参见6.a.i
   1) 使用Idea的javafx插件新建javafx项目
   1) 使用j8（万物始于j8）
   1) ~~你不会百度一下？你不会bing一下？你不会谷歌一下？你不会gpt一下？~~
   3) j11及以上的也可以通过使用modelinfo.java（具体咋用见附）来解决此问题
2. 如何在国产arm linux或非国产armlinux上使用jfx（等价于问题1在arm linux出现如何解决）
   1) 使用zulujdk 8（推荐）
   2) 通过包管理器安装jfx sdk（有一定难度）
   3) 可以在开发时选择graalvm jdk ，在发布时选择本地镜像打包（使用配置完善的目标平台进软件行构建），这样用户就不需要关心问题1和本问题了。（参阅问题12）
3. 如何打包JavaFx程序为可执行程序
   1) 参考[JavaFX项目构建为可执行文件 | reine's blo(reineishyanami.github.io)](https://reine-ishyanami.github.io/article/blogs/java/javafxPackage.html)
4. Spring能集成JavaFx 吗？
   1) 参考[SpringBoot整合JavaFX | reine's blog (reine-ishyanami.github.io)](https://reine-ishyanami.github.io/article/blogs/java/javafxSpringboot.html)
   1) 你还可以尝试自己动手丰衣足食。
   1) ~~丫离了Spring就不会写Java了？~~
5. 依赖下载太慢了怎么办？
   1) 换源
      1. Maven参考: [Maven 仓库 | 菜鸟教程 (runoob.com)](https://www.runoob.com/maven/maven-repositories.html)
      1. Gradle 参考：同上，参见文末附。
   1) 向群友求助，群友可以给你jar，你安装进本地maven仓库
   1) ~~魔法，向霍格沃兹递交魔法使用申请~~
6. 我不会写JavaFx咋办
   1) 学
      1. 安装教程：[JavaFX 入门 (openjfx.io)](https://openjfx.io/openjfx-docs/#install-javafx) 
      1. 甲骨文教程：[JavaFX：JavaFX 发行版 8 入门 - 目录 (oracle.com)](https://docs.oracle.com/javase/8/javafx/get-started-tutorial/index.html) j8生万物（javafx没有太大的更新，不用担心过时问题。）
      1. OpenJFx文档教程：[JavaFX 文档项目 (fxdocs.github.io)](https://fxdocs.github.io/docs/html5/) （我没看过，我不做评价）

    1. 国外博客教程：
      1. [JavaFX Tutorial (jenkov.com)](https://jenkov.com/tutorials/javafx/index.html) 简短，需要较强的java基础
      2. [一个完全基于javafx的安卓，windows，ios游戏开发教程](https://foojay.io/?s=Wordish)非常推荐！
    1. 国内博客推荐：
        1. https://github.com/reine-ishyanami/article
     1. 油管视频教程：
      1. https://www.youtube.com/@AlmasB0 Almas Baimagambetov大佬的号，有很多优质教程。（这家伙还是大学教授，fxgl的仓库所有者。天顶星级别人物）
      1. [JavaFX Software - YouTube](https://www.youtube.com/playlist?list=PL4h6ypqTi3RR_bhBk6PtLfD83YkaJXXxw) （我没看过，不做评价）
     1. B站视频教程：
      1. <https://www.bilibili.com/video/BV1Qf4y1F7Zv> 较为简短，内容不是很全面
     1. <https://www.bilibili.com/video/BV1Mr4y1C7pn> 较为简短，内容比较实战需要基础，废话有点，这个up也更新FXGL（fx的2d和3d游戏引擎）教程
     1. <https://www.bilibili.com/video/BV1fW41167RP> 内容全面，啥都讲了，只需java基础即可，~~废话大王~~
    
     ~~使用红红的票票（￥￥￥人民币），让*连屁股都可以卖的*群友写~~
   
7. JavaFx能打包成安卓应用吗？
   1) 能，请参考其官方网站的教程：https://docs.gluonhq.com/
   2) 甚至打包成web也可以！
   3) [一个完全基于javafx的安卓，windows，ios简单游戏开发教程](https://foojay.io/?s=Wordish)非常推荐！
8. JavaFX可以可视化编辑页面吗
   1) 可以，使用scenebuilder+fxml
   2) 教程（在最后几集）：https://www.bilibili.com/video/BV1Mr4y1C7pn
9. Scenebuilder有汉化吗？
   1) ~~就几个单词还记不住了？那你学个j8~~
   1) 可以自己动手丰衣足食
   2) https://pan.baidu.com/s/11pWBZ3uQSRZbuMS8POkLCw?pwd=2ke5  csdn（部分）汉化的8.5版本，来自csdn 

10. 无法从官网（gloun.com）下载javafx sdk
   1) 使用魔法
   1) 向群友求助(群号在末尾）
   1) 使用zulu jdk （https://www.azul.com/downloads/?package=jdk#zulu）
   1) 使用j8
   1) 使用其他的带有jfx的jdk
11. Java FX Packager: Can't build artifact - fx:deploy is not available in this JDK
   1) 此问题是因为使用了jdk 11+引起的，懒得折腾就用j8.
   1) 具体解决办法和原因参考以下链接：
      i. https://github.com/openjfx/openjfx-docs/issues/90  
      ii. https://stackoverflow.com/questions/54806788/javafx-cant-build-artifact-fxdeploy-is-not-available-in-this-jdk

12. java fx 如何进行本地构建（即如何graalvm打包,生成可执行程序）
   1) 参考： https://docs.gluonhq.com/
   2) 参考： https://github.com/reine-ishyanami/article （优质java博客，搜一下打包就能找到）
13. javafx在部分linux下无法正常输入中文
   1) 添加启动参数 -Djdk.gtk.version=2
   2) 尝试去openjdk仓库提pr（自己动手，丰衣足食，大家会感谢你的ヾ(@^▽^@)ノ （看好你靓仔/靓女）https://bugs.openjdk.org/browse/JDK-8286831
   3) 升级到23试试，有大佬在uos下测试没问题
   4)  ~~（土豪专享）去给gluon氪金，让它修好。~~
    
目前只整理了这些，并不全面，恳请补充，如有问题还请指出！

附：
qq群：577791499 ，提问必回前提是别像个傻子一样提问（可以看本仓库里的提问教程），那样只能被嘲笑和无视（虽然但是还是会回答你的(谁让群友那么好呢？)）

推荐阅读：
https://foojay.io/ 

一个介绍JavaFX第三方组件等内容的帖子，值得一看
https://www.ljjyy.com/archives/2019/08/100573.html#Libraries-Tools-and-Projects%EF%BC%88%E7%B1%BB%E5%BA%93%EF%BC%8C%E5%B7%A5%E5%85%B7%E5%92%8C%E9%A1%B9%E7%9B%AE%EF%BC%89

modeinfo.java示例：
```java
     module your.module.name {
    // 导出模块中的包给其他模块使用
    exports com.example.yourpackage;
    
    // 打开给FXML文件的访问权限，如果没有这句则无法使用fxml
    opens com.example.yourpackage to javafx.fxml;
    
    // 使用JavaFX模块
    requires javafx.controls;
    requires javafx.fxml;
    }
````
