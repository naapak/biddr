package org.biddr.biddrbackend.controller;

import org.biddr.biddrbackend.dto.UserDto;
import org.biddr.biddrbackend.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 02/12/2017
 *
 * @author lyrold
 */
@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

  @Autowired
  private AuthenticationService authenticationService;

  @PostMapping("/login")
  public ResponseEntity login(UserDto user){
    return  ResponseEntity.ok(authenticationService.login(user));
  }

}
