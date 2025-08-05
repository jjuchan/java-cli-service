package board.controller;


import board.entity.Board;
import board.repository.BoardRepository;
import board.service.BoardService;
import util.AppContext;

import java.util.Scanner;

public class BoardController {
    private final Scanner sc;
    private final BoardService boardService;

    public BoardController(AppContext context) {
        this.sc = context.getScanner();
        this.boardService = new BoardService(new BoardRepository());
    }

    public void actionWrite() {

        System.out.print("제목: ");
        String title = sc.nextLine().trim();

        System.out.print("내용: ");
        String content = sc.nextLine().trim();

        System.out.print("작성자: ");
        String author = sc.nextLine().trim();

        Board board = boardService.write(title, content, author);
        System.out.println(board.getId() + "번 글이 작성되었습니다.");

    }

    public void actionList() {
        System.out.println("번호 | 제목 | 작성자 | 작성일 | 조회수");
        System.out.println("-------------------------------");
        for (Board board : boardService.getAllBoards()) {
            System.out.printf("%d | %s | %s | %s | %d\n", board.getId(), board.getTitle(), board.getAuthor(), board.getCreatedDate(), board.getViewCount());
        }
    }

    public void actionDetail() {
    }

    public void actionUpdate() {
    }

    public void actionDelete() {
    }

    public void actionExit() {
    }


}
