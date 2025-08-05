package util;

import java.util.Scanner;

public class AppContext {
    private final Scanner sc = new Scanner(System.in);

    public Scanner getScanner() {
        return sc;
    }
}
