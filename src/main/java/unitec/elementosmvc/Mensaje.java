/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitec.elementosmvc;

import java.time.LocalDate;
import org.springframework.data.annotation.Id;

/**
 *
 * @author Guest
 */
public class Mensaje {
    @Id
    
    String id;
    LocalDate fecha;
    String cuerpo;
    
    public Mensaje (){}

   
    
    public String getId(){
        return id;
    }
    
    public void SetId (String id){
        this.id=id;
    }
    
    public LocalDate GetFecha (){
        return fecha;
    }
    
    public void SetFecha (LocalDate fecha){
        this.fecha=fecha;
    }

    public String GetCuerpo (){
        return cuerpo;
    }

    public void SetCuerpo (String cuerpo){
        this.cuerpo=cuerpo;
    }
    
    
    public Mensaje(LocalDate fecha, String cuerpo){
        this.fecha=fecha;
        this.cuerpo=cuerpo;
    }
    
    public Mensaje (String cuerpo){
        this.cuerpo=cuerpo;
    }
          

    
}
