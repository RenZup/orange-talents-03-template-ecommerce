package orangetalents03templateecommerce.produto.imagem;

import org.springframework.web.multipart.MultipartFile;

public interface IUploadDeImagens {
    String save(String nomeDoArquivo,byte[] conteudoDoArquivo);
}
