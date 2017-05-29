/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.elementos;

import java.io.IOException;
import java.util.GregorianCalendar;

/**
 *
 * @author alvar
 */
public interface GestionReserva {
    
        
        public abstract boolean existeFichero(String nombreFichero) throws IOException;
        public abstract String leeReservas(String nombreFichero) throws IOException;
        
        // la reserva empieza a recogese desde el restaurente para que sea posible comparar ciertos
        // datos, porque el restaurante almacena las clases relaccionadas
        //              Restaurante --1--n--> Sala --1--n--> Mesa
        public abstract void escribeReserva(int comensales, GregorianCalendar fech, String[] s) throws IOException;
        
        // no veo necesario este metodo, para no parar el proceso en el restaurante se vuelve a llamar
        // al metodo del menu o de la recogida de datos, sacarMensaje() solo serviria para ver una linea
        // por pantalla
        //public abstract void sacaMensaje();        
    
}
