package mx.uv.practica03;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.t4is_uv_mx.saludos.BusquedaRequest;
import https.t4is_uv_mx.saludos.BusquedaResponse;
import https.t4is_uv_mx.saludos.EliminarRequest;
import https.t4is_uv_mx.saludos.EliminarResponse;
import https.t4is_uv_mx.saludos.ModificarRequest;
import https.t4is_uv_mx.saludos.ModificarResponse;
import https.t4is_uv_mx.saludos.SaludarRequest;
import https.t4is_uv_mx.saludos.SaludarResponse; 

import java.util.ArrayList;

@Endpoint
public class EndPoint{
    ArrayList<String> saludos = new ArrayList<String>();

    @PayloadRoot(localPart = "SaludarRequest", namespace = "https://t4is.uv.mx/saludos")
    @ResponsePayload
    public SaludarResponse Saludar(@RequestPayload SaludarRequest peticion){
        SaludarResponse respuesta = new SaludarResponse();
        saludos.add(peticion.getNombre());
        respuesta.setRespuesta("hola "+peticion.getNombre());
        return respuesta;
    }

    @PayloadRoot(localPart = "busquedaRequest", namespace = "https://t4is.uv.mx/saludos")
    @ResponsePayload
    public BusquedaResponse buscar(@RequestPayload BusquedaRequest peticion){
        BusquedaResponse respuesta = new BusquedaResponse();
        //int pos = peticion.getPosicion();
        respuesta.setRespuesta("Saludos para "+saludos.get(peticion.getPosicion()));
        return respuesta;
    }
    
    @PayloadRoot(localPart = "eliminarRequest", namespace = "https://t4is.uv.mx/saludos")
    @ResponsePayload
    public EliminarResponse eliminar(@RequestPayload EliminarRequest peticion){
        EliminarResponse respuesta = new EliminarResponse();
        saludos.remove(peticion.getPosicion());
        respuesta.setRespuesta("Saludos eliminados ");
        return respuesta;
    }

    @PayloadRoot(localPart = "modificarRequest", namespace = "https://t4is.uv.mx/saludos")
    @ResponsePayload
    public ModificarResponse modificar(@RequestPayload ModificarRequest peticion){
        ModificarResponse respuesta = new ModificarResponse();
        saludos.set(peticion.getPosicion(), peticion.getNombre());
        respuesta.setRespuesta("Saludos Moficados con exito!");
        return respuesta;
    }
    
}
