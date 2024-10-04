package com.alten.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AbstractDaoImpl<S> implements AbstractDao<S>{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public S update(S entity) {
        return entityManager.merge(entity);
    }
}
