package principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import principal.modelo.TablasBBDD;
import principal.modelo.Usuario;
import principal.servicio.imp.UsuarioServiceImpl;

 



@SpringBootApplication
public class Main {
	
	@Autowired
	private UsuarioServiceImpl usuarioService;

		public static void main(String[] args) {
			
			
			TablasBBDD t = new TablasBBDD();
			t.crearTablas();
			
			
			
		
			
			
			
		
			
			SpringApplication.run(Main.class, args);
	}

}