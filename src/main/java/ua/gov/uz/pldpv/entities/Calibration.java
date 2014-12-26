package ua.gov.uz.pldpv.entities;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Calibration extends CheckInstrument {

	public Calibration(Object organization, Date currentCheck,
			Integer periodicity, Date nextCheck, Float actualCost,
			String paymentInformation, String imagePath, Instrument instrument) {
		super(organization, currentCheck, periodicity, nextCheck, actualCost,
				paymentInformation, imagePath, instrument);

	}

	public Calibration() {
	}

}
