package ua.gov.uz.pldpv.controllers;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.gov.uz.pldpv.entities.InstrumentModel;
import ua.gov.uz.pldpv.entities.InstrumentType;
import ua.gov.uz.pldpv.repositories.InstrumentModelRepository;
import ua.gov.uz.pldpv.repositories.InstrumentTypeRepository;
import ua.gov.uz.pldpv.repositories.SphereOfUseRepository;
@Controller
@RolesAllowed("ADMIN")
public class InstrumentModelController {
	@Autowired
	InstrumentTypeRepository instrumentTypeRepository;
	@Autowired
	InstrumentModelRepository instrumentModelRepository;
	@Autowired
	SphereOfUseRepository sphereOfUseRepository;
	
	
	@RequestMapping(value="instrumentmodel",params="add",method=RequestMethod.GET)
	public String getAddInstrumentModel(@RequestParam("type_id") Long typeId,Model model){
		model.addAttribute("instrumentType", instrumentTypeRepository.findOne(typeId));
		return "admin/instrument/model/add";
	}
	@RequestMapping(value="instrumentmodel",method=RequestMethod.GET)
	public String getViewInstrumentModel(@RequestParam Long id,Model model){
		model.addAttribute("instrumentModel",instrumentModelRepository.findOne(id));
		return "admin/instrument/model/view";
	}
	
	@RequestMapping(value = "/instrumentmodel", params = "edit", method = RequestMethod.GET)
	public String getEditInstrumentModel(@RequestParam long id,Model model) {
		model.addAttribute("instrumentModel", instrumentModelRepository.findOne(id));
		return "admin/instrument/model/edit";
	}
	
	@RequestMapping(value = "/instrumentmodel", params = "add", method = RequestMethod.POST)
	public String postAddInstrumentModel(@RequestParam Long typeId,@RequestParam String model) {
		InstrumentType instrumentType=instrumentTypeRepository.findOne(typeId);
		InstrumentModel instrumentModel = new InstrumentModel(model,instrumentType);
		instrumentModel = instrumentModelRepository.save(instrumentModel);
		return "redirect:"+instrumentType.getUrl();
	}
	
	@RequestMapping(value = "/instrumentmodel", params = "edit", method = RequestMethod.POST)
	public String postEditInstrumentModel(@RequestParam long id,@RequestParam String model) {
		InstrumentModel instrumentModel = instrumentModelRepository.findOne(id);
		instrumentModel.setInstrumentModel(model);
		instrumentModel = instrumentModelRepository.save(instrumentModel);
		return "redirect:"+instrumentModel.getUrl();
	}
	
	@RequestMapping(value = "/instrumentmodel", params = "delete", method = RequestMethod.POST)
	public String postDeleteInstrumentModel(@RequestParam long id) {
		instrumentModelRepository.delete(id);
		return "redirect:instrumenttype?list";
	}
}
