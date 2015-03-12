package ua.gov.uz.pldpv.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

@Entity
public class Instrument extends BaseEntity {
	public Instrument() {
	}

	public Instrument(Long serialNumber, Date receiptDate, String location,
			Date productionYear, String instrumentModel, Department department,
			InstrumentType instrumentType,
			Set<CheckInstrument> instrumentCheck, TechnicalState technicalState) {
		super();
		this.serialNumber = serialNumber;
		this.receiptDate = receiptDate;
		this.location = location;
		this.productionYear = productionYear;
		this.instrumentModel = instrumentModel;
		this.department = department;
		this.instrumentType = instrumentType;
		this.instrumentCheck = instrumentCheck;
		this.technicalState = technicalState;
	}
	@Column
	private Long serialNumber;
	@Column
	private Date receiptDate;
	@Column
	private String location;
	@Column
	private Date productionYear;
	@Column
	private String instrumentModel;
	
	@ManyToOne(optional=false)
	private Department department;

	@ManyToOne
	private InstrumentType instrumentType;
	
	@OneToMany(mappedBy="instrument",fetch =FetchType.EAGER)
	@OrderColumn(name="currentCheck")
	private Set<CheckInstrument> instrumentCheck;
	
	@ManyToOne
	private TechnicalState technicalState;

	public Long getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(Long serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Date getReceiptDate() {
		return receiptDate;
	}

	public void setReceiptDate(Date receiptDate) {
		this.receiptDate = receiptDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(Date productionYear) {
		this.productionYear = productionYear;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public InstrumentType getInstrumentType() {
		return instrumentType;
	}

	public void setInstrumentModel(InstrumentType instrumentType) {
		this.instrumentType = instrumentType;
	}

	
	public TechnicalState getTechnicalState() {
		return technicalState;
	}

	public void setTechnicalState(TechnicalState technicalState) {
		this.technicalState = technicalState;
	}

	public String getInstrumentModel() {
		return instrumentModel;
	}

	public void setInstrumentModel(String instrumentModel) {
		this.instrumentModel = instrumentModel;
	}



	public void setInstrumentType(InstrumentType instrumentType) {
		this.instrumentType = instrumentType;
	}

	public Set<CheckInstrument> getInstrumentCheck() {
		return instrumentCheck;
	}

	public void setInstrumentCheck(Set<CheckInstrument> instrumentCheck) {
		this.instrumentCheck = instrumentCheck;
	}

}
