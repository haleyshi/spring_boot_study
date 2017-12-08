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
	Long saveCity(City city);

	/**
     * 根据关键词，function score query 权重分分页查询
     *
     * @param pageNumber
     * @param pageSize
     * @param searchContent
     * @return
     */
    List<City> searchCity(Integer pageNumber, Integer pageSize, String searchContent);
}
