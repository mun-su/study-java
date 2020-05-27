package io.munsu.oauth2.account.service.impl;

import io.munsu.oauth2.account.domain.Account;
import io.munsu.oauth2.account.domain.AccountDto;
import io.munsu.oauth2.account.repository.AccountRepository;
import io.munsu.oauth2.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * Created by Munsu Seo on 2019/03/04
 */
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements UserDetailsService, AccountService {

  private final AccountRepository accountRepository;

  private final PasswordEncoder passwordEncoder;

  private final ModelMapper modelMapper;

  @Override
  public Account createAccount(final Account account) {
    account.setPassword(passwordEncoder.encode(account.getPassword()));
    return account;
  }

  @Override
  public AccountDto.ResponseAccount getAccountById(final Long accountId) {
    return modelMapper.map(accountRepository.findById(accountId).orElseThrow(), AccountDto.ResponseAccount.class);
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Account account = accountRepository.findByLoginId(username);
    return new User(account.getLoginId(),
        account.getPassword(),
        Collections.singletonList(new SimpleGrantedAuthority(account.getRole().getRoleName())));
  }
}
