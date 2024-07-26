package com.example.demo.services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.models.UserModel;
import com.example.demo.repositories.UserRepositories;
import com.example.demo.traits.HttpResponseTrait;

@Service
public class UserService {
    @Autowired
    private UserRepositories userRepositories;

    public ResponseEntity<HttpResponseTrait> getAllData() {
        List<UserModel> users = userRepositories.findAll();
        if (users.isEmpty()) {
            return new ResponseEntity<>(new HttpResponseTrait(HttpStatus.NOT_FOUND.value(), "No data NOT_FOUND", Collections.emptyList() ), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(new HttpResponseTrait(HttpStatus.OK.value(), "Data fetched successfully", users), HttpStatus.OK);
        }
    }
}
