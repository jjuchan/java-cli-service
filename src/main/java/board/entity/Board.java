package board.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import util.Base;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Board extends Base {
    private int id;
    private String title;
    private String author;
    private String content;
    private String keyword;
    private int viewCount; // 조회수

}
