package com.Tobeto.RentaCar.service.concretes;

import com.Tobeto.RentaCar.core.utilites.mappers.ModelMapperService;
import com.Tobeto.RentaCar.entities.concretes.Location;
import com.Tobeto.RentaCar.repositories.LocationRepository;
import com.Tobeto.RentaCar.service.abstracts.LocationService;
import com.Tobeto.RentaCar.service.dto.request.Location.CreateLocationRequest;
import com.Tobeto.RentaCar.service.dto.response.Location.GetListLocationResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LocationManager implements LocationService {

    private final ModelMapperService modelMapperService;
    private final LocationRepository locationRepository;

    @Override
    public void create(CreateLocationRequest createLocation) {
        Location location = this.modelMapperService.forRequest().map(createLocation, Location.class);
        locationRepository.save(location);
    }

    @Override
    public List<GetListLocationResponse> getAll() {
        List<Location> locations = locationRepository.findAll();
        List<GetListLocationResponse> locationResponses = locations.stream()
                .map(location -> this.modelMapperService
                        .forResponse().map(location, GetListLocationResponse.class))
                .collect(Collectors.toList());
        return locationResponses;
    }

    @Override
    public GetListLocationResponse getById(int id) {
        Location location = locationRepository.findById(((long) id)).orElseThrow();
        return this.modelMapperService.forResponse().map(location, GetListLocationResponse.class);
    }
}