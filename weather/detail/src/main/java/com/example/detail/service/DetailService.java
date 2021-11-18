package com.example.detail.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * get city<->id mapping, return id to SearchService based on given city
 */
@Service
public interface DetailService {
    List<Integer> findCityIdByName(String city);
}
