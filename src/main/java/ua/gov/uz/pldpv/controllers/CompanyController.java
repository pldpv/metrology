package ua.gov.uz.pldpv.controllers;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.gov.uz.pldpv.entities.Company;
import ua.gov.uz.pldpv.entities.RailwayService;
import ua.gov.uz.pldpv.repositories.CompanyRepository;
import ua.gov.uz.pldpv.repositories.RailwayServiceRepository;

@Controller
@RolesAllowed({"ADMIN","SERVICE_ADMIN"})
@RequestMapping("/company")
public class CompanyController {
	@Autowired
	AccessConfirmationController accessConfirmation;
	@Autowired
	RailwayServiceRepository railwayServiceRepository;
	@Autowired
	CompanyRepository companyRepository;
	
	@RequestMapping(params = "add", method = RequestMethod.GET)
	public String getAddCompany(
			@RequestParam("railwayService_id") long railwayServiceId,
			Model model) {
		RailwayService railwayService = railwayServiceRepository
				.findOne(railwayServiceId);
		if (!accessConfirmation.accessConfirm(railwayService)) throw new AccessDeniedException("You have no permissions");
		model.addAttribute("railwayService",railwayService);
		return "admin/company/add";
	}
	
	@RequestMapping(params = "edit", method = RequestMethod.GET)
	public String getEditCompany(@RequestParam long id, Model model) {
		Company company = companyRepository.findOne(id);
		if (!accessConfirmation.accessConfirm(company)) throw new AccessDeniedException("You have no permissions");
		model.addAttribute("company", company);
		return "admin/company/edit";
	}
	@RolesAllowed({"ADMIN","SERVICE_ADMIN","COMPANY_ADMIN"})
	@RequestMapping(method = RequestMethod.GET)
	public String getViewCompany(@RequestParam long id, Model model) {
		Company company=companyRepository.findOne(id);
		if (!accessConfirmation.accessConfirm(company)) throw new AccessDeniedException("You have no permissions");
		model.addAttribute("company",company );
		return "admin/company/view";
	}

	@RequestMapping(params = "add", method = RequestMethod.POST)
	public String postAddCompany(
			@RequestParam("railwayService_id") long railwayServiceId,
			@RequestParam String name, @RequestParam String director) {
		RailwayService railwayService = railwayServiceRepository
				.findOne(railwayServiceId);
		if (!accessConfirmation.accessConfirm(railwayService)) throw new AccessDeniedException("You have no permissions");
		Company company = new Company(name, director, null, null,
				railwayService);
		company = companyRepository.save(company);
		return  "redirect:"+company.getRailwayService().getUrl();
	}

	@RequestMapping(params = "edit", method = RequestMethod.POST)
	public String postEditCompany(@RequestParam long id,
			@RequestParam String name, @RequestParam String director) {
		Company company = companyRepository.findOne(id);
		if (!accessConfirmation.accessConfirm(company)) throw new AccessDeniedException("You have no permissions");
		company.setName(name);
		company.setDirector(director);
		company = companyRepository.save(company);
		return "redirect:" + company.getUrl();
	}

	@RequestMapping(params = "delete", method = RequestMethod.POST)
	public String postDeleteCompany(@RequestParam long id) {
		Company company=companyRepository.findOne(id);
		if (!accessConfirmation.accessConfirm(company)) throw new AccessDeniedException("You have no permissions");
		companyRepository.delete(id);
		return "redirect:"+company.getRailwayService().getUrl();
	}
}
