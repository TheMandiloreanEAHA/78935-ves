using System;
using WSDL.mensajes;

namespace WSDL.operaciones{
    public class Operaciones : Mensajes{
        public string Saludar(string nombre){
            string msj = "Hola "+nombre;
            return msj;
        }
        public string Mostrar(int id){
            //Crear colección para Mostrar:
            var respuestas = new List<string>{
                "Ayuda, etoy aplicaconla del burro que toca la flauta", 
                "Ya sirvió?", 
                "No tengo ni la menor idea de si va a servir :'(", 
                "Hello there",
                "Un gran poder, conlleba una gran responsabilidad",
                "Te seguiré amando, aún cuando los mortales se olviden de nosotros y tu y yo seamos solo polvo de estrellas",
                "I'll still love you, even when mortals has forggoten us, and you and me will be only stardust",
                "Decisiones dificiles, requieren voluntades fuertes"
            };
            return respuestas[id];
        }
    }
}
