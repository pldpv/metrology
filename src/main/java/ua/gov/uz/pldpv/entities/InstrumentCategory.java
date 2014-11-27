package ua.gov.uz.pldpv.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class InstrumentCategory extends UrlEntity {

	public InstrumentCategory() {
	}

	public InstrumentCategory(String category,
			Set<InstrumentType> instrumentType) {
		this.category = category;
		this.instrumentType = instrumentType;
	}

	@Column
	private String category;
	@OneToMany(mappedBy = "instrumentCategory")
	private Set<InstrumentType> instrumentType;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Set<InstrumentType> getInstrumentType() {
		return instrumentType;
	}

	public void setInstrumentType(Set<InstrumentType> instrumentType) {
		this.instrumentType = instrumentType;
	}

	public String getSphereOfUse() {
		return category;
	}

	public void setSphereOfUse(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return getId() + " - " + getCategory();
	}

}
