package board.repository;

import board.entity.Board;

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

    public List<Board> getAllBoards() {
        return boards;
    }

    public Board findById(int boarId) {
        return boards.stream()
                .filter(board -> board.getId() == boarId)
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
