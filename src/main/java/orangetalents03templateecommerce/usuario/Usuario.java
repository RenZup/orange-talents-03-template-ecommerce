package orangetalents03templateecommerce.usuario;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    private @Email @NotBlank String email;
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

        this.email = email;
        this.senha = new BCryptPasswordEncoder().encode(senhaLimpa);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", instante=" + instante +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getInstante() {
        return instante;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
}
