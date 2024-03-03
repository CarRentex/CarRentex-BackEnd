package com.Tobeto.RentaCar.controllers;

import com.Tobeto.RentaCar.service.abstracts.ImageDataService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/imagedata")
@AllArgsConstructor
@CrossOrigin
public class ImageDataController {
    private final ImageDataService dataService;

    @PostMapping(value = "" , consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public String uploadImage(@RequestPart("image") MultipartFile file) throws IOException {
        return dataService.uploadImage(file);
    }

    @GetMapping("/{fileName}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<byte[]> downloadImage(@PathVariable String fileName) {
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(dataService.downloadImage(fileName));
    }
}
