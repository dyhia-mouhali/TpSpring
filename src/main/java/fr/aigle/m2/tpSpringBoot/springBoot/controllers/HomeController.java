package fr.aigle.m2.tpSpringBoot.springBoot.controllers;

import fr.aigle.m2.tpSpringBoot.springBoot.models.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class HomeController {

    @Value("${app.version}")
    private String appVersion;

    @GetMapping
    @RequestMapping("/")
    public Map get() {
        Map<String, String> map = new HashMap();
        map.put("Version de l'application ",appVersion);
        return map;
    }


}
