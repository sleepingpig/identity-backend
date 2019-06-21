package com.yahoo.identity.services.account;

import com.yahoo.identity.IdentityException;

import javax.annotation.Nonnull;
import java.time.Instant;

public interface AccountUpdate {

    @Nonnull
    AccountUpdate setEmail(@Nonnull String email, @Nonnull Boolean verified);

    @Nonnull
    AccountUpdate setPassword(@Nonnull String password);

    @Nonnull
    AccountUpdate setUpdateTime(@Nonnull Instant updateTime);

    @Nonnull
    AccountUpdate setDescription(@Nonnull String description);

    @Nonnull
    String update() throws IdentityException;
}