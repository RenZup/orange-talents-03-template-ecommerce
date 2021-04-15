package orangetalents03templateecommerce.compartilhado;

import orangetalents03templateecommerce.compartilhado.seguranca.UserDetailsMapper;
import orangetalents03templateecommerce.usuario.Usuario;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;


@Configuration
public class AppUserDetailsMapper implements UserDetailsMapper {

	@Override
	public UserDetails map(Object shouldBeASystemUser) {						
		return new UsuarioLogado((Usuario) shouldBeASystemUser);
	}

}
