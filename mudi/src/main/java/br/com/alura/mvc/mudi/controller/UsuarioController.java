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

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private PedidoRepository pedidoRepository;

    //path
    @GetMapping("pedido")           //sabe quem é o usuário logado
    public String home(Model model, Principal principal){

        List<Pedido> pedidos = pedidoRepository.findAllByUsuario(principal.getName());

        //add a lista na requisicao
        model.addAttribute("pedidos", pedidos);

        //retorna a url
        return "usuario/home";
    }

    //path
    @GetMapping("pedido/{status}") //Spring pega pra mim uma variável status que vem do path
    public String porStatus(@PathVariable("status")String status, Model model, Principal principal){
        //convertendo a String para um StatusPedido
        List<Pedido> pedidos = pedidoRepository.findByStatusUser(StatusPedido.valueOf(status.toUpperCase()), principal.getName());

        //add a lista na requisicao
        model.addAttribute("pedidos", pedidos);
        model.addAttribute("status", status);
        //retorna a url
        return "usuario/home";
    }

    //mapeando para lidar com erros
    @ExceptionHandler(IllegalArgumentException.class)
    public String onError(){
        return "redirect:/usuario/home";
    }

}



