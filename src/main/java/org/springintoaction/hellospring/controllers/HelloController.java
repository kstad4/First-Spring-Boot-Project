package org.springintoaction.hellospring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
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
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    //handles requests of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    //handles requests of the form /hello/name
    @GetMapping("{name}")
        public String helloWithPathParma(@PathVariable String name) {
            return "Hello, " + name + "!";
    }

    //lives at /hello/hello-world
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello-world")
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
            return "<html>" +
                    "<body>" +
                    "<form action='/hello' method='post'>" + //submit a request to /hello
                    "<input type='text' name='name'>" +
                    "<input type='submit' value='Greet me!'>" +
                    "</form>" +
                    "</body>" +
                    "</html>";
    }

    // /hello/language-form
    @GetMapping("language-form")
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
