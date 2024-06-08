package com.acme.recytechbackend.search.interfaces.controller;

import com.acme.recytechbackend.search.application.service.SearchService;
import com.acme.recytechbackend.devices.domain.model.aggregates.Device;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {

    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/search")
    public List<Device> searchDevices(@RequestParam String keyword, @RequestParam String category) {
        return searchService.searchDevices(keyword, category);
    }
}