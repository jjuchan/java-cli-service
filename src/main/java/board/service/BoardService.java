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
        Board board = new Board();
        board.setId(0);  // ID는 저장 시 자동으로 증가되므로 초기값은 0으로 설정
        board.setTitle(title);
        board.setAuthor(author);
        board.setContent(content);
        board.setKeyword("");
        board.setViewCount(0);

        return boardRepository.save(board);
    }

    public List<Board> getAllBoards() {
        return boardRepository.getAllBoards();
    }

    public Board findById(int boarId) {
        return boardRepository.findById(boarId);
    }

    public void increaseViewCount(int boardId) {
        boardRepository.increaseViewCount(boardId);
    }
}
