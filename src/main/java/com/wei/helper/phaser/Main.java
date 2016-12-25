package com.wei.helper.phaser;

import java.util.concurrent.Phaser;

/**
 * Created by WEI on 2016/12/25.
 */
public class Main {

    public static void main(String[] args) {
        Phaser phaser = new Phaser(3);
        FileSearch system = new FileSearch("c:\\windows","log",phaser);
        FileSearch apps = new FileSearch("c:\\Program Files","log",phaser);
        FileSearch documents = new FileSearch("C:\\Documents And Setting","log",phaser);

        Thread systemThread = new Thread(system,"System");
        systemThread.start();

        Thread appThread = new Thread(apps,"apps");
        appThread.start();

        Thread documentThread = new Thread(documents,"documents");
        documentThread.start();


        try {
            systemThread.join();
            appThread.join();
            documentThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Terminated:"+phaser.isTerminated());
    }
}
