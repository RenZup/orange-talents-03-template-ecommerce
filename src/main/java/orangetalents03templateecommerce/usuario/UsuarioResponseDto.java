package orangetalents03templateecommerce.usuario;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioResponseDto {
    private String email;

    public UsuarioResponseDto(Usuario usuario) {
        this.email = usuario.getEmail();
    }

    public String getEmail() {
        return email;
    }

    public static List<UsuarioResponseDto> toDtoList(List<Usuario> lista){
        return  lista.stream().map(UsuarioResponseDto::new).collect(Collectors.toList());
    }

}
