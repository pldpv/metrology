/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.gov.uz.pldpv.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.gov.uz.pldpv.entities.Company;
import ua.gov.uz.pldpv.entities.RailwayService;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
