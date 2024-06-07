package com.acme.recytechbackend.search.domain.model.repository;

import com.acme.recytechbackend.search.domain.model.Device;
import com.acme.recytechbackend.search.domain.model.SearchQuery;

import java.util.List;

public interface SearchRepository {
    List<Device> searchDevices(SearchQuery query);
}
