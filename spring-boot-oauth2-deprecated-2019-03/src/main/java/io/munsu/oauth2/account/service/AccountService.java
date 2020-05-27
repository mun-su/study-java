package io.munsu.oauth2.account.service;

import io.munsu.oauth2.account.domain.Account;
import io.munsu.oauth2.account.domain.AccountDto;

/**
 * Created by Munsu Seo on 2019/03/04
 */
public interface AccountService {

  Account createAccount(Account account);

  AccountDto.ResponseAccount getAccountById(Long accountId);

}
