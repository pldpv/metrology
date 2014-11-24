package ua.gov.uz.pldpv.controllers;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.gov.uz.pldpv.entities.InstrumentCategory;
import ua.gov.uz.pldpv.repositories.InstrumentCategoryRepository;

@Controller
@RolesAllowed({"ADMIN"})
public class CategoryController {
	@Autowired
	InstrumentCategoryRepository instrumentCategoryRepository;
	
	@RequestMapping(value="instrumentcategory",params="list",method=RequestMethod.GET)
	public String getInstrumentCategoryList(Model model){
		model.addAttribute("instrumentCategories",instrumentCategoryRepository.findAll());
		return "admin/instrument/category/list";
	}
	@RequestMapping(value="instrumentcategory",params="add",method=RequestMethod.GET)
	public String getAddInstrumentCategory(){
		return "admin/instrument/category/add";
	}
	@RequestMapping(value="instrumentcategory",method=RequestMethod.GET)
	public String getViewInstrumentCategory(@RequestParam Long id,Model model){
		model.addAttribute("instrumentCategory",instrumentCategoryRepository.findOne(id));
		return "admin/instrument/category/view";
	}
	@RequestMapping(value = "/instrumentcategory", params = "edit", method = RequestMethod.GET)
	public String getEditInstrumentCategory(@RequestParam long id,Model model) {
		InstrumentCategory instrumentCategory=instrumentCategoryRepository.findOne(id);
		model.addAttribute("instrumentCategory", instrumentCategory);
		return "admin/instrument/category/edit";
	}
	
	@RequestMapping(value = "/instrumentcategory", params = "add", method = RequestMethod.POST)
	public String postAddInstrumentCategory(@RequestParam Long id,@RequestParam String category) {
		InstrumentCategory instrumentCategory = new InstrumentCategory(category,null);
		instrumentCategory.setId(id);
		instrumentCategory = instrumentCategoryRepository.save(instrumentCategory);
		return "redirect:"+instrumentCategory.getUrl();
	}
	
	@RequestMapping(value = "/instrumentcategory", params = "edit", method = RequestMethod.POST)
	public String postEditInstrumentCategory(@RequestParam long id,@RequestParam String category) {
		InstrumentCategory instrumentCategory = instrumentCategoryRepository.findOne(id);
		instrumentCategory.setCategory(category);
		instrumentCategory = instrumentCategoryRepository.save(instrumentCategory);
		return "redirect:"+instrumentCategory.getUrl();
	}
	
	@RequestMapping(value = "/instrumentcategory", params = "delete", method = RequestMethod.POST)
	public String postDeleteInstrumentCategory(@RequestParam long id) {
		instrumentCategoryRepository.delete(id);
		return "redirect:instrumentcategory?list";
	}
	
}
