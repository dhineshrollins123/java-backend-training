package com.RedBusApplication.controller;

import com.RedBusApplication.domain.AppResponse;
import com.RedBusApplication.domain.ReservationDto;
import com.RedBusApplication.service.RedBusAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/registration/reserve")
public class RedBusAppController {

    @Autowired
    private RedBusAppService appService;

    @PostMapping
    public ResponseEntity<AppResponse<ReservationDto>> reservation(@Valid @RequestBody ReservationDto data) {

        var response = new AppResponse<ReservationDto>();
        response.setBody(appService.newReservation(data));
        response.setMessage("Reservation Has Been Done Sucessfully");
        response.setStatus(true);
        return ResponseEntity.ok(response);


    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> messages = new HashMap<>();

        List<ObjectError> errors = ex.getBindingResult().getAllErrors();
        for (ObjectError objErr : errors) {
            FieldError fieldError = (FieldError) objErr;
            String field = fieldError.getField();
            String msg = fieldError.getCode();
            messages.put(field, msg);
        }
        return messages;
    }


}
