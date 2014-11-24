package ua.gov.uz.pldpv.entities;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Verification extends CheckInstrument {

	public Verification() {
	}

	public Verification(Organization organization, Date currentCheck,
			Integer periodicity, Date nextCheck, Float actualCost) {
		super(organization, currentCheck, periodicity, nextCheck, actualCost);
	}

	
}
