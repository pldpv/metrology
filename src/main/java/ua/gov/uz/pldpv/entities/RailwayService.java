package ua.gov.uz.pldpv.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class RailwayService extends UrlEntity {
	
	@Column(nullable=false)
	@NotBlank
	private String name;

	@Column(nullable=false)
	@NotBlank
	private String director;

	@OneToMany(mappedBy = "railwayService",cascade=CascadeType.ALL, orphanRemoval = true)
	private List<Company> companies;
	
	@OneToMany(mappedBy = "railwayService",cascade=CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private Set<User> users;
	
	public RailwayService() {
	}

	public RailwayService(String name, String director, List<Company> companies) {
		this.name = name;
		this.director = director;
		this.companies = companies;
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

	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
}
