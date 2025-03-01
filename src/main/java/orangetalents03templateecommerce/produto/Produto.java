package orangetalents03templateecommerce.produto;

import orangetalents03templateecommerce.categoria.Categoria;
import orangetalents03templateecommerce.produto.caracteristica.Caracteristica;
import orangetalents03templateecommerce.usuario.Usuario;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private @NotBlank String nome;

    @Column(nullable = false)
    private @NotNull @Positive BigInteger valor;

    @Column(nullable = false)
    private  @NotNull @PositiveOrZero int quantidade;

    @Column(nullable = false)
    @ManyToMany
    private @Size(min = 3) @NotNull List<Caracteristica> caracteristicas;

    @Column(nullable = false)
    private @NotBlank @Length(max = 1000) String descricao;

    @ManyToOne
    private @NotNull Categoria categoria;

    @ManyToOne
    private @NotNull Usuario dono;

    @Column(nullable = false)
    private LocalDateTime instante = LocalDateTime.now();

    @ElementCollection
    private List<String> urlImagens;


    public Produto() {
    }

    public Produto(@NotBlank String nome, @NotNull @Positive BigInteger valor,
                   @NotNull @PositiveOrZero int quantidade, @Size(min = 3) @NotNull List<Caracteristica> caracteristicas,
                   @NotBlank @Length(max = 1000) String descricao, @NotNull Categoria categoria, @NotNull Usuario dono) {
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.caracteristicas = caracteristicas;
        this.descricao = descricao;
        this.categoria = categoria;
        this.dono = dono;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", valor=" + valor +
                ", quantidade=" + quantidade +
                ", caracteristicas=" + caracteristicas +
                ", descricao='" + descricao + '\'' +
                ", categoria=" + categoria +
                ", dono=" + dono +
                ", instante=" + instante +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public BigInteger getValor() {
        return valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public List<Caracteristica> getCaracteristicas() {
        return caracteristicas;
    }

    public String getDescricao() {
        return descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public LocalDateTime getInstante() {
        return instante;
    }

    public Usuario getDono() {
        return dono;
    }

    public List<String> getUrlImagens() {
        return urlImagens;
    }

    public void adicionarImagens(List<String> imagens){
        urlImagens.addAll(imagens);
    }
}
