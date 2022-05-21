package com.evl.employeeaccounting.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AbstractRepository<E> extends JpaRepository<E, Long> {
}
