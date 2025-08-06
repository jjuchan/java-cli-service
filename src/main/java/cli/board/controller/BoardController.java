package cli.board.controller;


import cli.AppContext;
import cli.board.entity.Board;
import cli.board.service.BoardService;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class BoardController {
    private final Scanner sc;
    private final BoardService boardService;

    public BoardController() {
        this.sc = AppContext.sc;
        this.boardService = AppContext.boardService;
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        for (Board board : boardService.getAllBoards()) {

            String createdDateStr = board.getCreatedDate() != null
                    ? board.getCreatedDate().format(formatter)
                    : "미정";

            String modifiedDateStr = board.getModifiedDate() != null
                    ? board.getModifiedDate().format(formatter)
                    : "미정";

            System.out.println("번호: " + board.getId());
            System.out.println("제목: " + board.getTitle());
            System.out.println("내용: " + board.getContent());
            System.out.println("작성자: " + board.getAuthor());
            System.out.println("작성일: " + createdDateStr);
            System.out.println("수정일: " + modifiedDateStr);
            System.out.println("조회수: " + board.getViewCount());
            System.out.println("--------------------------");
        }
    }


    public void actionDetail(int boarId) {
        Board board = boardService.findById(boarId);
        if (board == null) {
            System.out.println("해당 게시글이 존재하지 않습니다.");
            return;
        }

        // 조회수 증가
        boardService.increaseViewCount(boarId);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String createdDateStr = board.getCreatedDate() != null
                ? board.getCreatedDate().format(formatter)
                : "미정";
        String modifiedDateStr = board.getModifiedDate() != null
                ? board.getModifiedDate().format(formatter)
                : "미정";

        System.out.println("번호: " + board.getId());
        System.out.println("제목: " + board.getTitle());
        System.out.println("내용: " + board.getContent());
        System.out.println("작성자: " + board.getAuthor());
        System.out.println("작성일: " + createdDateStr);
        System.out.println("수정일: " + modifiedDateStr);
        System.out.println("조회수: " + board.getViewCount());
    }

    public void actionUpdate() {
    }

    public void actionDelete() {
    }

    public void actionExit() {
    }


}
