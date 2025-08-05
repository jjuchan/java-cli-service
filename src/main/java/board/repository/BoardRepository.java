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
}
