package cli.system;

import cli.AppTestRunner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SystemControllerTest {
    @Test
    @DisplayName("`프로그램을 종료합니다.` 출력")
    public void t1() {
        String rs = AppTestRunner.run("종료");
        assertThat(rs)
                .contains("프로그램을 종료합니다.");
    }
}
