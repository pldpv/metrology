package ua.gov.uz.pldpv.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class InstrumentType extends UrlEntity {

	public InstrumentType() {
	}

	public InstrumentType(String instrumentType,
			InstrumentCategory instrumentCategory, SphereOfUse sphereOfUse) {
		this.instrumentType = instrumentType;
		this.instrumentCategory = instrumentCategory;
		this.sphereOfUse = sphereOfUse;
	}

	@Column
	private String instrumentType;

	@ManyToOne
	private InstrumentCategory instrumentCategory;

	@ManyToOne
	private SphereOfUse sphereOfUse;

	public String getInstrumentType() {
		return instrumentType;
	}

	public void setInstrumentType(String instrumentType) {
		this.instrumentType = instrumentType;
	}

	public InstrumentCategory getInstrumentCategory() {
		return instrumentCategory;
	}

	public void setInstrumentCategory(InstrumentCategory instrumentCategory) {
		this.instrumentCategory = instrumentCategory;
	}

	public SphereOfUse getSphereOfUse() {
		return sphereOfUse;
	}

	public void setSphereOfUse(SphereOfUse sphereOfUse) {
		this.sphereOfUse = sphereOfUse;
	}
}
