package com.Tobeto.RentaCar.service.concretes;

import com.Tobeto.RentaCar.core.utilites.mappers.ModelMapperService;
import com.Tobeto.RentaCar.entities.concretes.User;
import com.Tobeto.RentaCar.repositories.UserRepository;
import com.Tobeto.RentaCar.service.abstracts.UserService;
import com.Tobeto.RentaCar.service.dto.request.User.CreateUserRequest;
import com.Tobeto.RentaCar.service.dto.request.User.DeleteUserRequest;
import com.Tobeto.RentaCar.service.dto.request.User.UpdateUserRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserManager implements UserService {
    private final ModelMapperService modelMapperService;
    private final UserRepository userRepository;
    //private final UserBusinessRulesService userBusinessRulesService;
    private final PasswordEncoder passwordEncoder;


    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public void update(UpdateUserRequest updateUserRequest) {
       // userBusinessRulesService.emailCheck(updateUserRequest.getEmail());
        //userBusinessRulesService.truePassword(updateUserRequest.getPassword(),
          //      updateUserRequest.getConfirmPassword());
        User userUpdate = userRepository.findById(updateUserRequest.getId()).orElseThrow();

        userUpdate.setUsername(updateUserRequest.getUsername());
        //userUpdate.setRole(updateUserRequest.getRoles());
        // update request düzenlenecek
        userUpdate.setPassword(passwordEncoder.encode(updateUserRequest.getPassword()));


        userRepository.saveAndFlush(userUpdate);
    }

    @Override
    public void delete(DeleteUserRequest deleteUserRequest) {
        User userDelete = userRepository.findById(deleteUserRequest.getId()).orElseThrow(() -> new EntityNotFoundException("Kullanıcı bulunamadı"));
        userRepository.delete(userDelete);

    }


/*    @Override
    public List<GetListUserResponse> getAll() {
        List<User> users = userRepository.findAll();
        List<GetListUserResponse> userResponses = users.stream()
                .map(user -> this.modelMapperService.forResponse()
                        .map(user, GetListUserResponse.class))
                .collect(Collectors.toList());
        return userResponses;
    }*/

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("No user found!"));
    }
}




