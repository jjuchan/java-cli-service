package board.controller;


import util.AppContext;

import java.util.Scanner;

public class BoardController {
    private final Scanner sc;

    public BoardController(AppContext context) {
        this.sc = context.getScanner();
    }

    public void actionWrite() {

        System.out.println("제목: ");
        String title = sc.nextLine().trim();

        System.out.println("내용: ");
        String content = sc.nextLine().trim();

        System.out.println("작성자: ");
        String author = sc.nextLine().trim();


    }

    public void actionList() {

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
