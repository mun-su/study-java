package io.munsu.oauth2.account.repository;

import io.munsu.oauth2.account.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Munsu Seo on 2019/03/04
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

  Account findByLoginId(String loginId);
}
