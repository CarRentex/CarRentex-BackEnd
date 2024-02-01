package com.Tobeto.RentaCar.service.dto.request.User;

import com.Tobeto.RentaCar.entities.concretes.Role;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
    @NotNull(message = "Kullanıcı adı boş olamaz!!!!")
    private String username;

    @Size(min = 2, max = 20)
    String firstName;

    @Size(min = 2, max = 20)
    @Pattern(regexp = "^[a-zA-ZğüşıöçĞÜŞİÖÇ]+$", message = "isim/soyisim sadece harflerden oluşmalıdır.")
    String lastName;

    @Pattern(regexp = "^[0-9]{11}$", message = "Tc kimlik numarası 11 haneli olmalıdır.")
    String nationalityId;

    String address;

    String companyName;

    String taxNo;

    @Pattern(regexp = "05[0-9]{9}", message = "Invalid phone number format. It must be in the format 05xxxxxxxxx.")
    String phoneNumber;

    @Email(message = "Geçersiz e-posta adresi formatı")
    @NotBlank(message = "E-posta boş olamaz")
    private String email;

    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[.@#$%^&+=!])(?=\\S+$).{8,}$",
            message = "Şifre güçlü olmalıdır: en az bir rakam, bir büyük harf, bir küçük harf, bir özel karakter içermeli ve boşluk içermemelidir."
    )
    private String password;

    // phone number eklenecek

    @NotNull()
    private Role roles; // list<Role > idi düzelttim dikkat

}