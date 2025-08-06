package cli.util;

import cli.board.entity.Board;

import java.time.format.DateTimeFormatter;

public class PrintBoard {
    public static void print(Board board) {
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
