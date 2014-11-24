package ua.gov.uz.pldpv.entities;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Calibration extends CheckInstrument{

	public Calibration(Organization organization, Date currentCheck,
			Integer periodicity, Date nextCheck, Float actualCost) {
		super(organization, currentCheck, periodicity, nextCheck, actualCost);
	}

	public Calibration() {
	}

	
}
