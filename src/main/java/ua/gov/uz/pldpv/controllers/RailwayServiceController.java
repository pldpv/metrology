package ua.gov.uz.pldpv.controllers;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.gov.uz.pldpv.entities.RailwayService;
import ua.gov.uz.pldpv.repositories.RailwayServiceRepository;

@Controller
@RolesAllowed({"ADMIN"})
@RequestMapping("railwayservice")
public class RailwayServiceController {
	
	@Autowired
	RailwayServiceRepository railwayServiceRepository;
	
	@RequestMapping(params = "list", method = RequestMethod.GET)
	public String getRailwayServiceList(Model model) {
		model.addAttribute("railwayServices",
				railwayServiceRepository.findAll());
		return "admin/railwayService/list";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String getViewRailwayService(@RequestParam long id, Model model) {
		model.addAttribute("railwayService", railwayServiceRepository.findOne(id));
		return "admin/railwayService/view";
	}
	
	@RequestMapping(params = "add", method = RequestMethod.GET)
	public String getAddRailwayService() {
		return "admin/railwayService/add";
	}
	
	@RequestMapping(params = "edit", method = RequestMethod.GET)
	public String getEditRailwayService(@RequestParam long id,Model model) {
		RailwayService railwayService=railwayServiceRepository.findOne(id);
		model.addAttribute("railwayService", railwayService);
		return "admin/railwayService/edit";
	}
	
	@RequestMapping(params = "add", method = RequestMethod.POST)
	public String postAddRailwayService(@RequestParam String name,@RequestParam String director) {
		RailwayService railwayService = new RailwayService(name,director, null);
		railwayService = railwayServiceRepository.save(railwayService);
		return "redirect:"+railwayService.getUrl();
	}
	
	@RequestMapping(params = "edit", method = RequestMethod.POST)
	public String postEditRailwayService(@RequestParam long id,@RequestParam String name,@RequestParam String director) {
		RailwayService railwayService = railwayServiceRepository.findOne(id);
		railwayService.setName(name);
		railwayService.setDirector(director);
		railwayService = railwayServiceRepository.save(railwayService);
		return "redirect:"+railwayService.getUrl();
	}
	
	@RequestMapping(params = "delete", method = RequestMethod.POST)
	public String postDeleteRailwayService(@RequestParam long id) {
		railwayServiceRepository.delete(id);
		return "redirect:railwayservice?list";
	}
}
