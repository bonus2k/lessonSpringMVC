package ru.snkatvit.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {
//        String name = request.getParameter("name");
//        String surname = request.getParameter("surname");
//        System.out.println("Hello, " + name + " " + surname);
        model.addAttribute("message", "Hello, " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "a", required = false) Double a,
                             @RequestParam(value = "b", required = false) Double b,
                             @RequestParam(value = "operation", required = false) String operation,
                             Model model) {
        String result;
        switch (operation) {
            case "multiplication":
                result = String.valueOf(a * b);
                break;
            case "addition":
                result = String.valueOf(a + b);
                break;
            case "subtraction":
                result = String.valueOf(a - b);
                break;
            case "division":
                result = String.valueOf(a / b);
                break;
            default:
                result = "Bad request";
        }

        model.addAttribute("total", "Total " + result);
        return "first/calculator";
    }
}
