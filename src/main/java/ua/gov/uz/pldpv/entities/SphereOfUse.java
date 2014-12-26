package ua.gov.uz.pldpv.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class SphereOfUse extends BaseEntity {

	public SphereOfUse() {
	}

	public SphereOfUse(String sphereOfUse, Set<InstrumentType> instrumenType) {
		this.sphereOfUse = sphereOfUse;
		this.instrumenType = instrumenType;
	}

	@Column
	private String sphereOfUse;

	@OneToMany(mappedBy = "sphereOfUse", fetch = FetchType.EAGER)
	private Set<InstrumentType> instrumenType;

	public String getSphereOfUse() {
		return sphereOfUse;
	}

	public void setSphereOfUse(String sphereOfUse) {
		this.sphereOfUse = sphereOfUse;
	}

	public Set<InstrumentType> getInstrumenType() {
		return instrumenType;
	}

	public void setInstrumenType(Set<InstrumentType> instrumenType) {
		this.instrumenType = instrumenType;
	}

}
