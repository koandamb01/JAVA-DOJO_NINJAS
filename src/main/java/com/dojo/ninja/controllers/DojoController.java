package com.dojo.ninja.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dojo.ninja.models.Dojo;
import com.dojo.ninja.services.DojoService;

@Controller
@RequestMapping("/dojos")
public class DojoController {
	private final DojoService dojoService;
	
	public DojoController(DojoService dojoService) { this.dojoService = dojoService; }
	
	@RequestMapping("new")
	public String newform(@ModelAttribute("dojo") Dojo dojo) {
		return "dojo/newForm.jsp";
	}
	
	@RequestMapping(value="new", method=RequestMethod.POST)
	public String newform(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "dojo/newForm.jsp";
		}else {
			this.dojoService.createDojo(dojo);
		}
		return "redirect:/ninjas/new";
	}
	
	@RequestMapping("{id}")
	public String dojoHome(@PathVariable("id") Long id, Model model) {
		Dojo dojo = this.dojoService.findDojoById(id);
		model.addAttribute("dojo", dojo);
		return "dojo/show.jsp";
	}
}
