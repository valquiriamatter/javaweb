package br.com.alura.mvc.mudi.api;

import br.com.alura.mvc.mudi.dto.RequisicaoNovaOferta;
import br.com.alura.mvc.mudi.model.Oferta;
import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/ofertas")
public class OfertasRest {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Oferta criaOferta(RequisicaoNovaOferta requisicaoNovaOferta){

        //recebe o pedido do banco de dados
        Optional<Pedido> pedidoBuscado = pedidoRepository.findById(requisicaoNovaOferta.getIdPedido());

        if(!pedidoBuscado.isPresent()){
            return null;
        }

        //converte o Option para Pedido
        Pedido pedido = pedidoBuscado.get();
        //converte o DTO para Oferta
        Oferta novaOferta = requisicaoNovaOferta.toOferta();
        //seta o pedido na nova oferta
        novaOferta.setPedido(pedido);
        pedido.getOfertas().add(novaOferta);
        pedidoRepository.save(pedido);


        return novaOferta;

    }

}
