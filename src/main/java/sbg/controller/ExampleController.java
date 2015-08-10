package sbg.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class ExampleController {

    @RequestMapping("/example")
    String home(@RequestParam(value="name",defaultValue = "world") String name) {
        return String.format("Hello %s !",name);
    }
}
