package cc.ltzent.comiclibrary.persistence.repository.impl;

import cc.ltzent.comiclibrary.domain.Book;
import cc.ltzent.comiclibrary.persistence.entity.BookEntity;
import cc.ltzent.comiclibrary.persistence.repository.CustomBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookRepositoryImpl implements CustomBookRepository {

    private final EntityManager entityManager;

    @Override
    public Page<BookEntity> getBooks(Book book, Pageable pageable) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<BookEntity> query = cb.createQuery(BookEntity.class);
        Root<BookEntity> root = query.from(BookEntity.class);

        List<Predicate> predicates = new ArrayList<>();

        if (book.getName() != null && !book.getName().isEmpty()) {
            predicates.add(cb.like(cb.upper(root.get("name")), "%" + book.getName().toUpperCase() + "%"));
        }

        if (book.getAuthor() != null && !book.getAuthor().isEmpty()) {
            predicates.add(cb.like(cb.upper(root.get("author")), "%" + book.getAuthor() + "%"));
        }

        if (book.getIsbn() != null && !book.getIsbn().isEmpty()) {
            predicates.add(cb.equal(root.get("isbn"), book.getIsbn()));
        }

        if (book.getCategory() != null && !book.getCategory().isEmpty()) {
            predicates.add(cb.equal(root.get("category"), book.getCategory()));
        }

        query.where(predicates.toArray(new Predicate[0]));

        // TODO: add here order by

        // generate paginated response
        TypedQuery<BookEntity> typedQuery = entityManager.createQuery(query);
        List<BookEntity> resultList = typedQuery.getResultList();

        return new PageImpl<>(resultList, pageable, resultList.size());
    }
}
