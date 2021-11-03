package br.com.alura.mvc.mudi.controller;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

//anotando como controlador
@Controller
@RequestMapping("/home")//define a URL basica do controller
public class HomeController {

    @Autowired
    private PedidoRepository pedidoRepository;

    //path
    @GetMapping                     //sabe quem é o usuário logado
    public String home(Model model, Principal principal){

        Sort sort = Sort.by("dataEntrega").descending();
        PageRequest paginacao = PageRequest.of(0,10, sort);

        List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.ENTREGUE, paginacao);

        //add a lista na requisicao
        model.addAttribute("pedidos", pedidos);

        //retorna a url
        return "home";
    }



}
