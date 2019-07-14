package com.yahoo.identity.services.storage.sql;

import com.yahoo.identity.IdentityException;
import com.yahoo.identity.services.account.AccountUpdate;
import com.yahoo.identity.services.storage.AccountModel;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.annotation.Nonnull;

public class SqlAccountUpdateVulnerable implements AccountUpdate {

    private final SqlSessionFactory sqlSessionFactory;
    private AccountModel account = new AccountModel();

    public SqlAccountUpdateVulnerable(@Nonnull SqlSessionFactory sqlSessionFactory, @Nonnull String username) {
        this.sqlSessionFactory = sqlSessionFactory;
        this.account.setUsername(username);
    }

    @Override
    @Nonnull
    public AccountUpdate setEmail(@Nonnull String email) {
        account.setEmail(email);
        return this;
    }

    @Override
    @Nonnull
    public AccountUpdate setEmailStatus(@Nonnull boolean emailStatus) {
        account.setEmailVerified(emailStatus);
        return this;
    }

    @Override
    @Nonnull
    public AccountUpdate setPassword(@Nonnull String password) {
        account.setPasswordHash(DigestUtils.md5Hex(password));
        return this;
    }

    @Nonnull
    @Override
    public AccountUpdate setDescription(@Nonnull String title) {
        account.setDescription(title);
        return this;
    }

    @Nonnull
    @Override
    public String update() throws IdentityException {
        account.setUpdateTs(System.currentTimeMillis());
        try (SqlSession session = sqlSessionFactory.openSession()) {
            AccountMapper mapper = session.getMapper(AccountMapper.class);
            mapper.updateAccount(account);
            session.commit();
        }
        return account.getUsername();
    }
}
