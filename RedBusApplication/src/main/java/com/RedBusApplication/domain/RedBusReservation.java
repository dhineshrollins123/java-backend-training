package com.RedBusApplication.domain;

import com.RedBusApplication.signup.appuser.AppUser;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@Entity
public class RedBusReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String boardingPlace;

    @NotBlank
    private String destinationPlace;

    @Min(50)
    @NotNull(message = "Please Enter Distance")
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

    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "app_user_id"
    )
    private AppUser appUser;
}
