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

        while (true) {
            System.out.print("명령어:");
            String cmd = sc.nextLine().trim();

            switch (cmd) {
                case "write":
                    boardController.actionWrite();
                    break;
                case "list":
                    boardController.actionList();
                    break;
                case "detail":
                    // detail();
                    break;
                case "update":
                    // update();
                    break;
                case "delete":
                    // delete();
                    break;
                case "exit":
                    System.out.println("프로그램을 종료합니다.");
                    return; // 또는 break; + 루프 밖에 exit 처리
                case "search":
                    break;
                default:
                    System.out.println("알 수 없는 명령어입니다.");
                    break;
            }
        }

    }

}