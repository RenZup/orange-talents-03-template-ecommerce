package orangetalents03templateecommerce.usuario;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

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

    /**
     *
     * @param email Deve ser um email valido
     * @param senhaLimpa Deve ser uma senha sem hash
     */
    public Usuario(@Email @NotBlank String email, @NotBlank @Size(min = 6) String senhaLimpa) {
        Assert.hasLength(email,"Email em branco");
        Assert.hasLength(senhaLimpa,"Senha Em Branco");
        Assert.isTrue(senhaLimpa.length() >= 6, "Senha precisa de no minimo 6 caracteres");

        this.login = email;
        this.senha = new BCryptPasswordEncoder().encode(senhaLimpa);
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
