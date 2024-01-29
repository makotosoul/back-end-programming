package chapter2.assignment1.hello_thymeleaf.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloThymeleaf {
@GetMapping("/hello")
    public String greeting(@RequestParam(name = "name") String name,@RequestParam(name ="age") Integer age, Model model) {
        model.addAttribute("age",age);
        model.addAttribute("name", name);
        return "hello";
    }
}
