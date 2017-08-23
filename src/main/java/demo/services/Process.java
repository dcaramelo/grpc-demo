package demo.services;

import org.springframework.stereotype.Service;

@Service
public class Process {
    String transform(String name) {
        return "Hello " + name;
    }

}
