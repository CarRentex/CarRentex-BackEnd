package com.Tobeto.RentaCar.service.concretes;

import com.Tobeto.RentaCar.core.utilites.mappers.ModelMapperService;
import com.Tobeto.RentaCar.entities.concretes.Admin;
import com.Tobeto.RentaCar.entities.concretes.Customer;
import com.Tobeto.RentaCar.entities.concretes.Role;
import com.Tobeto.RentaCar.entities.concretes.User;
import com.Tobeto.RentaCar.repositories.AdminRepository;
import com.Tobeto.RentaCar.service.abstracts.AdminService;
import com.Tobeto.RentaCar.service.dto.request.Admin.CreateAdminRequest;
import com.Tobeto.RentaCar.service.dto.request.Admin.UpdateAdminRequest;
import com.Tobeto.RentaCar.service.dto.response.Admin.GetAdminListResponse;
import com.Tobeto.RentaCar.service.dto.response.Admin.GetAdminResponse;
import com.Tobeto.RentaCar.service.dto.response.Customer.GetCustomerListResponse;
import com.Tobeto.RentaCar.service.dto.response.User.GetUserResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AdminManager implements AdminService {
    private final ModelMapperService mapperService;
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<GetAdminListResponse> getAll() {
        List<Admin> admins =  adminRepository.findAll();
        List<GetAdminListResponse> getAdminListResponses = admins.stream()
                .map(Admin->this.mapperService.forResponse()
                        .map(Admin, GetAdminListResponse.class)).collect(Collectors.toList());
        return getAdminListResponses;
    }

    @Override
    public GetAdminResponse getById(int id) {
        Admin admin = adminRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Kullanıcı bulunamadı"));
        return this.mapperService.forResponse().map(admin, GetAdminResponse.class);
    }

    @Override
    public void create(CreateAdminRequest adminRequest) {
        Admin admin = mapperService.forResponse().map(adminRequest, Admin.class);
        admin.setPassword(passwordEncoder.encode(adminRequest.getPassword()));
        admin.setRole(Role.ADMIN);
        this.adminRepository.save(admin);
    }

    @Override
    public void update(UpdateAdminRequest adminRequest) {
        Admin exsitingAdmin = adminRepository.findById(adminRequest.getId()).orElseThrow(() -> new EntityNotFoundException("Kullanıcı bulunamadı"));
        Admin admin =mapperService.forRequest().map(
                adminRequest, Admin.class);
        admin.setPassword(exsitingAdmin.getPassword());
        admin.setRole(Role.ADMIN);
        adminRepository.save(admin);
    }

    @Override
    public void delete(int id) {
        Admin admin = adminRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Kullanıcı bulunamadı"));
        adminRepository.delete(admin);
    }
}
