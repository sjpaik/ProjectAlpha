package com.project.alpha.account.service;

import com.project.alpha.account.model.AccountModel;
import com.project.alpha.account.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AccountDetailServiceImpl implements AccountDetailService {

    private final AccountMapper accountMapper;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public AccountDetailServiceImpl(AccountMapper accountMapper,
                                    BCryptPasswordEncoder passwordEncoder) {
        this.accountMapper = accountMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccountModel accountModel = accountMapper.selectAccount(username);

        if(accountModel == null) throw new UsernameNotFoundException("아이디 혹은 비밀번호를 잘못 입력하셨습니다.");

        accountModel.setAuthorities(accountMapper.selectAccountAuthorityList(accountModel.getAccountNo()));
        return accountModel;
    }

    @Override
    public void insertAccountInfo(AccountModel accountModel) {
        String password = accountModel.getPassword();
        String encodePassword = passwordEncoder.encode(password);
        accountModel.setPassword(encodePassword);
        accountModel.setAccountStatusCode("S01");

        accountMapper.insertAccount(accountModel);
        accountMapper.insertAccountAuthInfo(accountModel);
    }

}
