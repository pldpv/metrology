package ua.gov.uz.pldpv.controllers;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.gov.uz.pldpv.entities.InstrumentCategory;
import ua.gov.uz.pldpv.entities.InstrumentType;
import ua.gov.uz.pldpv.entities.SphereOfUse;
import ua.gov.uz.pldpv.repositories.InstrumentCategoryRepository;
import ua.gov.uz.pldpv.repositories.InstrumentTypeRepository;
import ua.gov.uz.pldpv.repositories.SphereOfUseRepository;

@Controller
@RolesAllowed({"ADMIN"})
@RequestMapping("instrumenttype")
public class InstrumentTypeController {
	@Autowired
	InstrumentCategoryRepository instrumentCategoryRepository;
	@Autowired
	InstrumentTypeRepository instrumentTypeRepository;
	@Autowired
	SphereOfUseRepository sphereOfUseRepository;
	
	@RequestMapping(params="list",method=RequestMethod.GET)
	public String getInstrumentTypeList(Model model){
		model.addAttribute("instrumentTypes",instrumentTypeRepository.findAll());
		return "admin/instrument/category/list";
	}
	@RequestMapping(params="add",method=RequestMethod.GET)
	public String getAddInstrumentType(@RequestParam("category_id") Long categoryId,Model model){
		model.addAttribute("instrumentCategory", instrumentCategoryRepository.findOne(categoryId));
		model.addAttribute("spheresOfUse",sphereOfUseRepository.findAll());
		return "admin/instrument/type/add";
	}
	@RequestMapping(method=RequestMethod.GET)
	public String getViewInstrumentType(@RequestParam Long id,Model model){
		model.addAttribute("instrumentType",instrumentTypeRepository.findOne(id));
		return "admin/instrument/type/view";
	}
	
	@RequestMapping(params = "edit", method = RequestMethod.GET)
	public String getEditInstrumentType(@RequestParam long id,Model model) {
		model.addAttribute("instrumentType", instrumentTypeRepository.findOne(id));
		model.addAttribute("spheresOfUse",sphereOfUseRepository.findAll());
		return "admin/instrument/type/edit";
	}
	
	@RequestMapping(params = "add", method = RequestMethod.POST)
	public String postAddInstrumentType(@RequestParam Long categoryId,@RequestParam String type,@RequestParam("sphereofuse_id") Long sphereOfUseId) {
		InstrumentCategory instrumentCategory=instrumentCategoryRepository.findOne(categoryId);
		SphereOfUse sphereOfUse=sphereOfUseRepository.findOne(sphereOfUseId);
		InstrumentType instrumentType = new InstrumentType(type,instrumentCategory,null,sphereOfUse);
		instrumentType = instrumentTypeRepository.save(instrumentType);
		return "redirect:"+instrumentType.getUrl();
	}
	
	@RequestMapping(params = "edit", method = RequestMethod.POST)
	public String postEditInstrumentType(@RequestParam long id,@RequestParam String type,@RequestParam("sphereofuse_id") Long sphereOfUseId) {
		InstrumentType instrumentType = instrumentTypeRepository.findOne(id);
		instrumentType.setInstrumentType(type);
		instrumentType.setSphereOfUse(sphereOfUseRepository.findOne(sphereOfUseId));
		instrumentType = instrumentTypeRepository.save(instrumentType);
		return "redirect:"+instrumentType.getUrl();
	}
	
	@RequestMapping(params = "delete", method = RequestMethod.POST)
	public String postDeleteInstrumentType(@RequestParam long id) {
		instrumentTypeRepository.delete(id);
		return "redirect:instrumentcategory?list";
	}
}
