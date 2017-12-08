/**
 * 
 */
package com.sgh.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sgh.demo.domain.City;

/**
 * @author eguoshi
 *
 */
public interface CityDao {

	List<City> findAllCity();
	
	City findById(@Param("id") Long id);

    Long saveCity(City city);

    Long updateCity(City city);

    Long deleteCity(Long id);
}
