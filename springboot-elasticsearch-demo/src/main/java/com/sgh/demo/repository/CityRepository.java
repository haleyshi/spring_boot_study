package com.sgh.demo.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.sgh.demo.domain.City;

/**
 * @author eguoshi
 *
 */
@Repository
public interface CityRepository extends ElasticsearchRepository<City,Long> {

}
