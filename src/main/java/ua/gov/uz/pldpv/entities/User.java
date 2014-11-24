package ua.gov.uz.pldpv.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class User extends BaseEntity {
	@Column
	private String userName;

	@Column
	private String password;

	@Column
	private Boolean isEnabled;

	@ManyToOne(optional=false)
	private Role role;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "company_id")
	private Company company;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "railwayService_id")
	private RailwayService railwayService;

	public Company getCompany() {
		return company;
	}

	public RailwayService getRailwayService() {
		return railwayService;
	}

	public void setRailwayService(RailwayService railwayService) {
		this.railwayService = railwayService;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String username) {
		this.userName = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role userRole) {
		this.role = userRole;
	}

	public User() {
	}

}
