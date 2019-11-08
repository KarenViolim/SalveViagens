package com.projeto.salveViagens.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping("/administrativo")
	public String acessarPrincipal() {
		return "administrativo/index";
	}
}
