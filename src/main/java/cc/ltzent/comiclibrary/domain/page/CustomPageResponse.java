package cc.ltzent.comiclibrary.domain.page;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collection;

@Getter
@AllArgsConstructor
public class CustomPageResponse<T> {
    private Collection<T> elements;
    private Integer pageNumber;
    private Long totalElements;
}
