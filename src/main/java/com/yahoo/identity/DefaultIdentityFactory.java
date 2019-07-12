package com.yahoo.identity;

import com.yahoo.identity.services.key.KeyService;
import com.yahoo.identity.services.key.KeyServiceImpl;
import com.yahoo.identity.services.random.RandomService;
import com.yahoo.identity.services.random.RandomServiceImpl;
import com.yahoo.identity.services.session.SessionService;
import com.yahoo.identity.services.session.SessionServiceImpl;
import com.yahoo.identity.services.storage.Storage;
import com.yahoo.identity.services.storage.sql.SqlStorage;
import com.yahoo.identity.services.system.SystemService;
import com.yahoo.identity.services.token.TokenService;
import com.yahoo.identity.services.token.TokenServiceImpl;

import javax.annotation.Nonnull;

public class DefaultIdentityFactory implements IdentityFactory {

    @Nonnull
    @Override
    public Identity create() {
        SystemService systemService = new SystemService();
        RandomService randomService = new RandomServiceImpl();
        KeyService keyService = new KeyServiceImpl();

        Storage sqlStorage = new SqlStorage(systemService, randomService);
        TokenService tokenService = new TokenServiceImpl(keyService);
        SessionService sessionService = new SessionServiceImpl(sqlStorage, keyService, tokenService);

        return new Identity(sessionService, tokenService);
    }
}
