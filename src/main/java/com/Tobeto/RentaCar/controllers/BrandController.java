package com.Tobeto.RentaCar.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/brand")
public class BrandController {
    @GetMapping
    public  void Brand() {
        return;
    }
}
