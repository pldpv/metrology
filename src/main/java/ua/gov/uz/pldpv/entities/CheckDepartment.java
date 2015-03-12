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
			Set<InstrumentType> instrumentType, String certificatePath) {
		super(name, director, instruments, company);
		this.instrumentType = instrumentType;
		this.certificatePath = certificatePath;
	}

	@OneToMany(mappedBy="checkDepartment")
	private Set<InstrumentType> instrumentType;
	
	@Column
	private String certificatePath;

	public Set<InstrumentType> getInstrumentModel() {
		return instrumentType;
	}

	public void setInstrumentModel(Set<InstrumentType> instrumentType) {
		this.instrumentType = instrumentType;
	}

	public String getCertificatePath() {
		return certificatePath;
	}

	public void setCertificatePath(String certificatePath) {
		this.certificatePath = certificatePath;
	}
}
