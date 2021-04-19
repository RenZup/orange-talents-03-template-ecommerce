package orangetalents03templateecommerce.produto.imagem;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UploadDeImagemFake implements IUploadDeImagens{
    @Override
    public String save(String nomeDoArquivo, byte[] conteudoDoArquivo) {

        String link = String.format("%s-%s",nomeDoArquivo, UUID.randomUUID());

        return "http://imagens.com/" + link;
    }
}
