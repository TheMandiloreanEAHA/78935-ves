package mx.uv.clientes;

import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer idCliente;
    private String nombre;
    private ArrayList<Integer> idVentas;
    
    public Integer getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public ArrayList<Integer> getIdVentas() {
        return idVentas;
    }
    public void setIdVentas(ArrayList<Integer> idVentas) {
        this.idVentas = idVentas;
    }

    
    
    
   
}
