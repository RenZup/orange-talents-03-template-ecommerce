package orangetalents03templateecommerce.usuario;

public class UsuarioResponseDto {
    private String login;

    public UsuarioResponseDto(Usuario usuario) {
        this.login = usuario.getLogin();
    }

    public String getLogin() {
        return login;
    }
}
