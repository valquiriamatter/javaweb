package br.com.alura.mvc.mudi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/hello") //path
    public String hello(Model model){
        //add atributo
        model.addAttribute("nome", "Mundo");
        return "hello"; //nome da view
    }

}
