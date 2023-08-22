package com.codingdojo.cynthia.controladores;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class Controlador {
	
	@GetMapping("/Gold")
	public String index() {
		return "index.jsp"; //Hace referencia a un archivo jsp
	}
	
	@PostMapping("/jugar")
	public String jugar(HttpSession session,
						@RequestParam("lugar") String lugar) {
		
		//aquí usamos String lugar
		//lugar = "granja" o "cueva" o "casa" o "casino"
		
		//Debemos de tener una variable en sesión
		//llamada oro (puntuación) actividades (listado de
		//las actividades)
		
		int oro = 0;
		ArrayList<String> actividades = new ArrayList<String>();
		
		//Revisamos si en sesión existe algo llamado oro
		if(session.getAttribute("oro") == null) {
			//Aún no existe en sesión el oro
			session.setAttribute("oro", 0); //Creamos oro en sesión
			session.setAttribute("actividades", actividades);
		} else {
			//Si existe algo en sesion
			//En las variables que tengo dentro del método, igualarlas a lo que tengo guardado en sesion
			oro = (int) session.getAttribute("oro");
			actividades = (ArrayList<String>) session.getAttribute("actividades");
		}
		
		//Crear un num aleatorio que cumpla con el lugar
		int min = 0;
		int max = 0;
		
		/*Comparamos el lugar con distintos valores a traves de un switch*/
		switch(lugar) {
			case "granja":
				min = 10;
				max = 20;
				break;
			case "cueva":
				min = 5;
				max = 10;
				break;
			case "casa":
				min = 2;
				max = 5;
				break;
			case "casino":
				min = -50;
				max = 50;
				break;
		}
		
		
		
		int random = new Random().nextInt(max - min +1) + min; //me crea un número aleatorio entre min y max
		oro += random;
		//Actualizamos el oro de mi puntuacion
		session.setAttribute("oro", oro);
		
		//Formato de fecha
		Date fecha = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("MMMM d Y h:mm");
		String fechaFormateada = formato.format(fecha);
		
		String mensaje = "";
		if(random < 0) {
			mensaje = "Entraste a: "+lugar+" y perdiste "+random+" monedas. "+fechaFormateada;
		} else {
			mensaje = "Entraste a: "+lugar+" y ganaste "+random+" monedas. "+fechaFormateada;
		}
		
		//String mensaje = "Entraste a: "+lugar+" y obtuviste "+random+" monedas. "+fechaFormateada;
		actividades.add(mensaje);
		session.setAttribute("actividades", actividades);
		
		return "redirect:/Gold";
	}
	
}
