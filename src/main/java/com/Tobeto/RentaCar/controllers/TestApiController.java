package com.Tobeto.RentaCar.controllers;


import com.Tobeto.RentaCar.core.config.SeedDataConfig;
import com.Tobeto.RentaCar.entities.concretes.City;
import com.Tobeto.RentaCar.repositories.CityRepository;
import com.Tobeto.RentaCar.service.abstracts.CarService;
import com.Tobeto.RentaCar.service.abstracts.CityService;
import com.Tobeto.RentaCar.service.abstracts.DistrictService;
import com.Tobeto.RentaCar.service.abstracts.ImageDataService;
import com.Tobeto.RentaCar.service.dto.request.Car.AddCarRequest;
import com.Tobeto.RentaCar.service.dto.response.City.GetListCityResponse;
import com.Tobeto.RentaCar.service.dto.response.District.GetListDistrictResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.IOException;
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

    private final DistrictService districtService;
    private final SeedDataConfig seedDataConfig;

    // CAR COLOR MODEL BRAND APİSİNE VERİLERİN EKLENMESİ İÇİN YAZILMIŞTIR SADECE 1 KEZ ÇALIŞTIRILMALIDIR
/*
    @GetMapping("seedData")
    public void seedData() {
        seedDataConfig.run();
    }
*/
        //CİTY VE DİSTRİCT APİSİNİN TEST EDİLMESİ BİR KERE ÇALIŞTIRILMALIDIR
/*    @GetMapping("refreshApi")
    public void refreshApi() {
        districtService.create(null);
    }*/




}
