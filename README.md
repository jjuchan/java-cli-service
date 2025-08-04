# java-cli-service

## 🧩 전체 기능 예시

| 기능 | 설명 |
| --- | --- |
| 게시글 작성 | `write` 명령어 입력 시 제목/내용을 받아 새 게시글 생성 |
| 게시글 목록 | `list` 명령어 입력 시 모든 게시글을 번호순으로 출력 |
| 게시글 상세보기 | `detail [id]` 명령어로 특정 게시글 내용을 전체 확인 |
| 게시글 수정 | `update [id]` 명령어로 제목/내용을 수정 |
| 게시글 삭제 | `delete [id]` 명령어로 해당 글 삭제 |
| 종료 | `exit` 명령어로 프로그램 종료 |

---

## 🧠 메서드 설계 예시

| 메서드명 | 설명 |
| --- | --- |
| `run()` | 앱 실행 루프 (입력 대기 및 명령어 처리) |
| `writeArticle()` | 게시글 작성 처리 |
| `listArticles()` | 게시글 목록 출력 |
| `showDetail(int id)` | 특정 글 상세 내용 출력 |
| `updateArticle(int id)` | 게시글 수정 처리 |
| `deleteArticle(int id)` | 게시글 삭제 처리 |
| `getCurrentDate()` | 현재 날짜 리턴 (yyyy-MM-dd 형식) |


## 🛠️ Article 클래스 예시

```java
public class Article {
    private int id;
    private String title;
    private String author;
    private String content;
    private String Keyword;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private int viewCount;

}
```


