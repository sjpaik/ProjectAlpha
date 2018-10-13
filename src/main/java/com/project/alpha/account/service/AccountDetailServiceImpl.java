package com.project.alpha.account.service;

import com.project.alpha.account.model.AccountModel;
import com.project.alpha.account.mapper.AccountMapper;
import com.project.alpha.account.model.AuthorityModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountDetailServiceImpl implements AccountDetailService {

    private final AccountMapper accountMapper;

    @Autowired
    public AccountDetailServiceImpl(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccountModel accountModel = accountMapper.selectAccount(username);

        if(accountModel == null) throw new UsernameNotFoundException("");

        List<AuthorityModel> authorityList = accountMapper.selectAccountAuthorityList(accountModel.getAccountNo());

        if(authorityList.size() == 0) throw new UsernameNotFoundException("");

        accountModel.setAuthorities(authorityList);
        return accountModel;
    }

}
