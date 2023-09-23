/*
package com.devAsk.api.util;

import com.devAsk.api.repository.softdelete.SoftDeleteRepository;
import com.devAsk.api.repository.softdelete.SoftDeleteRepositoryImpl;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import java.io.Serializable;
public class CustomJpaRepositoryFactoryBean<T extends JpaRepository<S, ID>, S, ID extends Serializable>
        extends JpaRepository<T, S, ID> {

    public CustomJpaRepositoryFactoryBean(Class<? extends T> repositoryInterface) {
        super(repositoryInterface);
    }

    @Override
    protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
        return new CustomJpaRepositoryFactoryBean<T, ID>(entityManager);
    }

    private static class CustomJpaRepositoryFactory<T, ID extends Serializable> extends JpaRepository {

        private final EntityManager entityManager;

        public CustomJpaRepositoryFactory(EntityManager entityManger) {
            super(entityManger);
            this.entityManager = entityManger;
        }

        @Override
        @SuppressWarnings("uncheacked")
        protected Object getTargetRepository(RepositoryInformation information) {
            return new SoftDeleteRepositoryImpl<T, ID>((Class<T>) information.getDomainType(), entityManager);
        }

        @Override
        protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
            return SoftDeleteRepository.class;
        }

    }
}
*/
