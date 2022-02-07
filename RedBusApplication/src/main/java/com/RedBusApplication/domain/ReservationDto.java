package com.RedBusApplication.domain;

import com.RedBusApplication.signup.appuser.AppUser;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
public class ReservationDto {

        private Long id;

        @NotBlank
        private String boardingPlace;

        @NotBlank
        private String destinationPlace;

        @NotNull(message = "Please Enter Distance")
        @Min(50)
        private Integer distanceKms;

        @Past
        private LocalDate bookingDate;

        @Past
        private LocalDate travellingDate;

        @Past
        private LocalTime travellingTime;

        @NotNull(message = "Please Enter How Many Seats Booked")
        @Min(1)
        @Max(45)
        private Integer seatsBooked;

        @NotNull(message = "Please Enter Total Amount")
        @Min(200)
        private Double totalAmount;

        @NotNull
        private  Boolean isPaymentDone;

        private AppUser appUser;


}
