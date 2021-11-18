package com.example.search.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface WeatherService {
    List<Integer> findCityIdByName(String city);
    //新增多城市查询方法
//    List<List<Integer>> findCityIdByNames(List<String> cities);

    Map<String, Map> findCityWeatherById(int id);

    Map<String, Object> findWeatherByCity(String city);
}
