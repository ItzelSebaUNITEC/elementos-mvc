/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitec.elementosmvc;

/**
 *
 * @author T-107
 */
public class Cliente {

   
    private String id;
    private String nombre;
    private Tarjetaa tarjeta;

     public Cliente() {
    }
    
    public Cliente(String id,String nombre, Tarjetaa tarjeta) {
        this.nombre = nombre;
        this.tarjeta = tarjeta;
        this.id=id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Tarjetaa getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjetaa tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String getId() {
        return id;
    }

    public void setId(String Id) {
        this.id = Id;
    }
    
}
