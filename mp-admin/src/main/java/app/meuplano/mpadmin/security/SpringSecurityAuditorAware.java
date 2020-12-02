package app.meuplano.mpadmin.security;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

@Component
public class SpringSecurityAuditorAware implements AuditorAware<String> {

  @Override
  public Optional<String> getCurrentAuditor() {
    // Authentication auth = SecurityContextHolder.getContext().getAuthentication();

    return Optional.of("Admin");
  }
}