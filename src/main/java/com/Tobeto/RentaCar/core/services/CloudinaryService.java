package com.Tobeto.RentaCar.core.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
@AllArgsConstructor
public class CloudinaryService {
    private final Cloudinary cloudinary;

    public String uploadImage(MultipartFile file) throws IOException {
        Map<String, String> params = ObjectUtils.asMap(
                "use_filename", file.getName(),
                "unique_filename", true,
                "overwrite", true
        );

        return cloudinary.uploader()
                .upload(file.getBytes(), params)
                .get("url")
                .toString();
    }
}
