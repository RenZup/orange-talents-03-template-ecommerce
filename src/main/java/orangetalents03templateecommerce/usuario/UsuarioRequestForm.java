package orangetalents03templateecommerce.usuario;


import orangetalents03templateecommerce.compartilhado.UniqueValue;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UsuarioRequestForm {
    private @NotBlank @Email(message = "Email Invalido")
    @UniqueValue(domainClass = Usuario.class,fieldName = "email") String email;
    private @NotBlank @Size(min = 6,message = "Tamanho minimo de 6 caracteres") String senha;

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public Usuario toUsuario(){
        Usuario usuario = new Usuario(email,senha);
        return usuario;
    }
}
