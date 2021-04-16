package orangetalents03templateecommerce.produto.caracteristica;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.stream.Collectors;

public class CaracteristicaRequestForm {
    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;

    public static List<Caracteristica> toModel(List<CaracteristicaRequestForm> form) {
        return form.stream().map(Caracteristica::new).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "CaracteristicaRequestForm{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
