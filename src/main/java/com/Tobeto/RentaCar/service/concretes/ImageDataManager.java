package com.Tobeto.RentaCar.service.concretes;

import com.Tobeto.RentaCar.core.services.CloudinaryService;
import com.Tobeto.RentaCar.core.utilites.Image.ImageUtils;
import com.Tobeto.RentaCar.entities.concretes.ImageData;
import com.Tobeto.RentaCar.repositories.ImageDataRepository;
import com.Tobeto.RentaCar.service.abstracts.ImageDataService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ImageDataManager implements ImageDataService {

    private final ImageDataRepository dataRepository;
    private final CloudinaryService cloudinaryService;
    private final Cloudinary cloudinary;

    @Override
    public String uploadImage(MultipartFile file) throws IOException {
        ImageData imageData = ImageData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtils.compressImage(file.getBytes())).build();

        Map<String, String> params = ObjectUtils.asMap(
                "use_filename", file.getName(),
                "unique_filename", true,
                "overwrite", true
        );

         imageData.setImageUrl(cloudinary.uploader().upload(file.getBytes(), params)
                 .get("url")
                 .toString());
         dataRepository.save(imageData);
            return imageData.getImageUrl();

    }

    @Override
    public byte[] downloadImage(String fileName) {
        Optional<ImageData> dbImageData = dataRepository.findByName(fileName);
        byte[] images = ImageUtils.decompressImage(dbImageData.get().getImageData());
        return images;

    }
}
