package ua.gov.uz.pldpv.controllers;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.gov.uz.pldpv.config.SecurityUser;
import ua.gov.uz.pldpv.entities.Company;
import ua.gov.uz.pldpv.entities.Department;
import ua.gov.uz.pldpv.repositories.CompanyRepository;
import ua.gov.uz.pldpv.repositories.DepartmentRepository;
import ua.gov.uz.pldpv.repositories.RailwayServiceRepository;

@Controller
@RolesAllowed({"ADMIN","SERVICE_ADMIN","COMPANY_ADMIN"})
public class DepartmentController {
	@Autowired
	AccessConfirmationController accessConfirmation;
	@Autowired
	RailwayServiceRepository railwayServiceRepository;
	@Autowired
	CompanyRepository companyRepository;
	@Autowired
	DepartmentRepository departmentRepository;
	
	@RequestMapping(value = "/department", params = "add", method = RequestMethod.GET)
	public String getAddDepartment(
			@RequestParam("company_id") long companyId,
			Model model) {
		if (!accessConfirmation.accessConfirmation(companyId)) throw new AccessDeniedException("You have no permissions");
		model.addAttribute("company",
				companyRepository.findOne(companyId));
		return "admin/department/add";
	}
	
	@RequestMapping(value = "/department", params = "edit", method = RequestMethod.GET)
	public String getEditDepartment(@RequestParam long id, Model model) {
		
		Department department = departmentRepository.findOne(id);
		if(!accessConfirmation.accessConfirmation(department.getCompany().getId())) throw new AccessDeniedException("You have no permissions");
		
		model.addAttribute("department", department);
		return "admin/department/edit";
	}

	@RequestMapping(value = "/department", method = RequestMethod.GET)
	public String getViewDepartment(@RequestParam long id, Model model) {
		Department department=departmentRepository.findOne(id);
		if(!accessConfirmation.accessConfirmation(department.getCompany().getId())) throw new AccessDeniedException("You have no permissions");
		model.addAttribute("department", department);
		return "admin/department/view";
	}

	@RequestMapping(value = "/department", params = "add", method = RequestMethod.POST)
	public String postAddCompany(
			@RequestParam("company_id") long companyId,
			@RequestParam String name, @RequestParam String director,Authentication auth) {
		if(!accessConfirmation.accessConfirmation(companyId)) throw new AccessDeniedException("You have no permissions");
		Company company = companyRepository
				.findOne(companyId);
		Department department = new Department(name, director, null,
				company);
		department = departmentRepository.save(department);
		return "redirect:" + department.getUrl();
		
	}

	@RequestMapping(value = "/department", params = "edit", method = RequestMethod.POST)
	public String postEditCompany(@RequestParam long id,
			@RequestParam String name, @RequestParam String director) {
		Department department = departmentRepository.findOne(id);
		if(!accessConfirmation.accessConfirmation(department.getCompany().getId())) throw new AccessDeniedException("You have no permissions");
		department.setName(name);
		department.setDirector(director);
		department = departmentRepository.save(department);
		return "redirect:" + department.getUrl();
	}

	@RequestMapping(value = "/department", params = "delete", method = RequestMethod.POST)
	public String postDeleteCompany(@RequestParam long id) {
		Department department=departmentRepository.findOne(id);
		if(!accessConfirmation.accessConfirmation(department.getCompany().getId())) throw new AccessDeniedException("You have no permissions");
		departmentRepository.delete(department);
		return "redirect:"+department.getCompany().getUrl();
	}
}
