package com.example.search.service;


import com.example.search.config.EndpointConfig;
import com.example.search.pojo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class WeatherServiceImpl implements WeatherService{

    private final RestTemplate restTemplate;


    @Autowired
    public WeatherServiceImpl(RestTemplate getRestTemplate) {
        this.restTemplate = getRestTemplate;
    }


    @Override
    @Retryable(include = IllegalAccessError.class)
    public Map<String, Map> findWeatherByCity (String city){
        City cities=restTemplate.getForObject(EndpointConfig.queryIdByCity+city, City.class);
        return findCityWeatherById(cities.getData().get(0));
    }

    @Override
    public Map<String, Map> findCityWeatherById(int id) {
        Map<String, Map> ans = restTemplate.getForObject(EndpointConfig.queryWeatherById + id, HashMap.class);
        return ans;
    }



}


/**
 *  -> gateway -> eureka
 *       |
 *   weather-search -> hystrix(thread pool) -> 3rd party weather api
 *
 *
 *  circuit breaker(hystrix)  保险丝熔断
 * *  * *  * *  * *  * *  * *  * *  * *  * *  * *  * *  * *  * *  * *
 *   weather-search service should get city id from detail service
 *   and use multi-threading to query city's weather details
 *
 *   gateway
 *     |
 *  weather-service -> 3rd party api(id <-> weather  multi-threading)
 *     |
 *  detail-service -> 3rd party api (city <-> id)
 *
 *  failed situations:
 *      1. 3rd party api timeout -> retry + hystrix
 *      2. 3rd party api available time / rate limit
 *      3. security verification
 *  response
 *      1. no id -> error / empty
 *      2. large response -> pagination / file download (link / email)
 *  performance
 *      1. cache / db
 *
 *   gateway
 *     |
 *  weather-service -> cache(city - id - weather) (LFU)
 *     |
 *   DB (city - id - weather) <-> service <->  message queue  <-> scheduler <-> 3rd party api(city - id)
 *                                                                  |
 *                                                         update id - weather every 30 min
 *                                                         update city - id relation once per day
 *
 *  homework :
 *      deadline -> Wednesday midnight
 *      1. update detail service
 *          a. send request to 3rd party api -> get id by city
 *      2. update search service
 *          a. add ThreadPool
 *          b. send request to detail service -> get id by city
 *          c. use CompletableFuture send request to 3rd party api -> get weather by ids
 *          d. add retry feature
 *
 *
 *
 *
 *
 *
 *
 *    gateway
 *       |
 *    weather-service (CompletableFuture)-> 3rd party api(id <-> weather  multi-threading)
 *       |  (rest template loadbalancer)
 *    detail-service -> 3rd party api (city <-> id)
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */