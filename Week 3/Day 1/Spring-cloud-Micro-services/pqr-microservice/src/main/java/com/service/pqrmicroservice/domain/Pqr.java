package com.service.pqrmicroservice.domain;

import lombok.*;

import java.time.LocalDate;
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Pqr {
    Long id;
    private String name;
    private LocalDate date;
}