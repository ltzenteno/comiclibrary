package cc.ltzent.comiclibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private String id;
    private String name;
    private String category;
    private String isbn;
    private String author;
}
