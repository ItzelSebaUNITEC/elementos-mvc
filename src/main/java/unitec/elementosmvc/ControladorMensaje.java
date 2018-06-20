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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController   //uri  
@RequestMapping("/api")
@CrossOrigin
public class ControladorMensaje {
    
    @Autowired RepositorioMensaje repoMensa;
    
//caso a) Buscar todos    
@GetMapping("/mensaje")
public List<Mensaje> buscarTodos(){
    
    return repoMensa.findAll();
}
    
//caso b)buscar por id
@GetMapping("/mensaje/{id}")//as llaves significan que el ususario necesita introducir un valor 
    public Mensaje buscarPorId(@PathVariable String id){//siempre que se pone llave se pone
        //"PathVariable=variable de ruta con variable de tipo id
        Mensaje mensa = new Mensaje();  
        return repoMensa.findById(id).get();
    }
    
    //caso c) Guardar
    @PostMapping("/mensaje")
    public Estatus guardar(@RequestBody String json) throws Exception{
    // primero cnvertimos este string json a un objeto java
    
    ObjectMapper mapper=new ObjectMapper();
   Mensaje mensa =mapper.readValue(json, Mensaje.class);// para que no nos marque error debemos poner un "throws"
       System.out.println("este mensaje se convirtio"+mensa);
       repoMensa.save(mensa);
        Estatus estatus=new Estatus();
        estatus.setMensaje("true");
        estatus.setMensaje("mensaje guardado con exito!!!");
        return estatus;
    }

}
