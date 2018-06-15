package unitec.elementosmvc;
import java.time.LocalDate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class ElementosMvcApplication implements CommandLineRunner{
    
    @Autowired ServicioTarjeta servicio;
    @Autowired RepositorioMensaje repoMensaje;

	public static void main(String[] args) {
		SpringApplication.run(ElementosMvcApplication.class, args);
	}
        @Override
        public void run (String... args) throws  Exception{
            
            //servicio.ObtenerSaldo().ObtenerSaldo();
            //LocalDate fecha= LocalDate.now();
            //repoMensaje.save(new Mensaje(fecha,"Mi primer mensaje"));
           // 2.buscar todos los mensajes ya 
                  //  for(Mensaje mensa: repoMensaje.findAll())
                   // {
                   //     System.out.println(mensa);
                  //  }
                  
                  //3.Mensaje por id
                  
                  //System.out.println(repoMensaje.findbyId(""),get());
                  
                  //3.1 buscar por otro campo 
                 // System.out.println(repoMensaje.findByCuerpo("cerdito"));
                    
            //4.Actuañlizar mensaje 
            //5.Eliminar un mensaje 
            
            //Mensaje e=new Mensaje();
            //e.setId("hola");
           // repoMensaje.deleteById("");
        }
}
