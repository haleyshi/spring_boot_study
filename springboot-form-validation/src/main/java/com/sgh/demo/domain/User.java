package com.sgh.demo.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@NotEmpty(message = "姓名不能为空")
	@Size(min = 2, max = 20, message = "姓名长度必须大于 2, 且小于 20字")
	private String name;

	@NotNull(message = "年龄不能为空")
	@Min(value = 0, message = "年龄大于等于 0")
	@Max(value = 150, message = "年龄不大于 150")
	private Integer age;

	@NotEmpty(message = "出生时间不能为空")
	private String birthday;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "User{" + "id=" + id + ", name='" + name + '\'' + ", age=" + age + ", birthday=" + birthday + '}';
	}
}
