package com.example.Escuela;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class EscuelaApplication {
	ArrayList<Salones> salones = new ArrayList<Salones>(); 
	ArrayList<Profesor> profesores = new ArrayList<Profesor>(); 	
	ArrayList<Profesor> profesores2 = new ArrayList<Profesor>();
	ArrayList<Profesor> profesores3 = new ArrayList<Profesor>(); 	


	public static void main(String[] args) {
		SpringApplication.run(EscuelaApplication.class, args);
	}

	@RequestMapping("/")
	public String inicio(){
		//añadir profesores por default
		Profesor p1 = new Profesor("Dr Rojano");
		Profesor p2 = new Profesor("Dr Itzel");
		//Profesor p3 = new Profesor("Dr Guillermo");
		profesores.add(p1);
		profesores.add(p2);
		return "Bienvenido a la Escuela";
	}

	//Esto crea Profesores
	@RequestMapping(value = "/newProfesor", method = RequestMethod.POST)
	public String createProf(){		
		Profesor p3 = new Profesor("Dr Guillermo");
		Profesor p4 = new Profesor("Maestra Alicia");
		profesores2.add(p3);
		profesores2.add(p4);
		return "Profesor Creado";
	}

	//Esto ve Profesores
	@RequestMapping(value = "/profesores", method = RequestMethod.GET)
	public ArrayList<Profesor> verProfes(){
		for(int i = 0; i<profesores.size(); i++){
			profesores3.add(profesores.get(i));
		}
		for(int i = 0; i<profesores2.size(); i++){
			profesores3.add(profesores2.get(i));
		}
		return profesores3;
	}

	//Esto crea salones
	@RequestMapping(value = "/newSalon", method = RequestMethod.POST)
	public String createS(){		
		Salones s1 = new Salones("F402", profesores);
		salones.add(s1);
		return "Salón Creado";
	}
	//curl -v -X POST http://localhost:8080/newSalon
	@RequestMapping(value = "/newSalon2", method = RequestMethod.POST)
	public String createS2(){		
		Salones s1 = new Salones("F102", profesores2);
		salones.add(s1);
		return "Salón Creado";
	}
	//curl -v -X POST http://localhost:8080/newSalon2
	//Ese ve salones
	@RequestMapping(value = "/salones", method = RequestMethod.GET)
	public ArrayList<Salones> verSalones(){
		return salones;
	}

}
