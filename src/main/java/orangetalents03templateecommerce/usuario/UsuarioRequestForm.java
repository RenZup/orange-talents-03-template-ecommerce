package orangetalents03templateecommerce.usuario;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UsuarioRequestForm {
    private @NotBlank @Email(message = "Email Invalido") String login;
    private @NotBlank @Size(min = 6,message = "Tamanho minimo de 6 caracteres") String senha;

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    private String criptografaSenha(String senha){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(senha);
    }

    public Usuario toUsuario(){
        Usuario usuario = new Usuario(login,criptografaSenha(senha));
        return usuario;
    }
}
