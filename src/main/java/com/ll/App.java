package com.ll;

import com.ll.domain.system.controller.SystemController;
import com.ll.global.rq.Rq;

import java.util.Scanner;

public class App {
    private final Scanner scanner;

    public App() {
        this.scanner = AppContext.scanner;
    }

    public void run(){
        SystemController systemController = AppContext.systemController;


        while (true) {
            System.out.print("명령어: ");
            String cmd = scanner.nextLine();
            Rq rq = new Rq(cmd);

            switch (rq.getActionName()) {
                case "exit" -> {
                    systemController.actionExit();
                    return;
                }
            }
        }

    }
}
