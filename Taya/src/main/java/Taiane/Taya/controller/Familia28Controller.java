package Taiane.Taya.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class Familia28Controller {

	@GetMapping("/rota1")
	public String hello() {
		return "Com toda certeza, as habilidades utilizadas foram trabalho em equipe e"
				+ " muito mais muitoo mesmo de persistencia";
	}

	@GetMapping("/rota2")
	public String hello2() {
		return "Espero não chorar hoje";
	}

	
	
}
