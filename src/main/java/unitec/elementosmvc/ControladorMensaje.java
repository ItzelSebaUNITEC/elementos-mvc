/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitec.elementosmvc;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@GetMapping("/mensaje {id}")//as llaves significan que el ususario necesita introducir un valor 
    public Mensaje buscarPorId(@PathVariable String id){//siempre que se pone llave se pone
        //"PathVariable=variable de ruta con variable de tipo id
        Mensaje mensa = new Mensaje();  
        return repoMensa.findById(id).get();
    }
    

}
