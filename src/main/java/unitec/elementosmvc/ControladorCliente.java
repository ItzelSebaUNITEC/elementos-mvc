/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitec.elementosmvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unitec.elementosmvc.Estatus;
import unitec.elementosmvc.Cliente;
import unitec.elementosmvc.RepositorioCliente;


@RestController   //uri  
@RequestMapping("/api")
@CrossOrigin

public class ControladorCliente {
    @Autowired RepositorioCliente repoCli;
    
//caso a) Buscar todos    
@GetMapping("/cliente")
public List<Cliente> buscarTodos(){
    
    return repoCli.findAll();
}
    
//caso b)buscar por id
@GetMapping("/cliente/{id}")//as llaves significan que el ususario necesita introducir un valor 
    public Cliente buscarPorId(@PathVariable String id){//siempre que se pone llave se pone
        //"PathVariable=variable de ruta con variable de tipo id
        Cliente clien = new Cliente();  
        return repoCli.findById(id).get();
    }
    
    //caso c) Guardar
    @PostMapping("/cliente")
    public Estatus guardar(@RequestBody String json) throws Exception{
    // primero cnvertimos este string json a un objeto java
    
    ObjectMapper mapper=new ObjectMapper();
    Cliente clien =mapper.readValue(json, Cliente.class);// para que no nos marque error debemos poner un "throws"
       System.out.println("este mensaje se convirtio"+clien);
       repoCli.save(clien);
        Estatus estatus=new Estatus();
        estatus.setMensaje("true");
        estatus.setMensaje("cliente guardado exitosamente!!!");
        return estatus;
        
        }
        //caso d) actualizar
        @PutMapping("/cliente")
                public Estatus actualizar(@RequestBody String json)throws Exception{
        //Primero convertimos este string json a un objeto java
        ObjectMapper maper=new ObjectMapper();
   Cliente clien = maper.readValue(json, Cliente.class);// para que no nos marque error debemos poner un "throws"
       repoCli.save(clien);
   System.out.println("este objeto se convirtio"+clien);
       
        Estatus estatus=new Estatus();
        estatus.setSuccess(true);
        estatus.setMensaje("cliente guardado exitosamente!!!");
        return estatus;
    }


//caso e)borrar
@DeleteMapping("/cliente/{id}")
public Estatus borrarPorId(@PathVariable String id){
Cliente clien=new Cliente();

repoCli.deleteById(id);
Estatus e=new Estatus();
e.setMensaje("cliente borrado exitosamente!!!");
return e;
}
}
