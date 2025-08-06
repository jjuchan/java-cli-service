package board.entity;

import lombok.*;
import util.Base;


@Getter
@Setter
@RequiredArgsConstructor
public class Board extends Base {
    private int id;
    private String title;
    private String author;
    private String content;
    private String keyword;
    private int viewCount; // 조회수

}
