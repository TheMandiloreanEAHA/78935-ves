package mx.uv.practica04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.t4is_uv_mx.saludos.BuscarSaludoRequest;
import https.t4is_uv_mx.saludos.BuscarSaludoResponse;
import https.t4is_uv_mx.saludos.DameTodoResponse;
import https.t4is_uv_mx.saludos.DeleteSaludoRequest;
import https.t4is_uv_mx.saludos.DeleteSaludoResponse;
import https.t4is_uv_mx.saludos.EditSaludoRequest;
import https.t4is_uv_mx.saludos.EditSaludoResponse;
import https.t4is_uv_mx.saludos.GiveAllResponse;
import https.t4is_uv_mx.saludos.SaludarRequest;
import https.t4is_uv_mx.saludos.SaludarResponse;


@Endpoint
public class EndPoint {
    @Autowired
    private ISaludador iSaludador;


    /*MANDAR SALUDO */
    @PayloadRoot(namespace = "https://t4is.uv.mx/saludos",localPart = "SaludarRequest")
    @ResponsePayload
    public SaludarResponse Saludar(@RequestPayload SaludarRequest peticion){
        SaludarResponse respuesta = new SaludarResponse();
        respuesta.setRespuesta("Hola "+ peticion.getNombre());

        Saludador saludador = new Saludador();
        saludador.setNombre((peticion.getNombre()));
        iSaludador.save(saludador);
        return respuesta;  
    }
    
    /*BUSCAR SALUDO */
    @PayloadRoot(namespace = "https://t4is.uv.mx/saludos",localPart = "BuscarSaludoRequest")
    @ResponsePayload
    public BuscarSaludoResponse buscarSaludo(@RequestPayload BuscarSaludoRequest peticion){
        BuscarSaludoResponse respuesta = new BuscarSaludoResponse();
        if(iSaludador.findById(peticion.getId()).isPresent()){
            //Recorrer lista 
            Iterable<Saludador> lista = iSaludador.findAll();
            for(Saludador o : lista){
                if(o.getId() == peticion.getId()){
                    respuesta.setRespuesta(o.getNombre());
                }           
            }
        }else{
            respuesta.setRespuesta("El elemento que desea eliminar no se encuentra en la BD");
        }
        return respuesta;
    }
    /*ELIMINAR SALUDO */
    @PayloadRoot(namespace = "https://t4is.uv.mx/saludos",localPart = "DeleteSaludoRequest")
    @ResponsePayload
    public DeleteSaludoResponse deleteSaludo(@RequestPayload DeleteSaludoRequest peticion){
        DeleteSaludoResponse respuesta = new DeleteSaludoResponse();
        if(iSaludador.findById(peticion.getId()).isPresent()){
            //Recorrer lista 
            Iterable<Saludador> lista = iSaludador.findAll();
            for(Saludador o : lista){
                if(o.getId() == peticion.getId()){
                    respuesta.setRespuesta("Se ha eliminado el saludo para "+o.getNombre());
                    iSaludador.deleteById(peticion.getId());
                }           
            }
        }else{
            respuesta.setRespuesta("El elemento que desea eliminar no se encuentra en la BD");
        }
        return respuesta;
    }
    /*EDITAR SALUDO */
    @PayloadRoot(namespace = "https://t4is.uv.mx/saludos",localPart = "EditSaludoRequest")
    @ResponsePayload
    public EditSaludoResponse editSaludo(@RequestPayload EditSaludoRequest peticion){
        EditSaludoResponse respuesta = new EditSaludoResponse();
        if(iSaludador.findById(peticion.getId()).isPresent()){
            //Recorrer lista 
            Iterable<Saludador> lista = iSaludador.findAll();
            for(Saludador o : lista){
                if(o.getId() == peticion.getId()){
                    respuesta.setRespuesta("Se ha editado el saludo de "+o.getNombre()+", ahora el saludo es para "+peticion.getNombre());
                    //iSaludador.deleteById(peticion.getId());
                    Saludador aux = new Saludador();
                    aux.setId(peticion.getId()); aux.setNombre(peticion.getNombre());
                    iSaludador.save(aux);
                }           
            }
        }else{
            respuesta.setRespuesta("El elemento que desea editar no se encuentra en la BD");
        }
        return respuesta;
    }

    /*VER TODOS LOS SALUDOS */
    @PayloadRoot(namespace = "https://t4is.uv.mx/saludos", localPart = "dameTodoRequest")
    @ResponsePayload
    public DameTodoResponse dameTodo(){
        System.out.println("Lo estas haciendo bien, sigue así!");
        DameTodoResponse respuesta = new DameTodoResponse();
        //Recorrer lista 
        Iterable<Saludador> lista = iSaludador.findAll();
        for(Saludador o : lista){
            respuesta.getRespuesta().add(o.getNombre());            
        }
        return respuesta;
    }

    /*VER TODOS LOS SALUDOS CON SUS IDS*/
    @PayloadRoot(namespace = "https://t4is.uv.mx/saludos", localPart = "giveAllRequest")
    @ResponsePayload
    public GiveAllResponse giveAll(){
        GiveAllResponse respuesta = new GiveAllResponse();
        //Recorrer lista 
        Iterable<Saludador> lista = iSaludador.findAll();
        for(Saludador o : lista){
            //respuesta.getRespuesta().add(o.getNombre()); 
            respuesta.getIds().add(o.getId());
            respuesta.getNombres().add(o.getNombre());
                       
        }

        return respuesta;
    }




    
}
