package com.challenge.nubi;

import java.sql.Date;

import com.challenge.nubi.handler.manipuladorJSON;
import com.challenge.nubi.models.Encuesta;
import com.challenge.nubi.models.Pregunta;
import com.challenge.nubi.models.Usuario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NubiApplication {

	public static void main(String[] args) {
		SpringApplication.run(NubiApplication.class, args);

		//Crear un usuario
		Usuario user = new Usuario("marcos", "1234");

		//Crea una encuesta con etiqueta
		Encuesta encuesta1 = new Encuesta("Encuesta de prueba 1", "etiqueta", new Date(122, 03, 15));
		Encuesta encuesta2 = new Encuesta("Encuesta de prueba 2", "prueba1", new Date(122, 03, 15));
		
		//Crea una encuesta sin etiqueta
		Encuesta encuesta3 = new Encuesta("Encuesta de prueba 3", new Date(122, 02, 03));
	
		//Crea una pregunta
		Pregunta p1 = new Pregunta("Pregunta 1");
		//Metodo para agregar la pregunta con sus opciones a la encuesta deseada
		encuesta1.agregarPregunta(p1);
		//Agrega las opciones de respuesta a la pregunta
		p1.agregarRespuestas("opcion 1");
		p1.agregarRespuestas("opcion 2");
		p1.agregarRespuestas("opcion 3");
		p1.agregarRespuestas("opcion 4");

		Pregunta p2 = new Pregunta("Pregunta 2");
		encuesta2.agregarPregunta(p2);
		p2.agregarRespuestas("opcion 1");
		p2.agregarRespuestas("opcion 2");
		p2.agregarRespuestas("opcion 3");
		
		//Metodo para poder agregar las encuestas al json
		user.agregarEncuesta(encuesta1);
		user.agregarEncuesta(encuesta2);
		user.agregarEncuesta(encuesta3);

		//Metodo que busca e imprime todas las encuestas que contenga el string ingresado
		manipuladorJSON.buscarPorEtiqueta("etiqueta");

		//Metodo para mostrar por pantalla todas las encuestas almacenadas en el archivo 
		manipuladorJSON.obtenerEncuestas();
	}

}
