package demo.services;

import demo.beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldHttpService {

    private Process process;

    @Autowired
    public HelloWorldHttpService(final Process process) {
        this.process = process;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/hello-world")
    public @ResponseBody
    String helloWorld(@RequestBody final User user) {
        return process.transform(user.getName());
    }
}
