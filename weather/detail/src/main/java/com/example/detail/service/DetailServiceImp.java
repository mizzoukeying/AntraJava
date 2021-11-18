package com.example.detail.service;

import com.example.detail.config.EndpointConfig;
import com.example.detail.pojo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * get city<->id mapping, return id to SearchService based on given city
 */

@Service
public class DetailServiceImp implements DetailService{

    private final RestTemplate restTemplate;

    @Autowired
    public DetailServiceImp(RestTemplate getRestTemplate) {

        this.restTemplate = getRestTemplate;
    }


    //from WeatherServiceImp
    @Override
    @Retryable(include = IllegalAccessError.class) //类似for loop， 失败后retry
    public List<Integer> findCityIdByName(String city) {
        City[] cities = restTemplate.getForObject(EndpointConfig.queryIdByCity + city, City[].class);
        List<Integer> ans = new ArrayList<>();
        for(City c: cities) {
            if(c != null && c.getWoeid() != null) {
                ans.add(c.getWoeid());
            }
        }
        return ans;
    }

}



