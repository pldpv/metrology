package ua.gov.uz.pldpv.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class DepatrmentUnit {
	@Id
	private Long id;
	@Column
	private String name;
	private String director;
	@ManyToOne
	DepatrmentUnit company;
	@ManyToOne
	DepatrmentUnit service;
	
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
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public DepatrmentUnit getService() {
		return service;
	}
	public void setService(DepatrmentUnit service) {
		this.service = service;
	}
	public DepatrmentUnit getCompany() {
		return company;
	}
	public void setCompany(DepatrmentUnit company) {
		this.company = company;
	}
	public DepatrmentUnit(){}
	public DepatrmentUnit(Long id, String name, String director,
			DepatrmentUnit company, DepatrmentUnit service) {
		super();
		this.id = id;
		this.name = name;
		this.director = director;
		this.company = company;
		this.service = service;
	}
	
}
