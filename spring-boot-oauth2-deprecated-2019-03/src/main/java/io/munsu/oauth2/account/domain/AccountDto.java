package io.munsu.oauth2.account.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Munsu Seo on 2019/03/04
 */
public class AccountDto {

  @Getter @Setter
  public static class ResponseAccount {
    private String email;
    private Role role;
  }
}
