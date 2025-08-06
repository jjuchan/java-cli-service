#  📖 Java CLI 게시판 서비스


이 프로젝트는 Java로 구현된 CLI 기반 게시판 서비스입니다.

## 🧩 전체 기능

| 메서드              | 설명                                      |
|------------------|-----------------------------------------|
| `write()`        | 게시글 작성                                  |
| `list()`         | 게시글 목록 출력(조회수가 많은 순으로 정렬, 같다면 최신순으로 정렬) |
| `detail(int id)` | 게시글 상세보기                                |
| `update(int id)` | 게시글 수정                                  |
| `delete(int id)` | 게시글 삭제                                  |   
| `search(String keyword)` | 게시글 검색(제목,글,작성자 검색 가능)                  |   
| `exit()`         | 프로그램 종료                                 |

---

## 📚 기술 스택
- Java 21
- Lombok
- JUnit 5
- assertj-core

---

## 🛠️ Entity (lombok 사용)

```java
//Base를 상속받아 시간 자동 생성
public class Board extends Base {
    private int id;
    private String title;
    private String author;
    private String content;
    private int viewCount; // 조회수

  
  // 시간 자동 생성 util 클래스 사용
  public class Base {
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public Base() {
      this.createdDate = LocalDateTime.now();
      this.modifiedDate = LocalDateTime.now();
    }
  }

}
```

---
## 🗂️주요 디렉토리
```
.
└── src/
    ├── main/
    │   └── java/
    │       └── com/
    │           └── example/
    │               ├── App.java
    │               ├── AppContext.java
    │               ├── Main.java
    │               ├── board/
    │               │   ├── Board.java
    │               │   ├── BoardRepository.java
    │               │   ├── BoardService.java
    │               │   └── controller/
    │               │       └── BoardController.java
    │               ├── system/
    │               │   └── controller/
    │               │       └── SystemController.java
    │               └── util/
    │                   ├── Base.java 
    │                   ├── InputParser.java
    │                   ├── PrintBoard.java
    │                   └── TestUtil.java
    └── test/
        └── java/
            └── com/
                └── example/
                    ├── AppTest.java
                    ├── AppTestRunner.java
                    ├── board/
                    │   └── controller/
                    │       └── BoardControllerTest.java
                    ├── system/
                    │   └── controller/
                    │       └── SystemControllerTest.java
                    └── util/
                        └── TestUtilTest.java
                
```
---
## 🔥 주요 서비스 설명
### ✅BoardService
- **주요 기능**
    - `write(String title, String content, String author)` : 새 게시글 생성 후 저장
    - `getAllBoards()` : 모든 게시글 조회
    - `findById(int boardId)` : 특정 게시글 조회
    - `increaseViewCount(int boardId)` : 조회수 증가
    - `update(int boardId, String title, String content)` : 제목과 내용 수정, 수정일 갱신
    - `delete(int boardId)` : 게시글 삭제


### ✅BoardController
- **주요 기능**
    - `actionWrite()` : 제목, 내용, 작성자를 입력받아 게시글 작성
    - `actionList()` : 모든 게시글을 수정일 기준 내림차순으로 출력
    - `actionDetail(int boardId)` : 특정 게시글 조회 및 조회수 증가
    - `actionUpdate(int boardId)` : 제목, 내용 수정
    - `actionDelete(int boardId)` : 게시글 삭제 (사용자 확인 포함)
    - `actionSearch(String keyword)` : 제목, 내용, 작성자 기준 게시글 검색

### ✅BoardRepository
- **주요 기능**
    - `save(Board board)` : 새 게시글 저장 및 ID 자동 생성
    - `getAllBoards()` : 모든 게시글 반환
    - `findById(int boardId)` : 특정 게시글 조회
    - `increaseViewCount(int boardId)` : 특정 게시글 조회수 증가

---

### 🧪 TDD 워크플로(권장)
프로젝트 개발 시 다음 TDD(Test-Driven Development) 워크플로를 권장합니다.
- **테스트 먼저 작성(실패)**: 구현할 기능에 대한 요구사항과 엣지 케이스를 정의하고, 이를 검증하는 테스트 코드를 먼저 작성합니다. 이 단계에서 테스트는 실패해야 합니다.
- **구현(통과)**: 최소한의 코드로 작성된 테스트를 통과시킬 수 있도록 기능을 구현합니다.
- **리팩터링**: 테스트가 계속 통과하는지 확인하면서 코드의 중복을 제거하고 가독성을 개선하는 등 코드 품질을 향상시킵니다.
  사용 라이브러리: JUnit 5, AssertJ

 ---


                




