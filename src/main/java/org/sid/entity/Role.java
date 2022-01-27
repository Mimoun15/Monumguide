
package org.sid.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity

@Table(name = "role")
public class Role {

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;

	/*
	 * @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
	 * 
	 * @JsonBackReference private Set<User> users = new HashSet<User>();
	 */
	
	
	@ManyToMany(mappedBy="roles", fetch = FetchType.EAGER)
	@JsonBackReference
	private  Collection<User> users = new HashSet<User>();

	
	
	public Role() {

	}

	public Role(String name) {
		this.setName(name);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
