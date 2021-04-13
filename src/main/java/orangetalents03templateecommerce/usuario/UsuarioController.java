package orangetalents03templateecommerce.usuario;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @PersistenceContext
    EntityManager em;

    @PostMapping
    @Transactional
    public ResponseEntity<UsuarioResponseDto> criar(@RequestBody @Valid UsuarioRequestForm form, UriComponentsBuilder uriBuilder){
        Usuario usuario = form.toUsuario();
        em.persist(usuario);
        URI uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        UsuarioResponseDto dto = new UsuarioResponseDto(usuario);
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    public ResponseEntity<List> listar(){
        Query query = em.createQuery("from Usuario");
        return ResponseEntity.ok().body(query.getResultList());
    }

}
