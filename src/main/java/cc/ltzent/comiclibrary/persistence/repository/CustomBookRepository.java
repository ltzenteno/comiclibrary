package cc.ltzent.comiclibrary.persistence.repository;

import cc.ltzent.comiclibrary.domain.Book;
import cc.ltzent.comiclibrary.persistence.entity.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CustomBookRepository {
    Page<BookEntity> getBooks(Book book, Pageable pageable);
}
