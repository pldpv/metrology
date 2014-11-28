package ua.gov.uz.pldpv.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class InstrumentType extends UrlEntity {

	public InstrumentType() {
	}



	public InstrumentType(String instrumentType,
			InstrumentCategory instrumentCategory,
			Set<InstrumentModel> instrumentModel, SphereOfUse sphereOfUse) {
		this.instrumentType = instrumentType;
		this.instrumentCategory = instrumentCategory;
		this.instrumentModel = instrumentModel;
		this.sphereOfUse = sphereOfUse;
	}



	@Column
	private String instrumentType;

	@ManyToOne
	private InstrumentCategory instrumentCategory;
	
	@OneToMany(mappedBy = "instrumentType")
	Set<InstrumentModel> instrumentModel;
	
	@ManyToOne(fetch=FetchType.EAGER)
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



	public Set<InstrumentModel> getInstrumentModel() {
		return instrumentModel;
	}



	public void setInstrumentModel(Set<InstrumentModel> instrumentModel) {
		this.instrumentModel = instrumentModel;
	}
	
}
