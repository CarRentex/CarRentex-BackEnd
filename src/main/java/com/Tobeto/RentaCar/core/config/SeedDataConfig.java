
package com.Tobeto.RentaCar.core.config;


import com.Tobeto.RentaCar.service.abstracts.*;
import com.Tobeto.RentaCar.service.dto.request.Brand.AddBrandRequest;
import com.Tobeto.RentaCar.service.dto.request.Color.AddColorRequest;
import com.Tobeto.RentaCar.service.dto.request.Model.AddModelRequest;
import com.Tobeto.RentaCar.service.dto.response.Brand.GetBrandListApi;
import com.Tobeto.RentaCar.service.dto.response.Brand.GetBrandListResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.config.ConfigDataNotFoundException;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
//@Lazy
public class SeedDataConfig{

    private final ColorService colorService;
    private final BrandService brandService;
    private final ModelService modelService;


    public void run(String... args) {

        String[] brands = {"Audi", "BMW", "Mercedes", "Honda", "Toyota"};
        for (String brand : brands) {
            brandService.create(new AddBrandRequest(brand));
        }

        List<GetBrandListResponse> a = this.brandService.getAll();
        String[] carModels = {"A4", "M3", "c180", "Civic", "Corolla"};
        for (GetBrandListResponse brand : a) {
            modelService.create(new AddModelRequest(brand.getId(), carModels[a.indexOf(brand)]));
        }

        String[] colors = {"White", "Black", "Red", "Green", "Blue"};
        for (String color : colors) {
            colorService.create(new AddColorRequest(color));
        }


        //--------------------SEED USERS--------------------

/*        if (userEntityService.getAll().toArray().length == 0) {

            customerService.create(CreateCustomerRequest.builder()
                    .name("customer")
                    .surname("customer")
                    .phoneNumber("11111111111")
                    .emailAddress("customer@gmail.com")
                    .password(passwordEncoder.encode("pass"))
                    .drivingLicenseNumber("123456")
                    .drivingLicenseTypes(new ArrayList<DrivingLicenseType>() {{
                        add(A);
                    add(B);
                    add(BE);
                    add(C1);
                    add(E);
                }})
                .imagePath("https://img.memurlar.net/galeri/4599/2cc5bb86-a578-e311-a7bb-14feb5cc13c9.jpg?width=800")
                .status(UserStatus.VERIFIED)
                .build());


        adminServices.create(CreateAdminRequest.builder()
                .name("admin")
                .surname("admin")
                .phoneNumber("22222222222")
                .emailAddress("admin@gmail.com")
                .password(passwordEncoder.encode("pass"))
                .imagePath("https://avatars.githubusercontent.com/u/92371744?v=4")
                .salary(10000.00)
                .build());
    }*/
}

}

