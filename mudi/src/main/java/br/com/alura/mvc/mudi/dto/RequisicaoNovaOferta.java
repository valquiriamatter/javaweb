package br.com.alura.mvc.mudi.dto;

import br.com.alura.mvc.mudi.model.Oferta;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RequisicaoNovaOferta {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");


    private Long idPedido;
    @NotNull //começa com dígito, "\" é caractere especial, então tem que escapar ela, por 2x, + dígitos {2} digitos
    @Pattern(regexp = "^\\d+(\\.\\d{2})?$") // ? pode ou não vir, $ mais nada
    private String valor;
    @NotNull
    @Pattern(regexp = "^\\d{2}/\\{2}/\\{4}$")
    private String dataEntrega;
    private String comentario;

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Oferta toOferta() {

        Oferta oferta = new Oferta();
        oferta.setComentario(comentario);
        oferta.setDataEntrega(LocalDate.parse(this.dataEntrega, formatter));
        oferta.setValor(new BigDecimal(this.valor));

        return oferta;
    }
}
