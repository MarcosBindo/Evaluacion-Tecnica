package com.challenge.nubi.handler;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.challenge.nubi.models.Encuesta;
import com.challenge.nubi.models.Pregunta;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

@SuppressWarnings("unchecked")
public class manipuladorJSON{
    private static String path = "bd.json";
    private static JSONObject mainJson = new JSONObject();
    private static JSONObject encuestas = new JSONObject();

    // Metodo que agrega lee las preguntas con sus respectivas opciones de respuesta
    private static JSONObject agregarPregunta(Pregunta pregunta) {
        JSONObject preguntaData = new JSONObject();

        preguntaData.put("Opciones", pregunta.getRespuestas());

        // recorre las opciones de respuesta y las agrega a un JSONArray
        JSONArray respuestas = new JSONArray();
        for (String opciones : pregunta.getRespuestas()) {
            respuestas.add(opciones);
        }
        
        return preguntaData;
    }

    public void agregarEncuesta(Encuesta encuesta) {
        JSONObject encuestaData = new JSONObject();
        JSONObject preguntas = new JSONObject();
        encuestaData.put("Nombre", encuesta.getNombre());
        encuestaData.put("Fecha de vencimiento", encuesta.getFecha_vencimiento().toString());
        encuestaData.put("Preguntas", preguntas);
        encuestaData.put("Etiqueta", encuesta.getEtiqueta());

        for (Pregunta pregunta : encuesta.getPreguntas()) {
            preguntas.put(pregunta.getPregunta(),agregarPregunta(pregunta));
        }

        encuestas.put(encuesta.getNEncuesta(), encuestaData);
        escribirJSON(mainJson);
    }

    // Metodo publico que pide un String como parametro, y devuelve por pantalla las
    // encuestas que cumplan con el nombre de la etiqueta
    public static void buscarPorEtiqueta(String etiqueta) {
        leerJSON();
        JSONObject encuestasTemp = new JSONObject();

        for (int i = 1; i <= encuestas.size(); i++) {
            JSONObject encuesta = (JSONObject) encuestas.get(String.valueOf(i));
            String nombreEtiqueta = (String) encuesta.get("Etiqueta");

            if (nombreEtiqueta.equals(etiqueta)) {
                encuestasTemp.put(i, encuesta);
            }
        }
        if (encuestasTemp.size() == 0) {
            System.out.println("No se encontro ninguna encuesta con esa etiqueta");
        } else {
            System.out.println(encuestasTemp);
        }

    }

    // Metodo publico para poder obtener un listado de todas las encuestas del
    // archivo
    public static void obtenerEncuestas() {
        leerJSON();

        for (int i = 1; i <= encuestas.size(); i++) {
            JSONObject encuesta = (JSONObject) encuestas.get(String.valueOf(i));

            System.out.println("<--Comienzo de encuesta " + i + " -->");
            printEncuesta(encuesta);
            System.out.println("<--Fin de encuesta " + i + " --> \n");

        }
    }

    // Metodo que escribe un archivo json
    private static void escribirJSON(JSONObject objeto) {
        objeto.clear();
        objeto.put("Encuestas", encuestas);
        try (FileWriter file = new FileWriter(path, false)) {
            file.write(objeto.toString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Metodo que por el momento lee El objeto mayor "Encuestas" y lo devuelve
    private static JSONObject leerJSON() {
        JSONParser parser = new JSONParser();

        try (FileReader file = new FileReader(path)) {
            Object obj = parser.parse(file);
            JSONObject json = (JSONObject) obj;
            encuestas = (JSONObject) json.get("Encuestas");
            return encuestas;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Metodo privado que obtiene el contenido de la encuesta y los muestra en
    // consola
    private static void printEncuesta(JSONObject encuesta) {
        String nombre = (String) encuesta.get("Nombre");
        System.out.println("Nombre: " + nombre);

        String etiqueta = (String) encuesta.get("Etiqueta");
        System.out.println("Etiqueta: " + etiqueta);

        JSONObject preguntas = (JSONObject) encuesta.get("Preguntas");
        System.out.println("Preguntas: " + preguntas);

        String fechaVenc = (String) encuesta.get("Fecha de vencimiento");
        System.out.println("Fecha de caducidad: " + fechaVenc);
    }
}