package orangetalents03templateecommerce.categoria;

import org.apache.coyote.Response;
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
@RequestMapping("/categorias")
public class CategoriaController {

    @PersistenceContext
    EntityManager em;

    @PostMapping
    @Transactional
    public ResponseEntity<CategoriaResponseDto> criar(@RequestBody @Valid CategoriaRequestForm form, UriComponentsBuilder uriBuilder){
        Categoria categoria = form.toCategoria(em);
        em.persist(categoria);
        CategoriaResponseDto dto = new CategoriaResponseDto(categoria);
        URI uri = uriBuilder.path("categorias/{id}").buildAndExpand(categoria.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaResponseDto>> listar(){
        List<Categoria> lista = em.createQuery("from Categoria", Categoria.class).getResultList();
        return ResponseEntity.ok(CategoriaResponseDto.toCategoria(lista));
    }
}
