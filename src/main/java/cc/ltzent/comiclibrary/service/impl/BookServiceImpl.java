package cc.ltzent.comiclibrary.service.impl;

import cc.ltzent.comiclibrary.domain.Book;
import cc.ltzent.comiclibrary.domain.page.CustomPageRequest;
import cc.ltzent.comiclibrary.domain.page.CustomPageResponse;
import cc.ltzent.comiclibrary.persistence.entity.BookEntity;
import cc.ltzent.comiclibrary.persistence.repository.BookRepository;
import cc.ltzent.comiclibrary.service.BookService;
import cc.ltzent.comiclibrary.service.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    @Transactional(readOnly = true)
    public CustomPageResponse<Book> search(Book book, CustomPageRequest customPageRequest) {

        Page<BookEntity> page = bookRepository.getBooks(
                book,
                PageRequest.of(customPageRequest.getPageNumber(), customPageRequest.getPageSize())
        );

        return new CustomPageResponse<>(
                bookMapper.entityListToDomainList(page.getContent()),
                page.getNumber(),
                page.getTotalElements()
        );
    }

    @Override
    public Book save(Book book) {
        BookEntity newEntity = bookMapper.domainToEntity(book);
        return bookMapper.entityToDomain(bookRepository.save(newEntity));
    }
}
