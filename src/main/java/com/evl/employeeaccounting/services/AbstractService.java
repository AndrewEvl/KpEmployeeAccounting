package com.evl.employeeaccounting.services;

import com.evl.employeeaccounting.repositories.AbstractRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@NoRepositoryBean
@Transactional
public abstract class AbstractService<E, R extends AbstractRepository<E>> {

    protected final R repository;

    public Optional<E> findById(Long id) {
        return repository.findById(id);
    }

    public List<E> findAll() {
        return repository.findAll();
    }

    public List<E> findAllByIds(Collection<Long> ids) {
        return repository.findAllById(ids);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public E save(E e) {
        return repository.save(e);
    }

    @Transactional
    public void delete(E e) {
        repository.delete(e);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public AbstractService(final R repository) {
        this.repository = repository;
    }
}
