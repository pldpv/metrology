package ua.gov.uz.pldpv.controllers;

import javax.annotation.security.RolesAllowed;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RolesAllowed({"ADMIN"})
public class AdminController {
	
	
	@RequestMapping(value="/admin",method = RequestMethod.GET)
	public String getAdminPage() {
		return "admin/view";
	}
	@RequestMapping(value="/catalog",method = RequestMethod.GET)
	public String getCatalogPage() {
		return "admin/catalog";
	}
}
