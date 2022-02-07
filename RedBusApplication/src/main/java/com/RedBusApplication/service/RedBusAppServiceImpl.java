package com.RedBusApplication.service;

import com.RedBusApplication.domain.RedBusReservation;
import com.RedBusApplication.domain.ReservationDto;
import com.RedBusApplication.repository.RedBusRepository;
import org.apache.el.util.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedBusAppServiceImpl implements RedBusAppService{

    @Autowired
    private RedBusRepository repository;

    @Override
    public void login() {

    }

    @Override
    public ReservationDto newReservation(ReservationDto data) {


        RedBusReservation redBusReservation=new RedBusReservation();

        redBusReservation.setBoardingPlace(data.getBoardingPlace());
        redBusReservation.setDestinationPlace(data.getDestinationPlace());
        redBusReservation.setDistanceKms(data.getDistanceKms());
        redBusReservation.setBookingDate(data.getBookingDate());
        redBusReservation.setTravellingDate(data.getTravellingDate());
        redBusReservation.setTravellingTime(data.getTravellingTime());
        redBusReservation.setSeatsBooked(data.getSeatsBooked());
        redBusReservation.setTotalAmount(data.getTotalAmount());
        redBusReservation.setIsPaymentDone(data.getIsPaymentDone());
        redBusReservation.setAppUser(data.getAppUser());
        repository.save(redBusReservation);

        return data;
    }

    @Override
    public void forgottenPassword() {

    }

    @Override
    public List<ReservationDto> reservationDetails() {
        return null;
    }

    @Override
    public void myAccount() {

    }
}
