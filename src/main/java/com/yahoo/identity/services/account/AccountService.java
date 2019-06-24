package com.yahoo.identity.services.account;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public interface AccountService {

    @Nonnull
    AccountCreate newAccountCreate();

    @Nonnull
    Account getAccount(@Nonnull String id);

    /**
     * Gets the public information of an account.
     *
     * @param id Account ID.
     * @return Account.
     */
    @Nonnull
    Account getPublicAccount(@Nonnull String id);

    @Nonnull
    AccountUpdate newAccountUpdate(@Nonnull String id);
}
