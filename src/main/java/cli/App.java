package cli;

import cli.board.controller.BoardController;
import cli.system.controller.SystemController;
import cli.util.InputParser;

import java.util.Scanner;

public class App {
    private final Scanner sc;

    public App() {
        this.sc = AppContext.sc;
    }

    void run() {
        SystemController systemController = AppContext.systemController;
        BoardController boardController = AppContext.boardController;

        System.out.println("== 게시판 앱 ==");


        while (true) {
            System.out.print("명령어: ");
            String input = sc.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("명령어를 입력해주세요.");
                continue;
            }

            String[] tokens = input.split("\\s+");
            String cmd = tokens[0];

            switch (cmd) {
                case "write":
                    boardController.actionWrite();
                    break;
                case "list":
                    boardController.actionList();
                    break;
                case "detail":
                    Integer detailId = InputParser.parseId(tokens);
                    if (detailId != null) {
                        boardController.actionDetail(detailId);
                    }
                    break;
                case "update":
                   Integer updateId = InputParser.parseId(tokens);
                    if (updateId != null) {
                        boardController.actionUpdate(updateId);
                    }
                    break;
                case "delete":
                    Integer deleteId = InputParser.parseId(tokens);
                    if (deleteId != null) {
                        boardController.actionDelete(deleteId);
                    }
                    break;
                case "exit":
                    systemController.actionExit();
                    return;
                case "search":
                    InputParser.handleSearch(input, boardController);
                    break;
                default:
                    System.out.println("알 수 없는 명령어입니다.");
                    break;
            }
        }
    }


}