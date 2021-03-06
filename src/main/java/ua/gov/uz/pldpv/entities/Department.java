package ua.gov.uz.pldpv.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Department extends UrlEntity {

	@Column(nullable = false)
	@NotBlank
	private String name;

	@Column(nullable = false)
	@NotBlank
	private String director;

	@OneToMany(mappedBy = "department", cascade=CascadeType.ALL, orphanRemoval = true)
	private Set<Instrument> instruments;

	@ManyToOne(optional= false)
	@JsonIgnore
	private Company company;

	public Department() {
	}

	public Department(String name, String director,
			Set<Instrument> instruments, Company company) {
		this.name = name;
		this.director = director;
		this.instruments = instruments;
		this.company = company;
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

	public Set<Instrument> getInstruments() {
		return instruments;
	}

	public void setInstruments(Set<Instrument> instruments) {
		this.instruments = instruments;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}
