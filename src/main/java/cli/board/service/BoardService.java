package cli.board.service;

import cli.AppContext;
import cli.board.entity.Board;
import cli.board.repository.BoardRepository;

import java.util.List;

public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService() {
        this.boardRepository = AppContext.boardRepository;
    }

    public Board write(String title, String content, String author) {
        Board board = new Board();
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

    public void delete(int boarId) {
        Board board = boardRepository.findById(boarId);
        if (board != null) {
            boardRepository.getAllBoards().remove(board);
        }
    }
}
