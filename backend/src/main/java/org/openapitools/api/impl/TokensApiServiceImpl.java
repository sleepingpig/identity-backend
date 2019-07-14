package org.openapitools.api.impl;

import com.verizonmedia.identity.Identity;
import com.verizonmedia.identity.IdentityError;
import com.verizonmedia.identity.IdentityException;
import com.verizonmedia.identity.services.session.LoggedInSession;
import org.openapitools.api.CookieParser;
import org.openapitools.api.Cookies;
import org.openapitools.api.NotFoundException;
import org.openapitools.api.TokensApiService;
import org.openapitools.model.Token;

import java.net.HttpCookie;

import javax.annotation.Nonnull;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJerseyServerCodegen", date = "2019-05-14T20:17:48.996+08:00[Asia/Taipei]")
public class TokensApiServiceImpl extends TokensApiService {

    private final Identity identity;
    private final CookieParser cookieParser;

    public TokensApiServiceImpl(@Nonnull Identity identity, @Nonnull CookieParser cookieParser) {
        this.identity = identity;
        this.cookieParser = cookieParser;
    }

    @Override
    public Response createToken(String cookieStr, Token tokenModel, SecurityContext securityContext) throws NotFoundException {
        String credential = cookieParser.parse(cookieStr).getCredential();
        LoggedInSession loggedInSession =
            identity.getSessionService().newSessionWithCredential(credential);
        com.verizonmedia.identity.services.token.Token token = loggedInSession.createToken();
        tokenModel.setValue(token.toString());

        return Response.status(Response.Status.CREATED).entity(tokenModel).build();
    }
}