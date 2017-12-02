package org.biddr.biddrbackend.service;

import org.biddr.biddrbackend.dom.user.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created on 02/12/2017
 *
 * @author lyrold
 */
@Service
public class UserService implements UserDetailsService{

  @Override
  public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

    return new User(); // TODO: 02/12/2017
  }
}
