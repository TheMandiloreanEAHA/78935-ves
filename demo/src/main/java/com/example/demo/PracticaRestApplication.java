package com.example.demo;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class PracticaRestApplication {
	ArrayList<Alumnos> alumnos = new ArrayList<Alumnos>();
	Alumnos a = new Alumnos("pepito", 12);
	Alumnos b = new Alumnos("Cartman", 8);
	// alumnos.add("pepito");
		// alumnos.add("sutanito");
		// alumnos.add("Perengano");
		//alumnos.add(a);
		//alumnos.add(b);

	public static void main(String[] args) {
		SpringApplication.run(PracticaRestApplication.class, args);
	}

	@RequestMapping("/")
	public String name1(){
		return "Hola Escuela";
	}
	//Esto crea 
	//Para agregarlo desde un json en un archivo: curl -X POST -d @peticon.json -H "Content-Type: application/json" https://localhost:8080/alumnos
	//Para agregarlo manualmente: curl -X POST -d '{"nombre":"Erick","edad":21 }' -H "Content-Type: application/json" https://localhost:8080/alumnos

	@RequestMapping(value = "/alumnos", method = RequestMethod.POST)
	public String name2(@RequestBody Alumnos a){
		alumnos.add(a);

		System.out.println(a);
		return "Alumno creado";
	}
	//Esto borra
	@RequestMapping(value = "/alumnos", method = RequestMethod.DELETE)
	public String name3(){
		return "Alumno borrado";
	}

	//Esto devuelve alumnos
	@RequestMapping(value = "/alumnos", method = RequestMethod.GET)
	public ArrayList<Alumnos> name4(){

		return alumnos;
	}

}
