package br.com.alura.mvc.mudi.controller;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

//anotando como controlador
@Controller
public class HomeController {

    @Autowired
    private PedidoRepository pedidoRepository;

    //path
    @GetMapping("/home")
    public String home(Model model){

        List<Pedido> pedidos = pedidoRepository.findAll();

        //add a lista na requisicao
        model.addAttribute("pedidos", pedidos);

        //retorna a url
        return "home";
    }

}
