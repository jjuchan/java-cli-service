package board.service;

import board.entity.Board;
import board.repository.BoardRepository;

import java.time.LocalDateTime;
import java.util.List;

public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }


    public Board write(String title, String content, String author) {
        Board board = new Board();
        board.setId(0);  // 저장 시 save()에서 다시 세팅됨
        board.setTitle(title);
        board.setAuthor(author);
        board.setContent(content);
        board.setKeyword("");
        board.setViewCount(0);

        LocalDateTime now = LocalDateTime.now();
        board.setCreatedDate(now);
        board.setModifiedDate(now);

        return boardRepository.save(board);
    }

    public List<Board> getAllBoards() {
        return boardRepository.getAllBoards();
    }

}
