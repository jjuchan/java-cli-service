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

    public boolean update(int boardId, String title, String content) {
        boolean result = boardRepository.update(boardId, title, content);
        if (!result) {
            System.out.println("해당 게시글이 존재하지 않습니다.");
        }
        return result;
    }

    public boolean delete(int boardId) {
        boolean result = boardRepository.delete(boardId);
        if (!result) {
            System.out.println("해당 게시글이 존재하지 않습니다.");
        }
        return result;
    }

}
