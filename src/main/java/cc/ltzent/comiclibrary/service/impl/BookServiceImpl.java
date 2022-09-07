package cc.ltzent.comiclibrary.service.impl;

import cc.ltzent.comiclibrary.domain.Book;
import cc.ltzent.comiclibrary.persistence.entity.BookEntity;
import cc.ltzent.comiclibrary.persistence.repository.BookRepository;
import cc.ltzent.comiclibrary.service.BookService;
import cc.ltzent.comiclibrary.service.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    @Transactional(readOnly = true)
    public Collection<Book> search(Book book) {
        return bookMapper.entityListToDomainList(bookRepository.getBooks(book));
    }

    @Override
    public Book save(Book book) {
        BookEntity newEntity = bookMapper.domainToEntity(book);
        return bookMapper.entityToDomain(bookRepository.save(newEntity));
    }
}
