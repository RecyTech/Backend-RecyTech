package com.acme.recytechbackend.search.application.service;

import com.acme.recytechbackend.search.domain.model.Device;
import com.acme.recytechbackend.search.domain.model.SearchQuery;
import com.acme.recytechbackend.search.domain.model.repository.SearchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    private final SearchRepository searchRepository;

    public SearchService(SearchRepository searchRepository) {
        this.searchRepository = searchRepository;
    }

    public List<Device> searchDevices(String keyword, String category) {
        return searchRepository.searchDevices(new SearchQuery(keyword, category));
    }
}