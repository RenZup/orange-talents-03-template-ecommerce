package orangetalents03templateecommerce.produto;

import orangetalents03templateecommerce.categoria.Categoria;
import orangetalents03templateecommerce.compartilhado.ExistingId;
import orangetalents03templateecommerce.produto.caracteristica.Caracteristica;
import orangetalents03templateecommerce.produto.caracteristica.CaracteristicaRequestForm;
import orangetalents03templateecommerce.usuario.Usuario;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.math.BigInteger;
import java.util.List;

public class ProdutoRequestForm {
    @NotBlank
    private String nome;
    @NotNull
    @Positive
    private BigInteger valor;
    @NotNull
    @PositiveOrZero
    private int quantidade;
    @Size(min = 3)
    @NotNull
    private List<CaracteristicaRequestForm> caracteristicas;
    @NotBlank
    @Length(max = 1000)
    private String descricao;
    @ExistingId(domainClass = Categoria.class, fieldName = "id")
    @NotNull
    private Long idCategoria;
    @ExistingId(domainClass = Usuario.class,fieldName = "id")
    @NotNull
    private Long idDono;

    @Override
    public String toString() {
        return "ProdutoRequestForm{" +
                "nome='" + nome + '\'' +
                ", valor=" + valor +
                ", quantidade=" + quantidade +
                ", caracteristicas=" + caracteristicas +
                ", descricao='" + descricao + '\'' +
                ", idCategoria=" + idCategoria +
                '}';
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

    public List<CaracteristicaRequestForm> getCaracteristicas() {
        return caracteristicas;
    }

    public String getDescricao() {
        return descricao;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public Long getIdDono() {
        return idDono;
    }

    public Produto toModel(List<Caracteristica> caracteristicas, Categoria categoria, Usuario dono) {
        return new Produto(nome,valor,quantidade,caracteristicas,descricao,categoria,dono);
    }
}
