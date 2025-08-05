package controller;

import board.controller.BoardController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.AppContext;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BoardControllerTest {

    @Test
    @DisplayName("actionWrite test")
    void actionWrite() {

        String input = "테스트 제목\n테스트 내용\n테스트 작성자\n";
        ByteArrayInputStream testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);


        ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));


        Scanner scanner = new Scanner(System.in);
        AppContext context = new AppContext();
        BoardController controller = new BoardController(context);


        controller.actionWrite();


        String output = testOut.toString();
        assertThat(output).contains("제목:").contains("내용:").contains("작성자:");
    }

    @Test
    @DisplayName("actionWrtite boardnumber test")
    void actionWriteBoardNumber() {
        String input = "테스트 제목\n테스트 내용\n테스트 작성자\n";
        ByteArrayInputStream testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);


        ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));


        Scanner scanner = new Scanner(System.in);
        AppContext context = new AppContext();
        BoardController controller = new BoardController(context);


        controller.actionWrite();


        String output = testOut.toString();
        assertThat(output).contains("1번 글이 작성되었습니다.");

    }
}