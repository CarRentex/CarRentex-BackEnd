//package com.Tobeto.RentaCar.controllers;
//
//import com.Tobeto.RentaCar.core.services.CloudinaryService;
//import lombok.AllArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//
//@RestController
//@RequestMapping("/api/images")
//@AllArgsConstructor
//public class ImageController {
//
//    private CloudinaryService cloudinaryService;
//
//    @PostMapping("/upload")
//    public void uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
//        String imageUrl = cloudinaryService.uploadImage(file);
//
//    }
//}