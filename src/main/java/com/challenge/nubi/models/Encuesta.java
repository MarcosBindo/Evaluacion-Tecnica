package com.challenge.nubi.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import lombok.AllArgsConstructor;
import lombok.Data;

//Utilizacion de dependencia Lombok 
@Data // Agrega getters y setters
@AllArgsConstructor // Crea un constructor con todos los argumentos.
public class Encuesta {
    private static final AtomicInteger count = new AtomicInteger();
    private int nEncuesta;
    private String nombre;
    private ArrayList<Pregunta> preguntas;
    private Date fecha_vencimiento;

    public Encuesta(String nombre, Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
        this.nombre = nombre;
        nEncuesta = count.incrementAndGet();
        this.preguntas = new ArrayList<Pregunta>();
    }

    public void agregarPregunta(Pregunta pregunta){
        this.preguntas.add(pregunta);
    }

}
