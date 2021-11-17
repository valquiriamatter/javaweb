package br.com.alura.mvc.mudi.api;

import br.com.alura.mvc.mudi.dto.RequisicaoNovaOferta;
import br.com.alura.mvc.mudi.model.Oferta;
import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/ofertas")
public class OfertasRest {

    @Autowired
    private PedidoRepository pedidoRepository;

    @PostMapping            //preenche com os dados da requisicao
    public Oferta criaOferta(@Valid @RequestBody RequisicaoNovaOferta requisicao){

        //recebe o pedido do banco de dados
        Optional<Pedido> pedidoBuscado = pedidoRepository.findById(requisicao.getIdPedido());

        if(!pedidoBuscado.isPresent()){
            return null;
        }

        //converte o Option para Pedido
        Pedido pedido = pedidoBuscado.get();

        //converte o DTO para Oferta
        Oferta novaOferta = requisicao.toOferta();

        //seta o pedido na nova oferta
        novaOferta.setPedido(pedido);
        pedido.getOfertas().add(novaOferta);
        pedidoRepository.save(pedido);
        System.out.println(pedido);

        return novaOferta;
        //return ResponseEntity.ok().body(novaOferta); resposta com texto no corpo junto com o erro 200.
    }

}
