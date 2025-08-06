package cli.util;

import cli.board.controller.BoardController;

public class InputParser {
    public static Integer parseId(String[] tokens) {
        if (tokens.length < 2) {
            System.out.println("게시글 ID를 입력해주세요.");
            return null;
        }
        try {
            return Integer.parseInt(tokens[1]);
        } catch (NumberFormatException e) {
            System.out.println("올바른 게시글 번호를 입력하세요.");
            return null;
        }
    }
    public static void handleSearch(String input, BoardController boardController) {
        String[] tokens = input.split("\\s+");
        if (tokens.length > 1) {
            String keyword = input.substring(input.indexOf(" ") + 1).trim();
            boardController.actionSearch(keyword);
        } else {
            System.out.println("검색어를 입력해주세요.");
        }
    }

}
