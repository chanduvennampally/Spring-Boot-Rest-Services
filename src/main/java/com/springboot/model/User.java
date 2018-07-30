package com.springboot.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "USER")
@EntityListeners(AuditingEntityListener.class)
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5478800092198948165L;

	@Id
	@Column(name = "USER_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@Column(name = "ROLE_ID", nullable = false)
	private Long roleId;

	@NotBlank
	@Column(name = "NAME", nullable = false)
	private String name;

	@NotBlank
	@Column(name = "EMAIL", nullable = false)
	private String email;

	@Column(name = "AGE", nullable = false)
	private int age;

	@Column(name = "SALARY", nullable = false)
	private double salary;

	public User() {

	}

	public User(Long userId, Long roleId, @NotBlank String name, @NotBlank String email, int age, double salary) {
		this.userId = userId;
		this.roleId = roleId;
		this.name = name;
		this.email = email;
		this.age = age;
		this.salary = salary;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (userId ^ (userId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + userId + ", name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}
}
