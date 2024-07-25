package com.estate.information.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.estate.information.entity.EstateDTO;
import com.estate.information.service.EstateService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class EstateViewController {

	final EstateService estateService;

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("estates", estateService.getAllEstate());
		return "principal";
	}

	@GetMapping("/estates")
	public String getAllEstate(Model model) {
		model.addAttribute("estates", estateService.getAllEstate());
		return "principal";
	}

	@PostMapping("/update/{estateId}")
	public String updateEstate(@PathVariable("estateId") String estateId, EstateDTO estate, BindingResult result,
			Model model) {
		estateService.updateEstate(estateId, estate);
		return "redirect:/estates";
	}

	@GetMapping("/edit/{estateId}")
	public String editEstate(@PathVariable("estateId") String estateId, Model model) {
		var estate = estateService.getEstate(estateId);
		model.addAttribute("estate", estate.get());
		return "edit-estate";
	}

	@GetMapping("/remove/{estateId}")
	public String romveEstate(@PathVariable("estateId") String estateId, Model model) {
		estateService.removeEstate(estateId);
		return "redirect:/estates";
	}

	@GetMapping("/signup")
	public String showSignUpForm(Model model) {
		EstateDTO estate = new EstateDTO();
		model.addAttribute("estate", estate);
		return "new-estate";
	}

	@PostMapping("/register")
	public String registerEstate( EstateDTO estate, BindingResult result, Model model) {
		estateService.registerEstate(estate);
		if(result.hasErrors()) {
			return "new-estate";
		}
		return "redirect:/estates";
	}
}
