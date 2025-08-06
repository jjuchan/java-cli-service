package cli.board.controller;


import cli.AppContext;
import cli.board.entity.Board;
import cli.board.service.BoardService;
import cli.util.PrintBoard;

import java.util.List;
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
        List<Board> boards = boardService.getAllBoards();

        boards.sort((b1, b2) -> {
            int cmp = b2.getViewCount() - b1.getViewCount();
            if (cmp == 0) cmp = b2.getModifiedDate().compareTo(b1.getModifiedDate());
            return cmp;
        });

        for (Board board : boards) {
            PrintBoard.print(board);
        }
    }

    public void actionDetail(int boarId) {
        Board board = boardService.findById(boarId);
        if (board == null) {
            System.out.println("해당 게시글이 존재하지 않습니다.");
            return;
        }

        boardService.increaseViewCount(boarId);

        PrintBoard.print(board);
    }

    public void actionUpdate(int boardId) {
        Board board = boardService.findById(boardId);
        if (board == null) {
            System.out.println("해당 게시글이 존재하지 않습니다.");
            return;
        }
        System.out.print("제목 (현재: " + board.getTitle() + "): ");
        String title = sc.nextLine().trim();
        System.out.print("내용 (현재: " + board.getContent() + "): ");
        String content = sc.nextLine().trim();

        boardService.update(boardId, title, content);
        System.out.println(boardId + " 번 글이 수정되었습니다.");

    }

    public void actionDelete(int boarId) {
        Board board = boardService.findById(boarId);
        if (board == null) {
            System.out.println("해당 게시글이 존재하지 않습니다.");
            return;
        }
        System.out.print("정말로 삭제하시겠습니까? (y/n): ");
        String confirmation = sc.nextLine().trim().toLowerCase();
        if (!confirmation.equals("y")) {
            System.out.println("삭제가 취소되었습니다.");
            return;
        } else {
            boardService.delete(boarId);
            System.out.println(boarId + " 번 글이 삭제되었습니다.");
        }


    }


    public void actionSearch(String keyword) {
        List<Board> boards = boardService.getAllBoards();
        boolean found = false;
        for (Board board : boards) {
            if (board.getTitle().contains(keyword) || board.getContent().contains(keyword) || board.getAuthor().contains(keyword)) {
                PrintBoard.print(board);
                found = true;
            }
        }
        if (!found) {
            System.out.println("검색 결과가 없습니다.");
        }
    }


}