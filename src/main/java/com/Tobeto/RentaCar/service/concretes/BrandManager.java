package com.Tobeto.RentaCar.service.concretes;

import com.Tobeto.RentaCar.service.abstracts.BrandService;
import com.Tobeto.RentaCar.service.dto.request.Brand.AddBrandRequest;
import com.Tobeto.RentaCar.service.dto.request.Brand.UpdateBrandRequest;
import com.Tobeto.RentaCar.service.dto.response.Brand.GetBrandListResponse;
import com.Tobeto.RentaCar.service.dto.response.Brand.GetBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BrandManager implements BrandService {
    @Override
    public void add(AddBrandRequest addBrandRequest) {

    }

    @Override
    public GetBrandResponse getById(int id) {
        return null;
    }

    @Override
    public List<GetBrandListResponse> getAll() {
        return null;
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest, int id) {

    }

    @Override
    public void delete(int id) {

    }
}
