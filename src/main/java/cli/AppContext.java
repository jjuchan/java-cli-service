package cli;

import cli.board.controller.BoardController;
import cli.board.repository.BoardRepository;
import cli.board.service.BoardService;
import cli.system.controller.SystemController;

import java.util.Scanner;

public class AppContext {
    public static Scanner sc;
    public static SystemController systemController;
    public static BoardController boardController;
    public static BoardService boardService;
    public static BoardRepository boardRepository;


    public static void renew(Scanner _sc) {
        sc = _sc;
        systemController = new SystemController();
        boardRepository = new BoardRepository();
        boardService = new BoardService();
        boardController = new BoardController();
    }
    public static void renew() {
        renew(new Scanner(System.in));
    }

}
