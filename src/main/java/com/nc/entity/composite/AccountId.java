package com.nc.entity.composite;

import java.io.Serializable;
import java.util.Objects;

public class AccountId implements Serializable {
	private static final long serialVersionUID = 7340195760360156434L;
	private String accountNumber;
	private String accountType;

	public AccountId() {
	}

	public AccountId(String accountNumber, String accountType) {
		this.accountNumber = accountNumber;
		this.accountType = accountType;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		AccountId accountId = (AccountId) o;
		return accountNumber.equals(accountId.accountNumber) && accountType.equals(accountId.accountType);
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountNumber, accountType);
	}
}