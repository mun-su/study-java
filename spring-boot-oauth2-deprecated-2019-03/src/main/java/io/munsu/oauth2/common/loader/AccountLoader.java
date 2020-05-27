package io.munsu.oauth2.common.loader;

import io.munsu.oauth2.account.domain.Account;
import io.munsu.oauth2.account.domain.Role;
import io.munsu.oauth2.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

/**
 * Created by Munsu Seo on 2019/03/04
 */
@Component
@RequiredArgsConstructor
public class AccountLoader implements Ordered, ApplicationListener<ApplicationStartedEvent> {

  private final PasswordEncoder passwordEncoder;

  private final AccountRepository accountRepository;

  @Override
  public int getOrder() {
    return 0;
  }

  @Override
  @Transactional
  public void onApplicationEvent(ApplicationStartedEvent event) {
    Account account = new Account();
    account.setEmail("munsu@github.io");
    account.setLoginId("munsu");
    account.setPassword(passwordEncoder.encode("pass"));
    account.setRole(Role.ADMIN);
    createAccountAssertNull(account);
  }

  private void createAccountAssertNull(final Account account) {
    Account optionalAccount = accountRepository.findByLoginId(account.getLoginId());
    if (optionalAccount == null) {
      accountRepository.save(account);
    }
  }

}
