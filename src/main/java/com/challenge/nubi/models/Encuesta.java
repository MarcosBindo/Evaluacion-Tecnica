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
    private String etiqueta;
    private ArrayList<Pregunta> preguntas;
    private Date fecha_vencimiento;

    // Encuesta con etiqueta ingresada por parametro
    public Encuesta(String nombre, String etiqueta, Date fecha_vencimiento) {
        nEncuesta = count.incrementAndGet();
        this.nombre = nombre;
        this.fecha_vencimiento = fecha_vencimiento;
        this.etiqueta = etiqueta;
        this.preguntas = new ArrayList<Pregunta>();
    }

    // Encuesta sin etiqueta
    public Encuesta(String nombre, Date fecha_vencimiento) {
        nEncuesta = count.incrementAndGet();
        this.nombre = nombre;
        this.etiqueta = "null"; // Le inserta el string 'null' por default para facilitar el proceso de filtrado
        this.fecha_vencimiento = fecha_vencimiento;
        this.preguntas = new ArrayList<Pregunta>();
    }

    protected void agregarPregunta(Pregunta pregunta) {
        this.preguntas.add(pregunta);
    }

    public void setFecha_vencimiento(String fecha_ven) {
        Date date = Date.valueOf(fecha_ven);
        this.fecha_vencimiento = date;
    }

}
