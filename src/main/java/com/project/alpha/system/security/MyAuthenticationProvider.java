package com.project.alpha.system.security;

import com.project.alpha.account.model.AccountModel;
import com.project.alpha.account.service.AccountDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MyAuthenticationProvider implements AuthenticationProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyAuthenticationProvider.class);

    private final BCryptPasswordEncoder passwordEncoder;
    private final AccountDetailService accountDetailService;

    @Autowired
    public MyAuthenticationProvider(BCryptPasswordEncoder passwordEncoder,
                                    AccountDetailService accountDetailService) {
        this.passwordEncoder = passwordEncoder;
        this.accountDetailService = accountDetailService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String accountId = (String) authentication.getPrincipal();
        String accountPassword = (String) authentication.getCredentials();

        LOGGER.debug("# User ID : " + accountId);
        LOGGER.debug("# User Password : " + accountPassword);

        AccountModel accountModel = (AccountModel) accountDetailService.loadUserByUsername(accountId);

        LOGGER.debug("# DB User ID : " + accountModel.getAccountId());
        LOGGER.debug("# DB User Password : " + accountModel.getPassword());

        if(!passwordEncoder.matches(accountPassword, accountModel.getPassword())){
            throw new BadCredentialsException("Bad credentials");
        }

        return new UsernamePasswordAuthenticationToken(accountId, accountPassword, accountModel.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
