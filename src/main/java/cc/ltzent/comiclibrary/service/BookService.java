package cc.ltzent.comiclibrary.service;

import cc.ltzent.comiclibrary.domain.Book;
import cc.ltzent.comiclibrary.domain.page.CustomPageRequest;
import cc.ltzent.comiclibrary.domain.page.CustomPageResponse;

public interface BookService {

    CustomPageResponse<Book> search(Book book, CustomPageRequest customPageRequest);
    Book save(Book book);
}
