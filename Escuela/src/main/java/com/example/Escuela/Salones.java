package com.example.Escuela;

import java.util.ArrayList;

public class Salones {
    String id;
    ArrayList<Profesor> profesores = new ArrayList<Profesor>();
    public Salones(String id, ArrayList<Profesor> profesores) {
        this.id = id;
        this.profesores = profesores;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public ArrayList<Profesor> getProfesores() {
        return profesores;
    }
    public void setProfesores(ArrayList<Profesor> profesores) {
        this.profesores = profesores;
    }    

}
