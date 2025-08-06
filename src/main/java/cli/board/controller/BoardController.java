package cli.board.controller;


import cli.AppContext;
import cli.board.entity.Board;
import cli.board.service.BoardService;

import java.time.format.DateTimeFormatter;
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

        boards.sort((b1, b2) -> b2.getModifiedDate().compareTo(b1.getModifiedDate()));

        for (Board board : boards) {

            printBoard(board);

        }
    }


    public void actionDetail(int boarId) {
        Board board = boardService.findById(boarId);
        if (board == null) {
            System.out.println("해당 게시글이 존재하지 않습니다.");
            return;
        }

        boardService.increaseViewCount(boarId);

        printBoard(board);
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

        boardService.update(boardId, title, content, board.getAuthor());
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
        for (Board board : boardService.getAllBoards()) {
            if (board.getTitle().contains(keyword) || board.getContent().contains(keyword) || board.getAuthor().contains(keyword)) {
                printBoard(board);
                found = true;
            }
        }
        if (!found) {
            System.out.println("검색 결과가 없습니다.");
        }
    }

    private void printBoard(Board board) {
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
        System.out.println("----------------------------");
    }
}