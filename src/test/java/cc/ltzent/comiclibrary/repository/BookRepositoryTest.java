package cc.ltzent.comiclibrary.repository;

import cc.ltzent.comiclibrary.domain.Book;
import cc.ltzent.comiclibrary.persistence.entity.BookEntity;
import cc.ltzent.comiclibrary.persistence.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @BeforeEach
    void setUp() {
        BookEntity entity1 = BookEntity.builder()
                .name("Night of the Owls")
                .category("ACTION")
                .author("Scott Snyder")
                .isbn("999-1-23-4567")
                .build();

        bookRepository.save(entity1);

        BookEntity entity2 = BookEntity.builder()
                .name("Reborn")
                .category("DISTOPYAN")
                .author("Mark Miller")
                .isbn("987-12-9-8709")
                .build();

        bookRepository.save(entity2);

        BookEntity entity3 = BookEntity.builder()
                .name("Killing Joke")
                .category("THRILLER")
                .author("Scott Snyder")
                .isbn("876-5-45-2332")
                .build();

        bookRepository.save(entity3);
    }

    @Test
    void testSave() {

        BookEntity entity = BookEntity.builder()
                .name("Harry Potter")
                .category("FANTASY")
                .author("J.K. Rowling")
                .isbn("456-23-1-4567")
                .build();

        BookEntity created = bookRepository.save(entity);

        assertThat(created).isNotNull();
        assertThat(created.getName()).isEqualTo("Harry Potter");
    }

    @Test
    void testGetBooks() {
        Page<BookEntity> page = bookRepository.getBooks(
                new Book(),
                PageRequest.of(0, 10)
        );

        assertThat(page.getTotalElements()).isEqualTo(3);
    }
}
