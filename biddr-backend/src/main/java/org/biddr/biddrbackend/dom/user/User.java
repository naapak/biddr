package org.biddr.biddrbackend.dom.user;

import lombok.Data;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.AbstractAuditable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created on 02/12/2017
 *
 * @author lyrold
 */
@Data
@Entity
public class User extends AbstractAuditable implements UserDetails, Persistable {

  @Id
  @GeneratedValue
  private Long id;

  private String firstName;
  private String lastName;
  private String phone;
  private String email;
  private String username;
  private String password;

  @Enumerated(EnumType.STRING)
  private UserRole role;

  private boolean enabled;
  private boolean accountNonExpired;
  private boolean accountNonLocked;
  private boolean credentialsNonExpired;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return Arrays.asList(new SimpleGrantedAuthority(role.toString()));
  }


}
