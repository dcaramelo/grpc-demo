package demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldHttpService {

    private Process process;

    @Autowired
    public HelloWorldHttpService(final Process process) {
        this.process = process;
    }

    @RequestMapping("/hello-world")
    public @ResponseBody
    String helloWorld(@RequestParam(value = "name") final String name) {
        return process.transform(name);
    }
}
