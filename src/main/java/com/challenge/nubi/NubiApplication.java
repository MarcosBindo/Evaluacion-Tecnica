package com.challenge.nubi;

import java.sql.Date;

import com.challenge.nubi.models.Encuesta;
import com.challenge.nubi.models.Pregunta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NubiApplication {

	public static void main(String[] args) {
		SpringApplication.run(NubiApplication.class, args);

		Encuesta encuesta = new Encuesta("Encuesta de prueba 1", new Date(122,03,15));

		Pregunta p1 = new Pregunta("Pregunta 1");
		encuesta.agregarPregunta(p1);
		p1.agregarRespuestas("opcion 1");
		p1.agregarRespuestas("opcion 2");
		p1.agregarRespuestas("opcion 3");
		p1.agregarRespuestas("opcion 4");

		Pregunta p2 = new Pregunta("Pregunta 2");
		encuesta.agregarPregunta(p2);
		p2.agregarRespuestas("opcion 1");
		p2.agregarRespuestas("opcion 2");
		p2.agregarRespuestas("opcion 3");
		p2.agregarRespuestas("opcion 4");

		System.out.println(encuesta);

	}
	
}
