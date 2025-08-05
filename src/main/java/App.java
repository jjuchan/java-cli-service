import board.controller.BoardController;
import util.AppContext;

import java.util.Scanner;

public class App {
    private final Scanner sc;

    public App(AppContext appContext) {
        this.sc = appContext.getScanner();
    }

    void run() {
        BoardController boardController = new BoardController(new AppContext());

        System.out.print("명령어:");
        String cmd = sc.nextLine().trim();

        while (true) {
            if(cmd.equals("write")) {
                boardController.actionWrite();
            } else if(cmd.equals("list")) {
                boardController.actionList();
            } else if(cmd.equals("detail")) { //조회수 증가
                // detail();
            } else if(cmd.equals("update")) {
                // update();
            } else if(cmd.equals("delete")) {
                // delete();
            } else if(cmd.equals("exit")) {
                // exit();
            } else if(cmd.equals("search")) {
                // search();
            } else {
                System.out.println("알 수 없는 명령어입니다.");
            }

        }




    }



}