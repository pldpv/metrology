package ua.gov.uz.pldpv.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class TechnicalState extends BaseEntity {
	public TechnicalState() {
	}

	public TechnicalState(String technicalState, Set<Instrument> instrument) {
		this.technicalState = technicalState;
		this.instrument = instrument;
	}

	@Column
	private String technicalState;
	
	@OneToMany(mappedBy = "technicalState")
	private Set<Instrument> instrument;

	public String getTechnicalState() {
		return technicalState;
	}

	public void setTechnicalState(String technicalState) {
		this.technicalState = technicalState;
	}

	public Set<Instrument> getInstrument() {
		return instrument;
	}

	public void setInstrument(Set<Instrument> instrument) {
		this.instrument = instrument;
	}
}
