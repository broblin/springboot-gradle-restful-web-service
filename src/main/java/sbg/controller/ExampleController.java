package sbg.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class ExampleController {

    @RequestMapping("/example")
    String home() {
        return "Hello World!";
    }
}
