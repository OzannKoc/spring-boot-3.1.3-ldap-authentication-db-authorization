package com.security.ldap.controller;

import com.security.ldap.model.LoginRequest;
import com.security.ldap.service.UserDetailService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/test")
@CrossOrigin
@AllArgsConstructor
public class TestController {

    private final UserDetailService userDetailService;

    @GetMapping
    public ResponseEntity<String> test(){
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> login(@RequestBody LoginRequest request){

        return new ResponseEntity<>(userDetailService.login(request), HttpStatus.OK);
    }
}
