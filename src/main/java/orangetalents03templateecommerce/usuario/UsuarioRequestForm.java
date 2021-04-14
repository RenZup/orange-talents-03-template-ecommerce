package orangetalents03templateecommerce.usuario;


import com.fasterxml.jackson.annotation.JsonAlias;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UsuarioRequestForm {
    private @NotBlank @Email(message = "Email Invalido") String email;
    private @NotBlank @Size(min = 6,message = "Tamanho minimo de 6 caracteres") String senha;

    public Usuario toUsuario(){
        Usuario usuario = new Usuario(email,senha);
        return usuario;
    }
}
