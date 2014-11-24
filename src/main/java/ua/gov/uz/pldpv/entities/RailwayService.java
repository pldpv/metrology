package ua.gov.uz.pldpv.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class RailwayService extends UrlEntity {
	
	@Column(nullable=false)
	@NotBlank
	private String name;
	
	@Column(nullable=false)
	@NotBlank
	private String director;

	@OneToMany(mappedBy = "railwayService", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Company> companies;

	public RailwayService() {
	}

	public RailwayService(String name, String director, Set<Company> companies) {
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

	public Set<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(Set<Company> companies) {
		this.companies = companies;
	}
}
