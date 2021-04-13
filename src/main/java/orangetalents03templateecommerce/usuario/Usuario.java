package orangetalents03templateecommerce.usuario;

import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(nullable = false)
    private LocalDateTime instante =LocalDateTime.now();
    @Column(nullable = false)
    private @Email @NotBlank String login;
    @Column(nullable = false)
    private @Size(min = 6) @NotBlank String senha;

    @Deprecated/** Hibernate only */
    public Usuario() {
    }

    public Usuario(String login, String senha) {
        Assert.notNull(login,"Email nulo");
        Assert.notNull(senha,"Senha nula");
        this.login = login;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getInstante() {
        return instante;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }
}
