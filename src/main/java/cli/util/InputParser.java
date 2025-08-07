package cli.util;

public class InputParser {
    public static Integer parseId(String[] tokens) {
        if (tokens.length < 2) return null;
        try {
            return Integer.parseInt(tokens[1]);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static String extractSearchKeyword(String input) {
        String[] tokens = input.split("\\s+");
        if (tokens.length > 1) {
            return input.substring(input.indexOf(" ") + 1).trim();
        }
        return null;
    }

}
