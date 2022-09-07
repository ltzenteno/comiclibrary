package cc.ltzent.comiclibrary.service;

import cc.ltzent.comiclibrary.domain.Book;

import java.util.Collection;

public interface BookService {

    Collection<Book> search(Book book);
    Book save(Book book);
}
