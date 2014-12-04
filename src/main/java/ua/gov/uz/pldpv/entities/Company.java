package ua.gov.uz.pldpv.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Company extends UrlEntity {
	
	@Column(nullable=false)
	@NotBlank
	private String name;
	
	@Column(nullable=false)
	@NotBlank
	private String director;
	
	@OneToMany(mappedBy = "company",fetch=FetchType.EAGER,cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Department> departments;
	
	@OneToMany(mappedBy = "company",cascade = CascadeType.ALL)
	private Set<User> users;
	
	@ManyToOne(optional = false)
	private RailwayService railwayService;

	public Company() {
	}

	public Company(String name, String director, Set<Department> departments,
			Set<User> users, RailwayService railwayService) {
		this.name = name;
		this.director = director;
		this.departments = departments;
		this.users = users;
		this.railwayService = railwayService;
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

	public Set<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(Set<Department> departments) {
		this.departments = departments;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public RailwayService getRailwayService() {
		return railwayService;
	}

	public void setRailwayService(RailwayService railwayService) {
		this.railwayService = railwayService;
	}

}
