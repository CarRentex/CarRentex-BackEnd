package com.Tobeto.RentaCar.service.concretes;

import com.Tobeto.RentaCar.core.services.WebClientService;
import com.Tobeto.RentaCar.core.utilites.mappers.ModelMapperService;
import com.Tobeto.RentaCar.entities.concretes.City;
import com.Tobeto.RentaCar.entities.concretes.District;
import com.Tobeto.RentaCar.repositories.CityRepository;
import com.Tobeto.RentaCar.repositories.DistrictRepository;
import com.Tobeto.RentaCar.service.abstracts.DistrictService;
import com.Tobeto.RentaCar.service.dto.request.District.CreateDistrictRequest;
import com.Tobeto.RentaCar.service.dto.response.City.GetListCityResponse;
import com.Tobeto.RentaCar.service.dto.response.District.GetDistrictResponse;
import com.Tobeto.RentaCar.service.dto.response.District.GetListDistrictResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DistrictManager implements DistrictService {
    private final DistrictRepository districtRepository;
    private final WebClientService webClientService;
    private final ModelMapperService mapperService;
    private final CityRepository cityRepository;

    @Override
    public void create(CreateDistrictRequest createDistrictRequest) {
        Mono<List<GetListCityResponse>> cityDataMono = webClientService.CityAllRequest();

        // Alınan verileri işle ve veritabanına kaydet
        cityDataMono.subscribe(cityDataList -> {
            for (GetListCityResponse cityResponse : cityDataList) {
                City cityEntity = mapperService.forRequest().map(cityResponse, City.class);

                // İlgili şehir bilgisi veritabanına kaydediliyor
                cityEntity = cityRepository.save(cityEntity);

                // Şehre bağlı ilçeleri kaydet
                for (GetListDistrictResponse districtResponse : cityResponse.getDistricts()) {
                    District districtEntity = mapperService.forRequest().map(districtResponse, District.class);
                    districtEntity.setCity(cityEntity);
                    districtRepository.save(districtEntity);
                }
            }
        });
    }

    @Override
    public List<GetDistrictResponse> getById(int id) {
        List<District> district = districtRepository.findAllByCityId(id);
        List<GetDistrictResponse> getDistrictResponses = district.stream()
                .map(district1 -> this.mapperService.forResponse()
                        .map(district1, GetDistrictResponse.class)).collect(Collectors.toList());
        return getDistrictResponses;
    }

    @Override
    public List<GetListDistrictResponse> getAll() {

        List<District> districts =  districtRepository.findAll();
        List<GetListDistrictResponse> getListDistrictResponses = districts.stream()
                .map(district->this.mapperService.forResponse()
                        .map(district, GetListDistrictResponse.class)).collect(Collectors.toList());
        return getListDistrictResponses;
    }

    @Override
    public void delete(int id) {
        districtRepository.deleteById(id);
    }
}
