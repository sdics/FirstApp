package site.metacoding.firstapp.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductCointroller {

    @GetMapping("/")
    public String home() {
        return "home";
    }
}
