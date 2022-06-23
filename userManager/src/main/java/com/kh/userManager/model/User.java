package com.kh.UserManager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table( name="users" )
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private long id;
	
	
	@Column(name="name")
	private String name;
	
	
	@Column(name="family")
	private String family;
	
	@Column(name= "active")
	private boolean active;

	public User(String name, String family, boolean active) {
		super();
		this.name = name;
		this.family = family;
		this.active = active;
	}
	
	
	
}
