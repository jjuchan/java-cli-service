package cli.board.repository;

import cli.board.entity.Board;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BoardRepository {
    private final List<Board> boards = new ArrayList<>();
    private int lastId;

    public Board save(Board board) {
        board.setId(++lastId);
        boards.add(board);
        return board;
    }
    public boolean update(int boardId, String title, String content) {
        Board board = findById(boardId);
        if (board == null) {
            return false;
        }
        board.setTitle(title);
        board.setContent(content);
        board.setModifiedDate(LocalDateTime.now());
        return true;
    }

    public boolean delete(int boardId) {
        Board board = findById(boardId);
        if (board == null) {
            return false;
        }
        return boards.remove(board);
    }





    public List<Board> getAllBoards() {
        return boards;
    }

    public Board findById(int boardId) {
        return boards.stream()
                .filter(board -> board.getId() == boardId)
                .findFirst()
                .orElse(null);
    }
    public void increaseViewCount(int boardId) {
        Board board = findById(boardId);
        if (board != null) {
            board.setViewCount(board.getViewCount() + 1);
        }
    }
}
