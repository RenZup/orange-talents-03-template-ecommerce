package orangetalents03templateecommerce.categoria;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

public class CategoriaResponseDto {
    private Long id;
    private String nome;
    private CategoriaResponseDto categoriaMae;

    public CategoriaResponseDto(Categoria categoria) {
    this.id = categoria.getId();
    this.nome = categoria.getNome();

    if(categoria.getCategoriaMae() != null)
        this.categoriaMae = new CategoriaResponseDto(categoria.getCategoriaMae());
    }

    public static List<CategoriaResponseDto>toCategoria(List<Categoria> lista) {
        return lista.stream().map(CategoriaResponseDto::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public CategoriaResponseDto getCategoriaMae() {
        return categoriaMae;
    }
}
