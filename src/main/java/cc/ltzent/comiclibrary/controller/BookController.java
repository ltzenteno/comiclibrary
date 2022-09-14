package cc.ltzent.comiclibrary.controller;

import cc.ltzent.comiclibrary.domain.Book;
import cc.ltzent.comiclibrary.domain.page.CustomPageRequest;
import cc.ltzent.comiclibrary.domain.page.CustomPageResponse;
import cc.ltzent.comiclibrary.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    @SuppressWarnings("unused")
    @GetMapping
    CustomPageResponse<Book> search(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String isbn
    ) {
        Book book = Book.builder()
                .name(name)
                .category(category)
                .author(author)
                .isbn(isbn)
                .build();

        return bookService.search(book, new CustomPageRequest());
    }

    @SuppressWarnings("unused")
    @PostMapping
    Book save(@RequestBody Book request) {
        return bookService.save(request);
    }
}
