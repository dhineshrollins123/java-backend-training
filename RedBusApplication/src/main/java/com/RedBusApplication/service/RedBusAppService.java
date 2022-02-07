package com.RedBusApplication.service;

import com.RedBusApplication.domain.ReservationDto;

import java.util.List;

public interface RedBusAppService {
    void login();
    ReservationDto newReservation(ReservationDto data);
    void forgottenPassword();
   List<ReservationDto> reservationDetails();
    void myAccount();
   // public void payment();
}
