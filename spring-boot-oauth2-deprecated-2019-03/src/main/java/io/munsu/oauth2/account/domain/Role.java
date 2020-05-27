package io.munsu.oauth2.account.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by Munsu Seo on 2019/03/04
 */
@Getter
@AllArgsConstructor
public enum Role {

  ADMIN("ROLE_ADMIN", "Administrator");

  private final String roleName;
  private final String description;
}
