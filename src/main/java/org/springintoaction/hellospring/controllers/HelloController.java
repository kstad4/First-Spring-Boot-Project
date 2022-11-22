package org.springintoaction.hellospring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("hello")
public class HelloController {

    //handles requests at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    //lives at /hello/goodbye
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    //handles requests of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name, Model model) {
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);

        return "hello";
    }

    //handles requests of the form /hello/name
    @GetMapping("{name}")
    public String helloWithPathParma(@PathVariable String name, Model model) {
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);

        return "hello";
    }

    //lives at /hello/hello-world
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello-world")
    @ResponseBody
    public String createMessage(@RequestParam String name, @RequestParam String language) {
        String message = "";
        if (name.isBlank()) {
            name = "World";
        }

        if (language.equals("French")) {
                message = "Bonjour " + name + "!";
            } else if (language.equals("German")) {
                message = "Güten tag " + name + "!";
            } else if (language.equals("Spanish")) {
                message = "¡Hola  " + name + "!";
            } else if (language.equals("Italian")) {
                message = "Ciao " + name + "!";
            } else if (language.equals("English")) {
                message = "Hello " + name + "!";
            }
        return message;
    }

    // /hello/form
    @GetMapping("form")
        public String helloForm () {
            return "form";
    }

    @GetMapping("hello-names")
    public String helloNames (Model model) {
        List<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Java");
        names.add("Javascript");
        model.addAttribute("names", names);
        return "hello-list";
    }


    // /hello/language-form
    @GetMapping("language-form")
    @ResponseBody
    public String languageForm () {
        return "<html>" +
                    "<body>" +
                        "<form action='/hello/hello-world' method='post'>" + //submit a request to /hello-world
                            "<input type='text' name='name'>" +
                            "<select name='language'>" +
                                "<option>Select a Language</option>" +
                                "<option>French</option>" +
                                "<option>German</option>" +
                                "<option>Spanish</option>" +
                                "<option>Italian</option>" +
                                "<option>English</option>" +
                            "</select>" +
                            "<input type='submit' value='Greet me!'>" +
                        "</form>" +
                    "</body>" +
                "</html>";
    }

}
