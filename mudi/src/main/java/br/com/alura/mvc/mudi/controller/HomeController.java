package br.com.alura.mvc.mudi.controller;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//anotando como controlador
@Controller
@RequestMapping("/home")//define a URL basica do controller
public class HomeController {

    @Autowired
    private PedidoRepository pedidoRepository;

    //path
    @GetMapping
    public String home(Model model){

        List<Pedido> pedidos = pedidoRepository.findAll();

        //add a lista na requisicao
        model.addAttribute("pedidos", pedidos);

        //retorna a url
        return "home";
    }

    //path
    @GetMapping("/{status}") //Spring pega pra mim uma variável status que vem do path
    public String porStatus(@PathVariable("status")String status, Model model){
                                                            //convertendo a String para um StatusPedido
        List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));

        //add a lista na requisicao
        model.addAttribute("pedidos", pedidos);
        model.addAttribute("status", status);
        //retorna a url
        return "home";
    }

    //mapeando para lidar com erros
    @ExceptionHandler(IllegalArgumentException.class)
    public String onError(){
        return "redirect:/home";
    }

}
