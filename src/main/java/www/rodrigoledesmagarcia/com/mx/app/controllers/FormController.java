package www.rodrigoledesmagarcia.com.mx.app.controllers;


import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import jakarta.validation.Valid;
import www.rodrigoledesmagarcia.com.mx.app.models.domain.Usuario;



@Controller
@SessionAttributes("usuario")
public class FormController {
	

	@ModelAttribute("paises")
	public List<String> paises() {
		return Arrays.asList("España", "Mexico", "Chile", "Argentina", "Peru", "Venezuela", "China", "Corea", "Ecuador", "Colombia", "Paraguay", "Uruguay", "Mongolia", "Francia", "Japon", "Holanda");
	}
	
	@GetMapping("/form")
	public String form (Model model)  {
		Usuario usuario = new Usuario();
		model.addAttribute("titulo", "Formulario de usuarios");
		model.addAttribute("usuario",  usuario);
		
		return "form";
	}
	
	
	
	@PostMapping("/form")
	public String procesar (@Valid Usuario usuario, BindingResult result, Model model )  {
		
	
		
		if (result.hasErrors()) {
			model.addAttribute("titulo","Resultado del formulario");
			
			return "form";
		}
		
		return "redirect:/ver";
	}
	
	@GetMapping("/ver")
	public String ver(@SessionAttribute(name="usuario", required = false) Usuario usuario, Model model, SessionStatus status) {
	
		if (usuario == null) {
			return "redirect:/form";
		}
		
		model.addAttribute("titulo","Resultado del formulario");
		status.setComplete();
		return "resultado";
	}
	
	
}
