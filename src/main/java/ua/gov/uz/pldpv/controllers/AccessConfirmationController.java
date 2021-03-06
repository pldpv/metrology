package ua.gov.uz.pldpv.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ua.gov.uz.pldpv.config.SecurityUser;
import ua.gov.uz.pldpv.entities.Company;
import ua.gov.uz.pldpv.entities.Department;
import ua.gov.uz.pldpv.entities.RailwayService;
import ua.gov.uz.pldpv.repositories.CompanyRepository;
import ua.gov.uz.pldpv.repositories.RailwayServiceRepository;

@Component
@Controller
class AccessConfirmationController {
	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private RailwayServiceRepository railawyServiceRepository;

	/**
	 * Check access level for authenticated user
	 * 
	 * @param companyId
	 *            - companyId from RequestParam
	 * @return true if authenticated User contains Company for Request companyId
	 */
	boolean accessConfirm(Company company) {
		SecurityUser user = getSecurityUser();
		String roleName = user.getRole().getRoleName();
		if (roleName.equals("ADMIN")) {
			return true;
		} else {
			return user.getRailwayService().getCompanies().contains(company);
		}
	}

	boolean accessConfirm(RailwayService railwayService) {
		SecurityUser user = getSecurityUser();
		String roleName = user.getRole().getRoleName();
		if (roleName.equals("ADMIN")) {
			return true;
		} else {
			return user.getRailwayService().equals(railwayService);
		}
	}

	boolean accessConfirm(Department department) {
		SecurityUser user = getSecurityUser();
		String roleName = user.getRole().getRoleName();
		if (roleName.equals("ADMIN")) {
			return true;
		} else {
			return user.getRailwayService().getCompanies()
					.contains(department.getCompany());
		}
	}

	/**
	 * Get List of RailwayService allowed to current authenticated user
	 * 
	 * @return List<Company> for authenticated User from database
	 */
	@RequestMapping(value="/usersRailwayServices",method = RequestMethod.GET)
	@ResponseBody List<RailwayService> getUsersRailwayServices() {
		List<RailwayService> list = new ArrayList<RailwayService>();
		SecurityUser user = getSecurityUser();
		String roleName = user.getRole().getRoleName();
		if (roleName.equals("ADMIN")) {
			return railawyServiceRepository.findAll();
		} else if (roleName.equals("SERVICE_ADMIN")) {
			list.add(user.getRailwayService());
		}
		return list;
	}

	/**
	 * Get List of Company allowed to current authenticated user
	 * 
	 * @return List<Company> for authenticated User from database
	 */
	@RequestMapping(value="/usersCompanies",method = RequestMethod.GET)
	@ResponseBody List<Company> getUserCompanies() {
		List<Company> list = new ArrayList<Company>();
		SecurityUser user = getSecurityUser();
		String roleName = user.getRole().getRoleName();
		if (roleName.equals("ADMIN")) {
			return companyRepository.findAll();
		} else if (roleName.equals("SERVICE_ADMIN")) {
			return user.getRailwayService().getCompanies();
		} else if (roleName.equals("COMPANY_ADMIN")) {
			list.add(user.getCompany());
		}
		return list;
	}

	/**
	 * Get List of Departments allowed to current authenticated user
	 * 
	 * @return List<Department> for authenticated User from database
	 */
	@RequestMapping(value="/usersDepartments",method = RequestMethod.GET)
	@ResponseBody List<Department> getUsersDepartments() {
		List<Department> list = new ArrayList<Department>();
		for (Company c : getUserCompanies()) {
			list.addAll(c.getDepartments());
		}
		return list;
	}

	private static SecurityUser getSecurityUser() {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		return (SecurityUser) auth.getPrincipal();
	}
}
