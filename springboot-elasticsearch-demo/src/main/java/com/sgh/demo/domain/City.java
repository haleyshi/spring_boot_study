/**
 * 
 */
package com.sgh.demo.domain;

import java.io.Serializable;

import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author eguoshi
 *
 */
@Document(indexName = "cityindex", type = "city")
public class City implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long provinceid;
	private String cityname;
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProvinceid() {
		return provinceid;
	}

	public void setProvinceid(Long provinceid) {
		this.provinceid = provinceid;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
