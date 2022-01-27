package org.sid.entity;

import java.io.Serializable;

import java.util.Collection;
import java.util.List;
import javax.persistence.*;

@Entity
public class Celebrite implements Serializable {

	private static final Integer serialVersionUID = 1;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer numCelebrite;
	private String nom;
	private String prenom;
	private String nationalite;
	private String epoque;
	@ManyToMany
	@JoinTable(name = "AssocieA", joinColumns = @JoinColumn(name = "codeCelebrites"), inverseJoinColumns = @JoinColumn(name = "codeM"))
	private Collection<Monument> monuments;

	public Celebrite() {
		super();
	}

	public Celebrite(Integer numCelebrite, String nom, String prenom, String nationalite, String epoque) {
		super();
		this.numCelebrite = numCelebrite;
		this.nom = nom;
		this.prenom = prenom;
		this.nationalite = nationalite;
		this.epoque = epoque;
	}

	public Integer getNumCelebrite() {
		return numCelebrite;
	}

	public void setNumCelebrite(Integer numCelebrite) {
		this.numCelebrite = numCelebrite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public String getEpoque() {
		return epoque;
	}

	public void setEpoque(String epoque) {
		this.epoque = epoque;
	}

	public Collection<Monument> getMonuments() {
		return monuments;
	}

	public void setMonuments(List<Monument> monuments) {
		this.monuments = monuments;
	}

}
