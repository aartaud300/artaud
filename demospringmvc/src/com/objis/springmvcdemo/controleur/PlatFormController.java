package com.objis.springmvcdemo.controleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.objis.springmvcdemo.domaine.Employe;
import com.objis.springmvcdemo.domaine.Plat;
import com.objis.springmvcdemo.service.IPlatService;
import com.objis.springmvcdemo.service.PlatService;

@Controller
public class PlatFormController{

	private IPlatService platService;

//	public PlatFormController() {
//		//Initialise Classe (Employe.class) 
//		setCommandClass(Plat.class);
//		setCommandName("lePlatJour");
//	}

	@RequestMapping("/plat")
	public void list(Model model){
		System.out.println("Appel de listePlat");
		Plat lePlatJour = platService.findById(1);
		model.addAttribute("lePlatJour",  lePlatJour);
		
	}

	public IPlatService getPlatService() {
		return platService;
	}

	@Autowired
	public void setPlatService(IPlatService platService) {
		this.platService = platService;
	} 

}
