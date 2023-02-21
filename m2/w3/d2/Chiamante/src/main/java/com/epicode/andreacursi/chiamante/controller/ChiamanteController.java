package com.epicode.andreacursi.chiamante.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/chiamante")
public class ChiamanteController {

    @GetMapping("/ottienidata1")
    public String m1() {

        RestTemplate rt = new RestTemplate();
        String rtUrl = "http://localhost:8082/chiamato/data1";
        ResponseEntity<String> response = rt.getForEntity(rtUrl, String.class);
        return "Chiamato in data 1 mostra: "+response.getBody();

    }
    
    @GetMapping("/ottienidata2")
    public String m2() {

        RestTemplate rt = new RestTemplate();
        String rtUrl = "http://localhost:8082/chiamato/data2";
        String response = rt.getForObject(rtUrl, String.class);
        return "Lista: " + response;

    }

    @GetMapping("/ottienidata2json")
    public Object m2Json() {
        RestTemplate rt = new RestTemplate();
        String rtUrl = "http://localhost:8082/chiamato/data3";
        Object response = rt.getForObject(rtUrl, Object.class);
        return response;

    }
    
	@PostMapping("/login_success")
	public String login_success() {
		return "login success";
	}
	
}
