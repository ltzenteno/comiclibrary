package cc.ltzent.comiclibrary.repository;

import cc.ltzent.comiclibrary.persistence.repository.BookRepository;
import cc.ltzent.comiclibrary.service.BookService;
import cc.ltzent.comiclibrary.service.impl.BookServiceImpl;
import cc.ltzent.comiclibrary.service.mapper.BookMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class BookRepositoryTest {

    private BookService bookService;
    @Mock
    private BookRepository bookRepository;

    @BeforeEach
    void setUp() {
        BookMapper mapper = Mappers.getMapper(BookMapper.class);
        bookService = new BookServiceImpl(bookRepository, mapper);
    }

    @Test
    void getBooks() {
        assertThat(bookService.getBooks()).isEqualTo(List.of());
    }
}
