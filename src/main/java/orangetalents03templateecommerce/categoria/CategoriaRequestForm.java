package orangetalents03templateecommerce.categoria;

import orangetalents03templateecommerce.compartilhado.UniqueValue;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class CategoriaRequestForm {
    @NotBlank
    @UniqueValue(domainClass = Categoria.class,fieldName = "nome")
    private String nome;
    @Positive
    private Long idCategoriaMae;

    public String getNome() {
        return nome;
    }

    public Long getIdCategoriaMae() {
        return idCategoriaMae;
    }

    public Categoria toCategoria(EntityManager em) {
        Categoria categoria = new Categoria(nome);
        if(idCategoriaMae != null){
            Categoria categoriaMae = em.find(Categoria.class, idCategoriaMae);
            Assert.notNull(categoriaMae,"A categoria nao existe");
            categoria.setCategoriaMae(categoriaMae);
        }
        return categoria;
    }
}
