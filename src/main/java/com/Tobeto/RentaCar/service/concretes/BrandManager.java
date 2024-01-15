package com.Tobeto.RentaCar.service.concretes;

import com.Tobeto.RentaCar.core.utilites.mappers.ModelMapperService;
import com.Tobeto.RentaCar.entities.concretes.Brand;
import com.Tobeto.RentaCar.repositories.BrandRepository;
import com.Tobeto.RentaCar.rules.brand.BrandBusinessRuleManager;
import com.Tobeto.RentaCar.service.abstracts.BrandService;
import com.Tobeto.RentaCar.service.dto.request.Brand.AddBrandRequest;
import com.Tobeto.RentaCar.service.dto.request.Brand.UpdateBrandRequest;
import com.Tobeto.RentaCar.service.dto.response.Brand.GetBrandListResponse;
import com.Tobeto.RentaCar.service.dto.response.Brand.GetBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class BrandManager implements BrandService {

    private final BrandRepository brandRepository;
    private  ModelMapperService mapperService;
    private final BrandBusinessRuleManager brandBusinessRuleManager;
    @Override
    public void create (AddBrandRequest addBrandRequest) {
        //business rules
        brandBusinessRuleManager.checkIfBrandNameExists(addBrandRequest);
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
        brandBusinessRuleManager.checkIfBrandNameExists(updateBrandRequest);
        Brand brand = mapperService.forRequest().map(updateBrandRequest, Brand.class);
        brandRepository.save(brand);

    }


    @Override
    public void delete(int id) {
        brandRepository.deleteById(id);
    }
}
