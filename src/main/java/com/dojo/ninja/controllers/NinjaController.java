package com.dojo.ninja.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dojo.ninja.models.Dojo;
import com.dojo.ninja.models.Ninja;
import com.dojo.ninja.services.DojoService;
import com.dojo.ninja.services.NinjaService;

@Controller
@RequestMapping("/ninjas")
public class NinjaController {
	private final NinjaService ninjaService;
	private final DojoService dojoService;
	
	public NinjaController(NinjaService ninjaService, DojoService dojoService) { 
		this.ninjaService = ninjaService;
		this.dojoService = dojoService;
	}
	
	@RequestMapping("new")
	public String newForm(@ModelAttribute("ninja") Ninja ninja, Model model) {
		// get all at dojos
		List<Dojo> dojos = this.dojoService.findAllDojos();
		model.addAttribute("dojos", dojos);
		return "ninja/newForm.jsp";
	}
	
	@RequestMapping(value="new", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			// get all at dojos
			List<Dojo> dojos = this.dojoService.findAllDojos();
			model.addAttribute("dojos", dojos);
			return "ninja/newForm.jsp";
		}else {
			this.ninjaService.createNinja(ninja);
		}
		return "redirect:/dojos/"+ninja.getDojo().getId();
	}
}
