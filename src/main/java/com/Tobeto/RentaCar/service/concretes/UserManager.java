package com.Tobeto.RentaCar.service.concretes;

import com.Tobeto.RentaCar.core.utilites.mappers.ModelMapperService;
import com.Tobeto.RentaCar.entities.Rental;
import com.Tobeto.RentaCar.entities.User;
import com.Tobeto.RentaCar.repositories.UserRepository;
import com.Tobeto.RentaCar.service.abstracts.UserService;
import com.Tobeto.RentaCar.service.dto.request.Rental.AddRentalRequest;
import com.Tobeto.RentaCar.service.dto.request.Rental.UpdateRentalRequest;
import com.Tobeto.RentaCar.service.dto.request.User.AddUserRequest;
import com.Tobeto.RentaCar.service.dto.request.User.UpdateUserRequest;
import com.Tobeto.RentaCar.service.dto.response.Rental.GetRentalListResponse;
import com.Tobeto.RentaCar.service.dto.response.Rental.GetRentalResponse;
import com.Tobeto.RentaCar.service.dto.response.User.GetUserListResponse;
import com.Tobeto.RentaCar.service.dto.response.User.GetUserResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private final UserRepository userRepository;
    private final ModelMapperService mapperService;
    @Override
    public List<GetUserListResponse> getAll() {
        List<User> users =  userRepository.findAll();
        List<GetUserListResponse> getUserListResponses = users.stream()
                .map(user->this.mapperService.forResponse()
                        .map(user, GetUserListResponse.class)).collect(Collectors.toList());
        return getUserListResponses;
    }

    @Override
    public GetUserResponse getById(int id) {
        User user = userRepository.findById(id).orElseThrow();
        GetUserResponse response = mapperService.forResponse().map(user, GetUserResponse.class);
        return response;
    }

    @Override
    public void create(AddUserRequest userRequest) {
        //if (rentalRequest.getStartDate().plusDays(25).isBefore(rentalRequest.getEndDate())) {
          //  throw new RuntimeException("The car can be rented for a maximum of 25 days.");
        //}
        User user = mapperService.forRequest().map(userRequest, User.class);
        userRepository.save(user);
    }

    @Override
    public void update(UpdateUserRequest userRequest) {
        User user = mapperService.forRequest().map(userRequest, User.class);
        userRepository.save(user);
    }

    @Override
    public void delete(int id) {
        userRepository.deleteById(id);
    }
}
