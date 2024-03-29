package com.Tobeto.RentaCar.service.concretes;

import com.Tobeto.RentaCar.core.utilites.mappers.ModelMapperService;
import com.Tobeto.RentaCar.entities.concretes.User;
import com.Tobeto.RentaCar.repositories.UserRepository;
import com.Tobeto.RentaCar.rules.auth.AuthRulesService;
import com.Tobeto.RentaCar.service.abstracts.UserService;
import com.Tobeto.RentaCar.service.dto.request.User.DeleteUserRequest;
import com.Tobeto.RentaCar.service.dto.request.User.ResetPasswordRequest;
import com.Tobeto.RentaCar.service.dto.request.User.UpdatePasswordRequest;
import com.Tobeto.RentaCar.service.dto.response.User.GetUserListResponse;
import com.Tobeto.RentaCar.service.dto.response.User.GetUserResponse;
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
    private final PasswordEncoder passwordEncoder;
    private final AuthRulesService authRulesService;

    @Override
    public void delete(int id) {

        // admin onayı istenecek admin şifresini girince silinecek
        User userDelete = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Kullanıcı bulunamadı"));
        userRepository.delete(userDelete);
    }


    @Override
    public List<GetUserListResponse> getAll() {
        List<User> users = userRepository.findAll();
        List<GetUserListResponse> userResponses = users.stream()
                .map(user -> this.modelMapperService.forResponse()
                        .map(user, GetUserListResponse.class))
                .collect(Collectors.toList());
        return userResponses;
    }

    @Override
    public GetUserResponse getById(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Kullanıcı bulunamadı"));
        return this.modelMapperService.forResponse().map(user, GetUserResponse.class);
    }

    @Override
    public void updatePassword(UpdatePasswordRequest updatePasswordRequest) {
        User user = userRepository.findById(updatePasswordRequest.getId()).orElseThrow(() -> new EntityNotFoundException("Kullanıcı bulunamadı"));
        authRulesService.oldPasswordCheck(user.getPassword(),updatePasswordRequest.getOldPassword());
        authRulesService.newPasswordNotSameAsOldPassword(user.getPassword(),updatePasswordRequest.getNewPassword());
        authRulesService.checkIfPasswordMatch(updatePasswordRequest.getNewPassword(), updatePasswordRequest.getConfirmPassword());
        user.setPassword(passwordEncoder.encode(updatePasswordRequest.getNewPassword()));
        userRepository.save(user);
    }

    @Override
    public void resetPassword(ResetPasswordRequest resetPasswordRequest) {
        User user = userRepository.findByEmail(resetPasswordRequest.getEmail()).orElseThrow(() -> new EntityNotFoundException("Kullanıcı bulunamadı"));
        // sorular sorulacak

        authRulesService.newPasswordNotSameAsOldPassword(user.getPassword(),resetPasswordRequest.getNewPassword());
        authRulesService.checkIfPasswordMatch(resetPasswordRequest.getNewPassword(), resetPasswordRequest.getConfirmPassword());
        user.setPassword(passwordEncoder.encode(resetPasswordRequest.getNewPassword()));
        userRepository.save(user);
    }

    @Override
    public int totalUsers() {
        return userRepository.findAll().size();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("No user found!"));
    }
}




