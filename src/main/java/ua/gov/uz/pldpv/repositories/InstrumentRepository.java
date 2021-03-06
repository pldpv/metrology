/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.uz.pldpv.repositories;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.gov.uz.pldpv.entities.Department;
import ua.gov.uz.pldpv.entities.Instrument;

public interface InstrumentRepository extends JpaRepository<Instrument, Long> {
	
	List<Instrument> findByDepartmentIn(Collection<Department> department);
	
}
