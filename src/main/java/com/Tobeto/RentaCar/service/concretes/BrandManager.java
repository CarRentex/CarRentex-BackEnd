package com.Tobeto.RentaCar.service.concretes;

import com.Tobeto.RentaCar.core.utilites.mappers.ModelMapperService;
import com.Tobeto.RentaCar.entities.Brand;
import com.Tobeto.RentaCar.entities.Car;
import com.Tobeto.RentaCar.entities.Model;
import com.Tobeto.RentaCar.repositories.BrandRepository;
import com.Tobeto.RentaCar.service.abstracts.BrandService;
import com.Tobeto.RentaCar.service.dto.request.Brand.AddBrandRequest;
import com.Tobeto.RentaCar.service.dto.request.Brand.UpdateBrandRequest;
import com.Tobeto.RentaCar.service.dto.response.Brand.GetBrandListResponse;
import com.Tobeto.RentaCar.service.dto.response.Brand.GetBrandResponse;
import com.Tobeto.RentaCar.service.dto.response.Model.GetModelListResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class BrandManager implements BrandService {

    private final BrandRepository brandRepository;
    private  ModelMapperService mapperService;
    @Override
    public void create (AddBrandRequest addBrandRequest) {

        if (brandRepository.existsByName(addBrandRequest.getName().trim()))
            throw new RuntimeException("brand is available in the system");
        // Auto mapping işlemi yapıldı
        Brand brand = this.mapperService.forRequest().map(addBrandRequest, Brand.class);
        this.brandRepository.save(brand);
    }
    @Override
    public GetBrandResponse getById(int id) {
        return null;
    }

    @Override // get list eklenecek
    public List<GetBrandListResponse> getAll() {
        List<Brand> brands=  brandRepository.findAll();
        List<GetBrandListResponse> getBrandListResponses = brands.stream()
                .map(brand->this.mapperService.forResponse()
                        .map(brand, GetBrandListResponse.class)).collect(Collectors.toList());
        return getBrandListResponses;
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = mapperService.forRequest().map(updateBrandRequest, Brand.class);
        brandRepository.save(brand);

    }


    @Override
    public void delete(int id) {

    }
}
