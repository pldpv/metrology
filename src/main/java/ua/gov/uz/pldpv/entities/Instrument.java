package ua.gov.uz.pldpv.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Instrument extends BaseEntity {
	public Instrument() {
	}

	public Instrument(Long serialNumber, Date receiptDate, String location,
			Date productionYear, String instrumentModel, Department department,
			InstrumentType instrumentType, Calibration calibration,
			Verification verification, TechnicalState technicalState) {
		this.serialNumber = serialNumber;
		this.receiptDate = receiptDate;
		this.location = location;
		this.productionYear = productionYear;
		this.instrumentModel = instrumentModel;
		this.department = department;
		this.instrumentType = instrumentType;
		this.calibration = calibration;
		this.verification = verification;
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
	@ManyToOne
	private Department department;

	@ManyToOne
	private InstrumentType instrumentType;
	@ManyToOne
	private Calibration calibration;
	@ManyToOne
	private Verification verification;
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

	public Calibration getCalibration() {
		return calibration;
	}

	public void setCalibration(Calibration calibration) {
		this.calibration = calibration;
	}

	public Verification getVerification() {
		return verification;
	}

	public void setVerification(Verification verification) {
		this.verification = verification;
	}

	public TechnicalState getTechnicalState() {
		return technicalState;
	}

	public void setTechnicalState(TechnicalState technicalState) {
		this.technicalState = technicalState;
	}

}
