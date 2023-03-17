package principal.servicio.imp;



import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

import principal.modelo.Rol;
import principal.persistencia.RolRepo;
import principal.servicio.interfaces.RolService;

@Service
public class RolServiceImpl implements RolService {
	
	@Autowired
	private RolRepo rolRepo;
	


	@Override
	public Rol obtenerRolPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return rolRepo.findByNombre(nombre);
	}



	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
