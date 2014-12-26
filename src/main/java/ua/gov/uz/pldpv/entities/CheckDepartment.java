package ua.gov.uz.pldpv.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
@Entity
public class CheckDepartment extends Department {

	public CheckDepartment() {
	}

	public CheckDepartment(String name, String director,
			Set<Instrument> instruments, Company company,
			Set<InstrumentModel> instrumentModel, String certificatePath) {
		super(name, director, instruments, company);
		this.instrumentModel = instrumentModel;
		this.certificatePath = certificatePath;
	}

	@OneToMany
	private Set<InstrumentModel> instrumentModel;
	
	@Column
	private String certificatePath;

	public Set<InstrumentModel> getInstrumentModel() {
		return instrumentModel;
	}

	public void setInstrumentModel(Set<InstrumentModel> instrumentModel) {
		this.instrumentModel = instrumentModel;
	}

	public String getCertificatePath() {
		return certificatePath;
	}

	public void setCertificatePath(String certificatePath) {
		this.certificatePath = certificatePath;
	}
}
