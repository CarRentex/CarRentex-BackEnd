package com.Tobeto.RentaCar.service.concretes;
import com.Tobeto.RentaCar.core.utilites.mappers.ModelMapperService;
import com.Tobeto.RentaCar.entities.Model;
import com.Tobeto.RentaCar.repositories.ModelRepository;
import com.Tobeto.RentaCar.service.abstracts.ModelService;
import com.Tobeto.RentaCar.service.dto.request.Model.AddModelRequest;
import com.Tobeto.RentaCar.service.dto.request.Model.UpdateModelRequest;
import com.Tobeto.RentaCar.service.dto.response.Model.GetModelListResponse;
import com.Tobeto.RentaCar.service.dto.response.Model.GetModelResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private final ModelRepository modelRepository;
    private ModelMapperService mapperService;

    @Override
    public List<GetModelListResponse> getAll() {
        List<Model> model =  modelRepository.findAll();
        List<GetModelListResponse> getModelListResponses = model.stream()
                .map(color->this.mapperService.forResponse()
                        .map(color, GetModelListResponse.class)).collect(Collectors.toList());
        return getModelListResponses;
    }
    @Override
    public GetModelResponse getById(int id) {
        Model model = modelRepository.findById(id).orElseThrow();
        GetModelResponse response = mapperService.forResponse().map(model, GetModelResponse.class);
        return response;
    }

    @Override
    public void create (AddModelRequest addModelRequest) {
        if (modelRepository.existsByName(addModelRequest.getName()))
            throw new RuntimeException("Model available in the system");

        Model model = mapperService.forRequest().map(addModelRequest, Model.class);
        modelRepository.save(model);

    }

    @Override
    public void update(UpdateModelRequest modelRequest) {
            Model model = mapperService.forRequest().map(modelRequest, Model.class);
            modelRepository.save(model);
    }
    @Override
    public void delete(int id) {
        modelRepository.deleteById(id);
    }
}


