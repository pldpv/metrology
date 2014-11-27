package ua.gov.uz.pldpv.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class InstrumentModel extends UrlEntity {
	@Column
	private String instrumentModel;
	
	@ManyToOne
	private InstrumentType instrumentType;

	public InstrumentModel() {
		
	}

	public InstrumentModel(String instrumentModel, InstrumentType instrumentType) {
		this.instrumentModel = instrumentModel;
		this.instrumentType = instrumentType;
	}

	public String getInstrumentModel() {
		return instrumentModel;
	}

	public void setInstrumentModel(String instrumentModel) {
		this.instrumentModel = instrumentModel;
	}

	public InstrumentType getInstrumentType() {
		return instrumentType;
	}

	public void setInstrumentType(InstrumentType instrumentType) {
		this.instrumentType = instrumentType;
	}
	@Override
	public String toString() {
		return instrumentModel;
	}
}
