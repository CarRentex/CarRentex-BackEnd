package com.Tobeto.RentaCar.controllers;

import com.Tobeto.RentaCar.service.abstracts.AdminService;
import com.Tobeto.RentaCar.service.dto.request.Admin.CreateAdminRequest;
import com.Tobeto.RentaCar.service.dto.request.Admin.UpdateAdminRequest;
import com.Tobeto.RentaCar.service.dto.request.User.DeleteUserRequest;
import com.Tobeto.RentaCar.service.dto.response.Admin.GetAdminListResponse;
import com.Tobeto.RentaCar.service.dto.response.Admin.GetAdminResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/admin")
public class AdminController {
    private final AdminService adminService;

    @PostMapping("/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createAdmin(@RequestBody @Valid CreateAdminRequest createAdminRequest){
        adminService.create(createAdminRequest);
    }

    @PutMapping("/update")
    @ResponseStatus(code = HttpStatus.OK)
    public void update(@RequestBody @Valid UpdateAdminRequest updateAdminRequest){
        adminService.update(updateAdminRequest);
    }

    @GetMapping("/getList")
    @ResponseStatus(code = HttpStatus.OK)
    public List<GetAdminListResponse> getAdminList(){
        return adminService.getAll();
    }

    @GetMapping("/getAdmin")
    @ResponseStatus(code = HttpStatus.OK)
    public GetAdminResponse getAdmin(@RequestParam int id){
        return adminService.getById(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(@PathVariable int id){
        adminService.delete(id);
    }

}
