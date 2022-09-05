package cc.ltzent.comiclibrary.service.mapper;

import cc.ltzent.comiclibrary.domain.Book;
import cc.ltzent.comiclibrary.persistence.entity.BookEntity;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    List<Book> entityListToDomainList(Collection<BookEntity> entities);
    Book entityToDomain(BookEntity entity);
}
