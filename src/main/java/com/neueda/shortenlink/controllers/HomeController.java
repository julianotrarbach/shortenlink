package com.neueda.shortenlink.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.neueda.shortenlink.models.Formulario;
import com.neueda.shortenlink.repository.LinkModel;
import com.neueda.shortenlink.repository.LinkRepository;

import io.swagger.annotations.Api;

@Controller
public class HomeController {

	@Autowired
	LinkRepository linkRepositoty;

	@GetMapping("/")
	public String homeForm(@ModelAttribute("formulario") Formulario formulario,Model model) {
		
		LinkModel linkModel = new LinkModel();
		model.addAttribute("model", linkModel);
		model.addAttribute("realLink", "");
		model.addAttribute("shortLink", "");

		return "home";
	}

	@PostMapping("/generate")
	public String indexSubmit(@ModelAttribute("formulario") Formulario formulario,Model model) {

		LinkModel linkModel = new LinkModel();
		linkModel.setRealLink(formulario.getRealLink());

		linkModel = linkRepositoty.save(linkModel);
		formulario.setShortLink(linkModel.getShortLink());
		model.addAttribute("model", formulario);
		model.addAttribute("realLink", linkModel.getRealLink());
		model.addAttribute("shortLink", linkModel.getShortLink());

		return "result";
	}

}
