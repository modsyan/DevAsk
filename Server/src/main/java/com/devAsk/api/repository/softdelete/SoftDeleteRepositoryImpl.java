/*
package com.devAsk.api.repository.softdelete;

import jakarta.persistence.EntityManager;
import org.springdoc.core.converters.models.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SoftDeleteRepositoryImpl<T, Id extends Serializable> implements SoftDeleteRepository<T, Id> {

    private final JpaEntityInformation<T, ?> entityInformation;
    private final EntityManager entityManager;
    private final Class<T> domainClass;

    public SoftDeleteRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
        super();
        this.entityManager = entityManager;
        this.domainClass = domainClass;
        entityInformation = JpaEntityInformationSupport.getEntityInformation(domainClass, entityManager);
    }

    private static final String DELETED_FILED = "deletedOn";

    @Override
    public Iterable findAllActive() {
        return null;
    }

    @Override
    public Iterable findAllActive(Sort sort) {
        return null;
    }

    @Override
    public Page findAllActive(Pageable pageable) {
        return null;
    }

    @Override
    public Iterable findAllActive(Iterable iterable) {
        return null;
    }

    @Override
    public Object findOneActive(Serializable serializable) {
        return null;
    }

    @Override
    public void softDelete(Iterable entities) {

    }

    @Override
    public void softDeleteAll() {

    }

    @Override
    public void scheduleSoftDelete(Serializable serializable, LocalDateTime localDateTime) {

    }

    @Override
    public void scheduleSoftDelete(Object entity, LocalDateTime localDateTime) {

    }

    @Override
    public long countActive() {
        return 0;
    }

    @Override
    public boolean existsActive(Serializable serializable) {
        return false;
    }

    @Override
    public Iterable findAll(org.springframework.data.domain.Sort sort) {
        return null;
    }

    @Override
    public Page findAll(Pageable pageable) {
        return null;
    }

    private void softDelete(T entity, LocalDateTime localDateTime) {


    }
}
*/
