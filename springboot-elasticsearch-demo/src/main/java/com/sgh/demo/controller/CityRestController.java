/**
 * 
 */
package com.sgh.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sgh.demo.domain.City;
import com.sgh.demo.service.CityService;

/**
 * @author eguoshi
 *
 */
@RestController
public class CityRestController {
	@Autowired
	private CityService cityService;

	@RequestMapping(value = "/api/city", method = RequestMethod.POST)
	public void createCity(@RequestBody City city) {
		cityService.saveCity(city);
	}

	@RequestMapping(value = "/api/city/search", method = RequestMethod.GET)
	public List<City> searchCity(@RequestParam(value = "pageNumber") Integer pageNumber,
			@RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestParam(value = "searchContent") String searchContent) {
		return cityService.searchCity(pageNumber, pageSize, searchContent);
	}
}
