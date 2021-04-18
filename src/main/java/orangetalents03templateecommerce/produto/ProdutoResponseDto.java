package orangetalents03templateecommerce.produto;

import orangetalents03templateecommerce.categoria.Categoria;
import orangetalents03templateecommerce.produto.caracteristica.Caracteristica;
import orangetalents03templateecommerce.usuario.Usuario;
import orangetalents03templateecommerce.usuario.UsuarioResponseDto;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ProdutoResponseDto {
    private Long id;
    private String nome;
    private BigInteger valor;
    private int quantidade;
    private List<Caracteristica> caracteristicas;
    private String descricao;
    private Categoria categoria;
    private UsuarioResponseDto dono;
    private LocalDateTime instante = LocalDateTime.now();


    public ProdutoResponseDto(Produto produto){
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.valor=produto.getValor();
        this.quantidade=produto.getQuantidade();
        this.caracteristicas=produto.getCaracteristicas();
        this.descricao=produto.getDescricao();
        this.categoria=produto.getCategoria();
        this.dono = new UsuarioResponseDto(produto.getDono());
    }

    public static List<ProdutoResponseDto> toProdutoDtoList(List<Produto> produtos){
        return produtos.stream().map(ProdutoResponseDto::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
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

    public List<Caracteristica> getCaracteristicas() {
        return caracteristicas;
    }

    public String getDescricao() {
        return descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public UsuarioResponseDto getDono() {
        return dono;
    }

    public LocalDateTime getInstante() {
        return instante;
    }
}
