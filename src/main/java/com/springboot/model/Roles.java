package com.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "ROLE")
@EntityListeners(AuditingEntityListener.class)
public class Roles {

	@Id
	@Column(name = "ROLE_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roleId;

	@NotBlank
	@Column(name = "ROLE", nullable = false)
	private String role_name;

	public Roles() {

	}

	public Roles(Long roleId, String role) {
		this.roleId = roleId;
		this.role_name = role;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return role_name;
	}

	public void setRoleName(String role) {
		this.role_name = role;
	}

}
