package com.Tobeto.RentaCar.service.dto.request.User;

import com.Tobeto.RentaCar.entities.concretes.Role;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserRequest {

    @NotNull(message = "Id boş olamaz")
    private int id;

    @Email(message = "Geçersiz e-posta adresi formatı")
    @NotBlank(message = "E-posta boş olamaz")
    private String email;


    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[.@#$%^&+=!])(?=\\S+$).{8,}$",
            message = "Şifre güçlü olmalıdır: en az bir rakam, bir büyük harf, bir küçük harf, bir özel karakter içermeli ve boşluk içermemelidir."
    )
    private String password;

    @NotNull(message = "Kullanıcı adı boş olamaz!!!!")
    private String username;
    @NotNull()
    private List<Role> roles;
}
