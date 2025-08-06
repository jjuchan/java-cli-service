package cli.board.controller;

import cli.AppTestRunner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BoardControllerTest {

    @Test
    @DisplayName("actionWrite test")
    void actionWrite() {

        String rs = AppTestRunner.run("""
                write
                테스트 제목
                테스트 내용
                테스트 작성자
                """);

        assertThat(rs).contains("제목:").contains("내용:").contains("작성자:");
    }


    @Test
    @DisplayName("board id test")
    void actionWriteBoardNumber() {
        String rs = AppTestRunner.run("""
                write
                테스트 제목
                테스트 내용
                테스트 작성자
                """);


        assertThat(rs).contains("번 글이 작성되었습니다.");

    }

    @Test
    @DisplayName("boards id test")
    void actionWriteBoardNumbers() {
        String rs = AppTestRunner.run("""
                write
                제목1
                내용1
                작성자1
                write
                제목2
                내용2
                작성자2
                write
                제목3
                내용3
                작성자3
                """);

        assertThat(rs).contains("1번 글이 작성되었습니다.");
        assertThat(rs).contains("2번 글이 작성되었습니다.");
        assertThat(rs).contains("3번 글이 작성되었습니다.");

    }

    @Test
    @DisplayName("actionList test")
    void actionList() {
        String rs = AppTestRunner.run("""
                write
                제목1
                내용1
                작성자1
                write
                제목2
                내용2
                작성자2
                list
                """);

        assertThat(rs).contains("번호: ")
                .contains("제목: ")
                .contains("작성자: ")
                .contains("작성일: ")
                .contains("조회수: ")
                .contains("--------------------------");
    }

    @Test
    @DisplayName("actionDetail test")
    void actionDetail() {
        String rs = AppTestRunner.run("""
                write
                제목1
                내용1
                작성자1
                detail 1
                """);

        assertThat(rs).contains("제목:").contains("내용:").contains("작성자:")
                .contains("작성일:").contains("수정일:").contains("조회수:");
    }

}