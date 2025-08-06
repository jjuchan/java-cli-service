package cli.util;

import cli.util.TestUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class TestUtilTest {

    @Test
    @DisplayName("genScanner() 메서드가 정상적으로 실행되어야 한다.")
    void genScanner() {
        Scanner scanner = TestUtil.genScanner("""
                write
                나의 죽음을 적들에게 알리지 말라!
                이순신
                """);

        String cmd = scanner.nextLine();
        String content = scanner.nextLine();
        String author = scanner.nextLine();
        assertThat(cmd).isEqualTo("write");
        assertThat(content).isEqualTo("나의 죽음을 적들에게 알리지 말라!");
        assertThat(author).isEqualTo("이순신");
    }

    @Test
    @DisplayName("setOutToByteArray() 메서드가 정상적으로 실행되어야 한다.")
    void setOutToByteArray() {
        ByteArrayOutputStream byteArrayOutputStream = TestUtil.setOutToByteArray();

        System.out.println("2 / 이순신 / 나의 죽음을 적들에게 알리지 말라!");

        String out = byteArrayOutputStream.toString().trim();
        TestUtil.clearSetOutToByteArray();

        assertThat(out).isEqualTo("2 / 이순신 / 나의 죽음을 적들에게 알리지 말라!");
        System.out.println("이제는 화면에 출력됩니다.");
    }

    @Test
    @DisplayName("clearSetOutToByteArray() 메서드가 정상적으로 실행되어야 한다.")
    void clearSetOutToByteArray() {
        ByteArrayOutputStream byteArrayOutputStream = TestUtil.setOutToByteArray();
        System.out.println("테스트 출력");

        TestUtil.clearSetOutToByteArray();

        // 이후 출력은 원래 System.out으로 돌아가야 함
        System.out.println("이제는 화면에 출력됩니다.");

        String out = byteArrayOutputStream.toString().trim();
        assertThat(out).isEqualTo("테스트 출력");
    }
}