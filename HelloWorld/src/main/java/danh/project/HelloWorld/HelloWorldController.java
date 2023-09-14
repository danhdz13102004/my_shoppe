package danh.project.HelloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("/")
    public String index() {
        return "hello world";
    }
    @GetMapping("/h2")
    public String index2() {
        return "hello world";
    }
}
