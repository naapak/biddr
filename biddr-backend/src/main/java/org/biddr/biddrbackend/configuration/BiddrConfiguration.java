package org.biddr.biddrbackend.configuration;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import org.biddr.biddrbackend.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created on 02/12/2017
 *
 * @author lyrold
 */
@Configuration
@EnableTransactionManagement
@EnableAsync(proxyTargetClass = true)
@EnableJpaAuditing(auditorAwareRef = "")
@EnableJpaRepositories(basePackages = "org.biddr.biddrbackend")
@EntityScan(
    basePackages = {"org.biddr.biddrbackend.model"},
    basePackageClasses = {Jsr310JpaConverters.class}
)
public class BiddrConfiguration {


  @Bean
  public AuditorAware auditorAware() {
    return () -> authenticationService.getAuthenticatedUser();
  }


  @Autowired
  private AuthenticationService authenticationService;

  @Bean
  public Module collectionModule() {
    return new GuavaModule();
  }
}
