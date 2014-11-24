package ua.gov.uz.pldpv.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Organization extends BaseEntity {

	public Organization() {
	}
	public Organization(String name, Integer checkType,
			Set<CheckInstrument> checkInstrument) {
		this.name = name;
		this.checkType = checkType;
		this.checkInstrument = checkInstrument;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Column
	private String name;
	/**
	 * if checkType=0 =>organization can Calibrate instrument
	 * if checkType=1 =>organization can Verificate instrument
	 * if checkType=2 =>organization can both Calibrate and Verificate instrument
	 */
	@Column
	private Integer checkType;
	@OneToMany(mappedBy = "organization")
	private Set<CheckInstrument> checkInstrument;

	public Integer getCheckType() {
		return checkType;
	}
	public void setCheckType(Integer checkType) {
		this.checkType = checkType;
	}
	public Set<CheckInstrument> getCheckInstrument() {
		return checkInstrument;
	}
	public void setCheckInstrument(Set<CheckInstrument> checkInstrument) {
		this.checkInstrument = checkInstrument;
	}


}
