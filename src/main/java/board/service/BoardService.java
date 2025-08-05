package board.service;

import board.entity.Board;
import board.repository.BoardRepository;

import java.util.List;

public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }


    public Board write(String title, String content, String author) {
        Board board = new Board(0,title, author, content, null, 0);
        return boardRepository.save(board);
    }

    public List<Board> getAllBoards() {
        return boardRepository.getAllBoards();
    }

}
