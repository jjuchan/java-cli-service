package cli;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class AppTest {
    @Test
    @DisplayName("`== 게시판 앱 == ` 출력")
    public void t1() {
        String rs = AppTestRunner.run("");
        assertThat(rs)
                .contains("== 게시판 앱 ==")
                .contains("명령어: ");
    }
}