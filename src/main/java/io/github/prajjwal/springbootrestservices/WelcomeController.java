package io.github.prajjwal.springbootrestservices;

import io.github.prajjwal.springbootrestservices.configuration.BasicConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class WelcomeController {
    @Autowired
    private WelcomeService service;

    @Autowired
    private BasicConfiguration configuration;

    @RequestMapping("/welcome")
    public String welcome() {
        return service.retrieveWelcomeMessage();
    }

    @RequestMapping("/dynamic-configuration")
    public Map<String, Object> dynamicConfiguration() {
        Map<String, Object> map = new HashMap<>();
        map.put("message", configuration.getMessage());
        map.put("number", configuration.getNumber());
        map.put("value", configuration.isValue());

        return map;
    }

}
