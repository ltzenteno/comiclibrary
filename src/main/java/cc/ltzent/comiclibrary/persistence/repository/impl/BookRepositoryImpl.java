package cc.ltzent.comiclibrary.persistence.repository.impl;

import cc.ltzent.comiclibrary.domain.Book;
import cc.ltzent.comiclibrary.persistence.entity.BookEntity;
import cc.ltzent.comiclibrary.persistence.repository.CustomBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookRepositoryImpl implements CustomBookRepository {

    private final EntityManager entityManager;

    @Override
    public Collection<BookEntity> getBooks(Book book) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<BookEntity> query = cb.createQuery(BookEntity.class);
        Root<BookEntity> root = query.from(BookEntity.class);

        List<Predicate> predicates = new ArrayList<>();

        if (book.getName() != null && !book.getName().isEmpty()) {
            predicates.add(cb.like(cb.upper(root.get("name")), "%" + book.getName().toUpperCase() + "%"));
        }

        // TODO: add all predicates

        query.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(query).getResultList();
    }
}
