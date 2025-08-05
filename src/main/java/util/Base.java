package util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Base {
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}


// 시간 관리