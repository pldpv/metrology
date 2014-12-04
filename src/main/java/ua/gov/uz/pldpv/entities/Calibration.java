package ua.gov.uz.pldpv.entities;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Calibration extends CheckInstrument{


	public Calibration(Organization organization, Date currentCheck,
			Integer periodicity, Float actualCost,
			String paymentInformation) {
		super(organization, currentCheck, periodicity, actualCost,
				paymentInformation);
		// TODO Auto-generated constructor stub
	}

	public Calibration() {
	}

}
