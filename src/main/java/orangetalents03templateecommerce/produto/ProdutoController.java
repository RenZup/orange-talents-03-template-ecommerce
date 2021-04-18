package orangetalents03templateecommerce.produto;

import io.jsonwebtoken.lang.Assert;
import orangetalents03templateecommerce.categoria.Categoria;
import orangetalents03templateecommerce.produto.caracteristica.Caracteristica;
import orangetalents03templateecommerce.produto.caracteristica.CaracteristicaRequestForm;
import orangetalents03templateecommerce.usuario.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @PersistenceContext
    EntityManager em;

    @PostMapping
    @Transactional
    public ResponseEntity<?> criar (@RequestBody @Valid ProdutoRequestForm form, UriComponentsBuilder uriBuilder){
        List<Caracteristica> caracteristicas = CaracteristicaRequestForm.toModel(form.getCaracteristicas());
        Assert.notNull(caracteristicas);

        Categoria categoria = em.find(Categoria.class,form.getIdCategoria());
        Assert.notNull(categoria);

        Usuario dono = em.find(Usuario.class,form.getIdDono());
        Assert.notNull(dono);

        Produto produto = form.toModel(caracteristicas,categoria,dono);

        for (Caracteristica caracteristica : caracteristicas) {
            em.persist(caracteristica);
        }
        em.persist(produto);

        URI uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).body(new ProdutoResponseDto(produto));
    }

    @GetMapping
    public ResponseEntity<?> listar(){
        List<Produto> produtos = em.createQuery("from Produto", Produto.class).getResultList();
        return ResponseEntity.ok(ProdutoResponseDto.toProdutoDtoList(produtos));
    }

}
