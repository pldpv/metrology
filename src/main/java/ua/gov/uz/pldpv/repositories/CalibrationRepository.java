/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.uz.pldpv.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.gov.uz.pldpv.entities.Calibration;

public interface CalibrationRepository extends JpaRepository<Calibration, Long> {
	
}
