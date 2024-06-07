package com.acme.recytechbackend.search.infrastructure.repository;

import com.acme.recytechbackend.search.domain.model.Device;
import com.acme.recytechbackend.search.domain.model.SearchQuery;
import com.acme.recytechbackend.search.domain.model.repository.SearchRepository;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Repository
public class DatabaseSearchRepository implements SearchRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Device> searchDevices(SearchQuery query) {
        String jpql = "SELECT d FROM Device d WHERE d.name LIKE :keyword AND d.category = :category";
        TypedQuery<Device> typedQuery = entityManager.createQuery(jpql, Device.class);
        typedQuery.setParameter("keyword", "%" + query.keyword() + "%");
        typedQuery.setParameter("category", query.category());

        return typedQuery.getResultList();
    }
}
