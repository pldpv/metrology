package ua.gov.uz.pldpv.entities;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Any;
import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.MetaValue;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class CheckInstrument extends BaseEntity {

	public CheckInstrument() {
	}

	public CheckInstrument(Object organization, Date currentCheck,
			Integer periodicity, Date nextCheck, Float actualCost,
			String paymentInformation, String imagePath, Instrument instrument) {

		this.organization = organization;
		this.currentCheck = currentCheck;
		this.periodicity = periodicity;
		this.actualCost = actualCost;
		this.paymentInformation = paymentInformation;
		this.imagePath = imagePath;
		this.instrument = instrument;
        nextCheckCalculation();
	}

	@Any(metaColumn = @Column(name = "organization"))
	@AnyMetaDef(idType = "long", metaType = "string", metaValues = {
			//@MetaValue(targetEntity = CheckDepartment.class, value = "D"),
			@MetaValue(targetEntity = Organization.class, value = "O"), })
	@JoinColumn(name = "organization_id")
	private Object organization;

	@Column(nullable = false)
	@NotBlank
	private Date currentCheck;

	@Column(nullable = false)
	private Integer periodicity;

	@Column(nullable = false)
	private Date nextCheck;

	@Column(nullable = false)
	private Float actualCost;

	@Column
	private String paymentInformation;

	@Column
	private String imagePath;
	
	@ManyToOne
	private Instrument instrument;

	public Object getOrganization() {
		return organization;
	}

	public void setOrganization(Object organization) {
		this.organization = organization;
	}

	public Date getCurrentCheck() {
		return currentCheck;
	}

	public void setCurrentCheck(Date currentCheck) {
		this.currentCheck = currentCheck;
		nextCheckCalculation();
	}

	public Integer getPeriodicity() {
		return periodicity;
	}

	public void setPeriodicity(Integer periodicity) {
		this.periodicity = periodicity;
		nextCheckCalculation();
	}

	public Date getNextCheck() {
		return nextCheck;
	}

	private void setNextCheck(Date nextCheck) {
		this.nextCheck = nextCheck;
	}

	public Float getActualCost() {
		return actualCost;
	}

	public void setActualCost(Float actualCost) {
		this.actualCost = actualCost;
	}

	private void nextCheckCalculation() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(currentCheck);
		cal.add(Calendar.MONTH, periodicity);
		setNextCheck(cal.getTime());
	}

	public String getPaymentInformation() {
		return paymentInformation;
	}

	public void setPaymentInformation(String paymentInformation) {
		this.paymentInformation = paymentInformation;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

}
