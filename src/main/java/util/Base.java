package util;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Base {
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public Base() {
        this.createdDate = LocalDateTime.now();
        this.modifiedDate = LocalDateTime.now();
    }
}


// 시간 관리