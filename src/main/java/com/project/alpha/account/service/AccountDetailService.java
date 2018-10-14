package com.project.alpha.account.service;

import com.project.alpha.account.model.AccountModel;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AccountDetailService extends UserDetailsService {

    /**
     * 계정 정보 추가
     * @param accountModel AccountModel
     */
    void insertAccountInfo(AccountModel accountModel);

}
