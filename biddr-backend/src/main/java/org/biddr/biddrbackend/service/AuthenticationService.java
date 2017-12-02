package org.biddr.biddrbackend.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.biddr.biddrbackend.configuration.security.SecretKey;
import org.biddr.biddrbackend.dom.user.User;
import org.biddr.biddrbackend.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * Created on 02/12/2017
 *
 * @author lyrold
 */
@Service
@Slf4j
public class AuthenticationService {
  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private SecretKey secretKey;

  public String getLoginToken(UserDto user) {
    UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
    Authentication authentication = authenticationManager.authenticate(token);
    SecurityContextHolder.getContext().setAuthentication(authentication);
    User target = (User) authentication.getPrincipal();
    return Jwts.builder()
        .setSubject(user.getUsername())
        .claim("role", target.getRole())
        .signWith(SignatureAlgorithm.HS512, secretKey.getValue())
        .compact();
  }

  public User getAuthenticatedUser() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    return authentication != null ? (User) authentication.getPrincipal() : null;
  }
}
