package mx.uv.ventas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.t4is_uv_mx.ventas.*;

@Endpoint
public class EndPoint {
    @Autowired
    private IVentas iVentas;

    @PayloadRoot(localPart = "AgregarVentaRequest", namespace = "https://t4is.uv.mx/ventas")
    @ResponsePayload
    public AgregarVentaResponse Agregar(@RequestPayload AgregarVentaRequest peticion){
        AgregarVentaResponse respuesta = new AgregarVentaResponse();
        
        Venta venta = new Venta();
        venta.setIdProducto(peticion.getIdProducto());
        venta.setCantidad(peticion.getCantidad());
        iVentas.save(venta);

        respuesta.setRespuesta("Se agrego la venta correctamente");
        return respuesta;
    }
}
