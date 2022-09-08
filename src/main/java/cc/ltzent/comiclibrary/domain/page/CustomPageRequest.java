package cc.ltzent.comiclibrary.domain.page;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomPageRequest {

    public CustomPageRequest() {
        this.pageNumber = 0;
        this.pageSize = 50;
    }

    private Integer pageNumber;
    private Integer pageSize;
}
