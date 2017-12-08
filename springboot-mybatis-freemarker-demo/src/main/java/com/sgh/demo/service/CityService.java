/**
 * 
 */
package com.sgh.demo.service;

import java.util.List;

import com.sgh.demo.domain.City;

/**
 * @author eguoshi
 *
 */
public interface CityService {
	List<City> findAllCity();
	City findCityById(Long id);
    Long saveCity(City city);
    Long updateCity(City city);
    Long deleteCity(Long id);
}
