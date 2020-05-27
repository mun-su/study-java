package io.munsu.oauth2.account.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Munsu Seo on 2019/03/04
 */
@Entity
@Getter @Setter
public class Account {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long accountId;

  private String loginId;

  private String password;

  private String email;

  @Enumerated(EnumType.STRING)
  private Role role;

}
