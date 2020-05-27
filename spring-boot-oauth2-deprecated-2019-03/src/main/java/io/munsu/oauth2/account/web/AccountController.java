package io.munsu.oauth2.account.web;

import io.munsu.oauth2.account.domain.AccountDto;
import io.munsu.oauth2.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

/**
 * Created by Munsu Seo on 2019/03/04
 */
@RestController
@RequiredArgsConstructor
public class AccountController {

  private final AccountService accountService;

  @GetMapping("/account/{accountId}")
  @ResponseStatus(OK)
  @PreAuthorize("hasRole('ADMIN')")
  public AccountDto.ResponseAccount getAccountById(@PathVariable final Long accountId) {
    return accountService.getAccountById(accountId);
  }
}
