package com.Tobeto.RentaCar.service.dto.request.Car;
import com.Tobeto.RentaCar.entities.concretes.Category;
import com.Tobeto.RentaCar.entities.concretes.FuelType;
import com.Tobeto.RentaCar.entities.concretes.GearType;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddCarRequest {

    @PositiveOrZero(message = "The annotated element must be a positive number or 0.")
    private int kilometer;

    @Min(value = 2005, message = "Year cannot be less than 2005")
    @Max(value = 2024, message = "The year cannot be greater than 2024")
    private int year;

    @PositiveOrZero(message = "The annotated element must be a positive number or 0.")
    private double dailyPrice;

    @Pattern(regexp = "^[0-9]{2} [A-Z]{1,3} [0-9]{2,5}$", message = "invalid format")
    @NotBlank
    private String plate;

    @NotNull
    @Positive
    @Min(value = 50,message = "Your credit score cannot be lower than 50.")
    private short minFindeksRate;

    @NotNull(message = "Category type must be specified.")
    private Category category;

    @NotNull(message = "Category type must be specified.")
    private short passengerCapacity;

    @NotNull(message = "GearType type must be specified.")
    private GearType gearType;

    @NotNull(message = "FuelType type must be specified.")
    private FuelType fuelType;

    //@PositiveOrZero(message = "The annotated element must be a positive number or 0.")
    private int colorId;
    //@PositiveOrZero(message = "The annotated element must be a positive number or 0.")
    private int modelId;

}
