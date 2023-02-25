package com.epicode.andreacursi.controlloincendi.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.epicode.andreacursi.controlloincendi.entities.Incendio;
import com.epicode.andreacursi.controlloincendi.entities.Sonda;
import com.epicode.andreacursi.controlloincendi.services.IncendioService;
import com.epicode.andreacursi.controlloincendi.services.SondaService;

@Controller
public class ControlloIncendiController {
	
	@Autowired
	SondaService soSe;
	
	@Autowired
	IncendioService inSe;
	
	@GetMapping("/")
	@ResponseBody
	private String home() {
		return "Nulla da segnalare";
	}
	
	@GetMapping("/alarm/")
	@ResponseBody
	private ModelAndView allarme(@RequestParam(name="idsonda") Integer id, 
			@RequestParam(name="lat") double latitudine, 
			@RequestParam(name="lon") double lon, 
			@RequestParam(name="smokelevel") Integer quantitaFumo,
			Model model1, Model model2, Model model3, Model model4, Model model5) {
		ModelAndView mav=new ModelAndView("index");
		Optional<Sonda> sondaObj= soSe.ottieniDaId(id);
		List<Incendio> incendi= inSe.ottieniDaSondaId(id);
		List<Incendio> incendi2= inSe.ottieniDaFumo(quantitaFumo);
		List<Incendio> incendi3 = new ArrayList<>();
		model1.addAttribute("idSonda", sondaObj.get().getId());
		model2.addAttribute("latSonda", sondaObj.get().getLatitudine());
		model3.addAttribute("lonSonda", sondaObj.get().getLongitudine());
		for(int i=0; i<incendi.size(); i++) {
			if(incendi2.contains(incendi.get(i))) {
				incendi3.add(incendi.get(i));
			}
		}
		model4.addAttribute("incendio", incendi3.toString());
		return mav;
	}
	
}
