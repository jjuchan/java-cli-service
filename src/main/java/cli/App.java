package cli;

import cli.board.controller.BoardController;
import cli.system.controller.SystemController;

import java.util.Scanner;
import java.util.StringTokenizer;

public class App {
    private final Scanner sc;

    public App() {
        this.sc = AppContext.sc;
    }

    void run() {
        SystemController systemController = AppContext.systemController;
        BoardController boardController = new BoardController();

        System.out.println("== 게시판 앱 ==");


        while (true) {
            System.out.print("명령어: ");
            String input = sc.nextLine().trim();

            StringTokenizer st = new StringTokenizer(input);
            if (!st.hasMoreTokens()) {
                System.out.println("명령어를 입력해주세요.");
                continue;
            }

            String cmd = st.nextToken();

            switch (cmd) {
                case "write":
                    boardController.actionWrite();
                    break;
                case "list":
                    boardController.actionList();
                    break;
                case "detail":
                    if (st.hasMoreTokens()) {
                        try {
                            int boardId = Integer.parseInt(st.nextToken());
                            boardController.actionDetail(boardId);
                        } catch (NumberFormatException e) {
                            System.out.println("올바른 게시글 번호를 입력하세요.");
                        }
                    } else {
                        System.out.println("게시글 ID를 입력해주세요.");
                    }
                    break;
                case "update":
                    // update();
                    break;
                case "delete":
                    // delete();
                    break;
                case "exit":
                    systemController.actionExit();
                    return;
                case "search":
                    // search();
                    break;
                default:
                    System.out.println("알 수 없는 명령어입니다.");
                    break;
            }
        }
    }


}