package com.nc.composite.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nc.entity.composite.Account;
import com.nc.entity.composite.AccountId;

public interface AccountRepository extends JpaRepository<Account, AccountId> {

    List<Account> findByAccountType(String accountType);
}
