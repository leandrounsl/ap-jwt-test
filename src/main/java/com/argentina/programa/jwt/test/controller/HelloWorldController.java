package com.argentina.programa.jwt.test.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin()
public class HelloWorldController {

	@RequestMapping({ "/hello" })
	public String hello() {
		// Este endpoint respondera solo si el usuario que realiza el request esta
		// autenticado.
		// Para ejecutar este endpoint es necesario enviar un token JWT valido.
		return "¡Hola desde Argentina Programa!";
	}

}
