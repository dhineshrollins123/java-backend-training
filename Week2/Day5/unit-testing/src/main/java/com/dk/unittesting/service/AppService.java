package com.dk.unittesting.service;

import com.dk.unittesting.domain.App;
import com.dk.unittesting.repository.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class AppService {

    @Autowired
    private AppRepository repository;

    public List<App> findAppsBetween(Date st, Date ed) {
        return  repository.findByPubDtBetween(st, ed);
    }
}