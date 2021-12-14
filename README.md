# evaluacion-tecnica
El codigo unicamente funciona mockeado. Si se quieren realizar cambios en su ejecucion hay que descargarlo
y modificar el main.
(Yo deje codigo para que se pueda solamente ejecutar y muestre todas las funciones que tiene el sistema)

## Codigo del main
```java
    //Crear un usuario
		Usuario user = new Usuario("marcos", "1234");
		user.registrarse();

		//Crea una encuesta con etiqueta
		Encuesta encuesta1 = new Encuesta("Encuesta de prueba 1", "etiqueta", new Date(122, 03, 15));
		Encuesta encuesta2 = new Encuesta("Encuesta de prueba 2", "prueba1", new Date(122, 03, 15));
		
		//Crea una encuesta sin etiqueta
		Encuesta encuesta3 = new Encuesta("Encuesta de prueba 3", new Date(122, 02, 03));
	
		//Crea una pregunta
		Pregunta p1 = new Pregunta("Pregunta 1");
		//Metodo para agregar la pregunta con sus opciones a la encuesta deseada
		user.agregarPregunta(encuesta1,p1);
		//Agrega las opciones de respuesta a la pregunta
		user.cargarRespuestas(p1,"opcion 1");
		user.cargarRespuestas(p1,"opcion 2");
		user.cargarRespuestas(p1,"opcion 3");
		user.cargarRespuestas(p1,"opcion 4");

		Pregunta p2 = new Pregunta("Pregunta 2");
		user.agregarPregunta(encuesta2,p2);
		user.cargarRespuestas(p2,"opcion 1");
		user.cargarRespuestas(p2,"opcion 2");
		user.cargarRespuestas(p2,"opcion 3");
		
		//Metodo para poder agregar las encuestas al json
		user.agregarEncuesta(encuesta1);
		user.agregarEncuesta(encuesta2);
		user.agregarEncuesta(encuesta3);

		//Metodo que busca e imprime todas las encuestas que contenga el string ingresado
		manipuladorJSON.buscarPorEtiqueta("etiqueta");

		//Metodo para mostrar por pantalla todas las encuestas almacenadas en el archivo 
		manipuladorJSON.obtenerEncuestas();
```

## Como ejecutarlo?
### 1-Primer metodo (Consola)
- Descargar el codigo
- Descomprimirlo
- Dentro de la carpeta target abrir una consola, powershell, etc;
- Ingresar el siguiente comando
```bash
java -jar .\nubi-0.0.1-SNAPSHOT.war
```
### 2-Segundo Metodo
(Una vez este dockerizado completo esta parte)


# :stop_sign: Que fue lo mas desafiante?

### Cosas que no pude realizar:
- Como dueño de producto, me gustaría que mi aplicación de encuestas posea un login para usuarios.
- Como dueño de producto, me gustaría poder revisar un historial de preguntas por usuario

### Cosas que estan frenadas: 
 - Debe estar dockerizado (Esto es debido a que la maquina virtual que estaba utilizando no estaba corriendo, intente en mi windows pero tambien habia errores gracias al kernel
 de linux)


