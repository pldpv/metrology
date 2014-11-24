package ua.gov.uz.pldpv.controllers;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.gov.uz.pldpv.entities.SphereOfUse;
import ua.gov.uz.pldpv.repositories.SphereOfUseRepository;

@Controller
@RolesAllowed({"ADMIN"})
public class SphereOfUseController {
	@Autowired
	SphereOfUseRepository sphereOfUseRepository;
	
	@RequestMapping(value = "/sphereofuse", params = "list", method = RequestMethod.GET)
	public String getSphereOfUseList(Model model) {
		model.addAttribute("spheresOfUse",
				sphereOfUseRepository.findAll());
		return "admin/instrument/sphereofuse/list";
	}
	
	@RequestMapping(value="sphereofuse",params="add",method=RequestMethod.GET)
	public String getAddSphereOfUse(){
		return "admin/instrument/sphereofuse/add";
	}
	
	@RequestMapping(value = "/sphereofuse", params = "edit", method = RequestMethod.GET)
	public String getEditSphereOfUse(@RequestParam long id,Model model) {
		SphereOfUse sphereOfUse=sphereOfUseRepository.findOne(id);
		model.addAttribute("sphereOfUse", sphereOfUse);
		return "admin/instrument/sphereofuse/edit";
	}
	
	@RequestMapping(value = "/sphereofuse", params = "add", method = RequestMethod.POST)
	public String postAddSphereOfUse(@RequestParam String sphere) {
		SphereOfUse sphereOfUse=new SphereOfUse(sphere,null);
		sphereOfUse = sphereOfUseRepository.save(sphereOfUse);
		return "redirect:sphereofuse?list";
	}
	
	@RequestMapping(value = "/sphereofuse", params = "edit", method = RequestMethod.POST)
	public String postEditSphereOfUse(@RequestParam long id,@RequestParam String sphere) {
		SphereOfUse sphereOfUse = sphereOfUseRepository.findOne(id);
		sphereOfUse.setSphereOfUse(sphere);
		sphereOfUse = sphereOfUseRepository.save(sphereOfUse);
		return "redirect:sphereofuse?list";
	}
	
	@RequestMapping(value = "/sphereofuse", params = "delete", method = RequestMethod.POST)
	public String postSphereOfUse(@RequestParam long id) {
		sphereOfUseRepository.delete(id);
		return "redirect:sphereofuse?list";
	}
}
