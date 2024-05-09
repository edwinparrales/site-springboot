package epv.tecnologia.site3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("web/producto")
public class ProductoController {
    @GetMapping
    public String inicio(Model model){
        return "producto/producto-list.html";
    }
}
