package com.Tobeto.RentaCar.service.concretes;

import com.Tobeto.RentaCar.core.utilites.mappers.ModelMapperService;
import com.Tobeto.RentaCar.entities.Brand;
import com.Tobeto.RentaCar.repositories.BrandRepository;
import com.Tobeto.RentaCar.service.abstracts.BrandService;
import com.Tobeto.RentaCar.service.dto.request.Brand.AddBrandRequest;
import com.Tobeto.RentaCar.service.dto.request.Brand.UpdateBrandRequest;
import com.Tobeto.RentaCar.service.dto.response.Brand.GetBrandListResponse;
import com.Tobeto.RentaCar.service.dto.response.Brand.GetBrandResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BrandManager implements BrandService {

    private final BrandRepository brandRepository;
    private  ModelMapperService modelMappers;
    @Override
    public void add(AddBrandRequest addBrandRequest) {

        if (brandRepository.existsByName(addBrandRequest.getName().trim()))
            throw new RuntimeException("Aynı isimle iki marka gönderilemez");
        // Auto mapping işlemi yapıldı
        Brand brand = this.modelMappers.forRequest().map(addBrandRequest, Brand.class);
        this.brandRepository.save(brand);
    }
    @Override
    public GetBrandResponse getById(int id) {
        return null;
    }

    @Override // get list eklenecek
    public List<Brand> getAll() {
         return brandRepository.findAll();
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest, int id) {

    }

    @Override
    public void delete(int id) {

    }
}
