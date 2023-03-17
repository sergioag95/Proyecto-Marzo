package principal.servicio.interfaces;

import java.util.List; 

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import principal.modelo.Usuario;
import principal.modelo.dto.UsuarioDTO;

@Service
public interface UsuarioService extends UserDetailsService {
	
	public Usuario insertarUsuario (Usuario user);
	public Usuario insertarusuarioDTO (UsuarioDTO userDTO);
	public List<Usuario> listarUsuarios();
	public Usuario obtenerUsuarioPorID (Integer id);
	public Usuario obtenerUsuarioPorNombre (String nombre);
	public void eliminarUsuario(Usuario user);
	public void eliminarUsuarioPorId(Integer id);
	
}
