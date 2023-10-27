
package login.codigo;

import java.util.ArrayList;
import javax.swing.JOptionPane;


public class baseDeDatos {
    private static ArrayList<Persona> personas = new ArrayList<>();
    
    
    public baseDeDatos() {
        
    }
    public boolean agregarPersona(String nombre, String carnet, String contrasena){
        Persona nuevaPersona = new Persona(nombre,contrasena,carnet);
        personas.add(nuevaPersona);
        return true;
    }
   
    public boolean iniciarSesion(String carnet, String contrasena){
        
        for(Persona i: personas){
             if(i.getCarnet().equals(carnet) && i.getContra().equals(contrasena)){
                 
                 return true;
             }
        }
         
        return false;
    }
    public static ArrayList<Persona> getPersonas() {
        return personas;
    }
    
  
}
