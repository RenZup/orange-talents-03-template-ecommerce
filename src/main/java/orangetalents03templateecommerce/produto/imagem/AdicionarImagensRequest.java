package orangetalents03templateecommerce.produto.imagem;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class AdicionarImagensRequest {
    @NotNull
    @Size(min = 1)
    List<MultipartFile> listaDeImagens = new ArrayList<>();

    public List<MultipartFile> getListaDeImagens() {
        return listaDeImagens;
    }

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public AdicionarImagensRequest(@NotNull @Size(min = 1) List<MultipartFile> listaDeImagens) {
        this.listaDeImagens = listaDeImagens;
    }
}
