package com.dk.week3.BillingModule.dataobject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BillGenerationDto {
    private Integer patientId;
    @NotBlank
    @NotNull
    private String aPatientName;

    @NotNull
    private LocalDate billDate;

    @NotNull
    private String treatment;

    private LocalDate paidDate;
    private Boolean paidStatus;

    @Min(500)
    @NotNull
    private Double payAmount;
    public BillGenerationDto(String treatment, Double payAmount) {
    }
}
