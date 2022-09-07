package cc.ltzent.comiclibrary.persistence.repository;

import cc.ltzent.comiclibrary.domain.Book;
import cc.ltzent.comiclibrary.persistence.entity.BookEntity;

import java.util.Collection;

public interface CustomBookRepository {
    Collection<BookEntity> getBooks(Book book);
}
