package cc.ltzent.comiclibrary.persistence.repository;

import cc.ltzent.comiclibrary.persistence.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, String>, CustomBookRepository {
}
