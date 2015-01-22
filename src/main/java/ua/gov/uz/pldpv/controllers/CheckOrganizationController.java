package ua.gov.uz.pldpv.controllers;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.gov.uz.pldpv.entities.Organization;
import ua.gov.uz.pldpv.repositories.CheckOrganizationRepository;

@Controller
@RolesAllowed({ "ADMIN", "SERVICE_ADMIN" })
@RequestMapping("/organization")
public class CheckOrganizationController {
	@Autowired
	CheckOrganizationRepository checkOrganizationRepository;

	@RequestMapping(params = "list", method = RequestMethod.GET)
	public String getCheckOrganizationList(Model model) {
		model.addAttribute("organizations",
				checkOrganizationRepository.findAll());
		return "admin/instrument/organization/list";
	}

	@RequestMapping(params = "add", method = RequestMethod.GET)
	public String getAddCheckOrganization() {
		return "admin/instrument/organization/add";
	}

	@RequestMapping(params = "add", method = RequestMethod.POST)
	public String postAddCheckOrganization(@RequestParam String name,
			@RequestParam Integer checkType) {
		Organization checkOrganization = new Organization(name, checkType, null);
		checkOrganization = checkOrganizationRepository.save(checkOrganization);
		return "redirect:organization?list";
	}

	@RequestMapping(params = "edit", method = RequestMethod.GET)
	public String getEditCheckOrganization(@RequestParam long id, Model model) {
		Organization checkOrganization = checkOrganizationRepository
				.findOne(id);
		model.addAttribute("organization", checkOrganization);
		return "admin/instrument/organization/edit";
	}

	@RequestMapping(params = "edit", method = RequestMethod.POST)
	public String postEditCheckOrganization(@RequestParam long id,
			@RequestParam String name, @RequestParam Integer checkType) {
		Organization checkOrganization = checkOrganizationRepository
				.findOne(id);
		checkOrganization.setName(name);
		checkOrganization.setCheckType(checkType);
		checkOrganization = checkOrganizationRepository.save(checkOrganization);
		return "redirect:organization?list";
	}

	@RequestMapping(params = "delete", method = RequestMethod.POST)
	public String postCheckOrganization(@RequestParam long id) {
		checkOrganizationRepository.delete(id);
		return "redirect:organization?list";
	}
}
