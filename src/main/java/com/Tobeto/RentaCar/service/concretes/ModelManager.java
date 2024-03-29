package com.Tobeto.RentaCar.service.concretes;
import com.Tobeto.RentaCar.core.utilites.mappers.ModelMapperService;
import com.Tobeto.RentaCar.entities.concretes.Model;
import com.Tobeto.RentaCar.repositories.ModelRepository;
import com.Tobeto.RentaCar.rules.model.ModelBusinessRuleService;
import com.Tobeto.RentaCar.service.abstracts.ModelService;
import com.Tobeto.RentaCar.service.dto.request.Model.AddModelRequest;
import com.Tobeto.RentaCar.service.dto.request.Model.UpdateModelRequest;
import com.Tobeto.RentaCar.service.dto.response.Model.GetModelByBrandId;
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
    private final ModelBusinessRuleService modelBusinessRuleService;

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

        modelBusinessRuleService.checkIfModelNameExists(addModelRequest.getName());
        Model model = mapperService.forRequest().map(addModelRequest, Model.class);
        model.setId(0);
        modelRepository.save(model);
    }

    @Override
    public void update(UpdateModelRequest modelRequest) {
            //modelBusinessRuleService.checkIfModelNameExists(modelRequest.getName());
            Model model = mapperService.forRequest().map(modelRequest, Model.class);
            modelRepository.save(model);
    }
    @Override
    public void delete(int id) {
        modelRepository.deleteById(id);
    }

    @Override
    public List<GetModelByBrandId> getByBrandId(int id) {
        List<Model> model = modelRepository.findModelsByBrandId(id);
        List<GetModelByBrandId> getModelByBrandId = model.stream()
                .map(color->this.mapperService.forResponse()
                        .map(color, GetModelByBrandId.class)).collect(Collectors.toList());
        return getModelByBrandId;
    }
}


