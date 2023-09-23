/*
package com.devAsk.api.repository.softdelete;

import org.springdoc.core.converters.models.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;
import java.time.LocalDateTime;

public interface SoftDeleteRepository<T, Id extends Serializable> extends PagingAndSortingRepository<T, Id> {

    Iterable<T> findAllActive();

    Iterable<T> findAllActive(Sort sort);

    Page<T> findAllActive(Pageable pageable);

    Iterable<T> findAllActive(Iterable<Id> ids);

    T findOneActive(Id id);

    @Modifying
    void softDelete(Iterable<? extends T> entities);

    @Modifying
    void softDeleteAll();

    @Modifying
    void scheduleSoftDelete(Id id, LocalDateTime localDateTime);

    @Modifying
    void scheduleSoftDelete(T entity, LocalDateTime localDateTime);

    long countActive();

    boolean existsActive(Id id);
}
*/
