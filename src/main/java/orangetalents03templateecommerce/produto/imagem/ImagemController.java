package orangetalents03templateecommerce.produto.imagem;

import io.jsonwebtoken.lang.Assert;
import orangetalents03templateecommerce.compartilhado.UsuarioLogado;
import orangetalents03templateecommerce.produto.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/{idProduto}/imagens")
public class ImagemController {

    @Autowired
    IUploadDeImagens uploadDeImagens;

    @PersistenceContext
    EntityManager em;

    @PostMapping
    @Transactional
    public ResponseEntity<?> criar(@Valid AdicionarImagensRequest request, @PathVariable Long idProduto, @AuthenticationPrincipal UsuarioLogado usuarioLogado){

        Produto produto = em.find(Produto.class, idProduto);
        if(produto == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Produto com id " + idProduto + " nao encontrado");
        }
        if(produto.getDono().getId() != usuarioLogado.get().getId()){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }


        List<String> imagens = request.getListaDeImagens().stream().map(multipartFile -> {
            try {
                return uploadDeImagens.save(multipartFile.getOriginalFilename(),multipartFile.getBytes());
            } catch (IOException e) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Nao foi possivel salvar a imagem");
            }
        }).collect(Collectors.toList());

        produto.adicionarImagens(imagens);

        return ResponseEntity.ok(imagens);
    }


}
