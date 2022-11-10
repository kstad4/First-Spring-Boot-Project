package org.springintoaction.hellospring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    //handles requests at path 8080/hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    //this method lives at /hello/goodbye after putting the requestmapping at the top of the class
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    //create handler that handles requests of the form /hello?name=LaunchCode
    //now lives at /hello/hello
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    //handles requests of the form /hello/name
    @GetMapping("{name}")
        public String helloWithPathParma(@PathVariable String name) {
            return "Hello, " + name + "!";
    }

    @GetMapping("form")
        public String helloForm () {
            return "<html>" +
                    "<body>" +
                    "<form action='hello' method='post'>" + //submit a request to /hello
                    "<input type='text' name='name'>" +
                    "<input type='submit' value='Greet me!'>" +
                    "</form>" +
                    "</body>" +
                    "</html>";
    }



}
