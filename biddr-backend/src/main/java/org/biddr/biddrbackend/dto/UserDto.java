package org.biddr.biddrbackend.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sun.istack.internal.Nullable;
import org.biddr.biddrbackend.dom.user.User;
import org.biddr.biddrbackend.dom.user.UserRole;
import org.immutables.value.Value;

/**
 * Created on 02/12/2017
 *
 * @author lyrold
 */
@Value.Immutable
@JsonSerialize(as = ImmutableUserDto.class)
@JsonDeserialize(as = ImmutableUserDto.class)
public interface UserDto {

  @Nullable
  Long getId();

  String getUsername();

  @Nullable
  String getEmail();

  @Nullable
  String getPassword();

  @Nullable
  UserRole getRole();

  @Nullable
  String getFirstName();

  @Nullable
  String getLastName();

  @Nullable
  String getPhone();

  @Nullable
  Boolean getEnabled();

  @Nullable
  Boolean getAccountNonExpired();

  @Nullable
  Boolean getAccountNonLocked();

  @Nullable
  Boolean getCredentialsNonExpired();

  @Nullable
  Boolean getEmpoweredSecret();

  static UserDto fromUser(User user) {
    ImmutableUserDto.Builder builder = ImmutableUserDto.builder()
        .id(user.getId())
        .username(user.getUsername())
        .email(user.getEmail())
        .role(user.getRole())
        .firstName(user.getFirstName())
        .lastName(user.getLastName())
        .phone(user.getPhone())
        .enabled(user.isEnabled())
        .accountNonExpired(user.isAccountNonExpired())
        .accountNonLocked(user.isAccountNonLocked())
        .credentialsNonExpired(user.isCredentialsNonExpired());
    return builder.build();
  }

}
