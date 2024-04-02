package com.example.customerproject157.model;


import jakarta.validation.Valid;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDto {
    private Integer id;
    @NotBlank(groups = {PutValidation.class, PostValidation.class}, message = "NAME_CANNOT_BE_BLANK")
    private String name;
    @Min(value = 18, groups = {PostValidation.class}, message = "AGE_MUST_BE_MORE_THAN_18")
    @Max(value = 65, groups = {PostValidation.class})
    private Integer age;
    @NonNull
    private String surname;
    @Valid
    private PassportDto passport;
    //    @NotEmpty
    private List<OrderDto> orders;

    @Data
    public static class PassportDto {
        @Size(min = 6, max = 7, groups = PostValidation.class)
        private String fin;
        private String serialNumber;
        @FutureOrPresent(groups = PutValidation.class)
        private LocalDate expireDate;
    }
}
