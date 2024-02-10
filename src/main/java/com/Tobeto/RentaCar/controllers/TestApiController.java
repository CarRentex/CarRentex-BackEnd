package com.Tobeto.RentaCar.controllers;


import com.Tobeto.RentaCar.entities.concretes.City;
import com.Tobeto.RentaCar.repositories.CityRepository;
import com.Tobeto.RentaCar.service.abstracts.CityService;
import com.Tobeto.RentaCar.service.abstracts.DistrictService;
import com.Tobeto.RentaCar.service.dto.response.City.GetListCityResponse;
import com.Tobeto.RentaCar.service.dto.response.District.GetListDistrictResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.http.HttpHeaders;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/test")
@AllArgsConstructor
@CrossOrigin
public class TestApiController {


                // APİ TEST İÇİN YAZILMIŞTIR


        //CİTY VE DİSTRİCT APİSİNİN TEST EDİLMESİ
/*
    @GetMapping("refreshApi")
    public void refreshApi() {
        districtService.create(null);
    }*/



/*public class TestApiController {

    private final WebClient webClient;

    @GetMapping("/test")
    public Mono<List<Object>> test() {
        String publicApiUrl = "https://turkiyeapi.dev/api/v1/provinces?fields=name,districts";
        return webClient.get()
                .uri(publicApiUrl)
                .retrieve()
                .bodyToFlux(Object.class)
                .collectList(); // Mono<List<Object>> olarak dönecek
    }
}*/

}
