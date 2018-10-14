package com.project.alpha.account.mapper;

import com.project.alpha.account.model.AccountModel;
import com.project.alpha.account.model.AuthorityModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccountMapper {

    /**
     * 계정정보 조회
     * @param accountId String
     * @return AccountModel
     */
    AccountModel selectAccount(String accountId);

    /**
     * 계정 권한 정보 조회
     * @param accountNo String
     * @return List<AuthorityModel>
     */
    List<AuthorityModel> selectAccountAuthorityList(String accountNo);

    /**
     * 계정 정보 추가
     * @param accountModel AccountModel
     */
    void insertAccount(AccountModel accountModel);

    /**
     * 계정 인증 정보 추가
     * @param accountModel AccountModel
     */
    void insertAccountAuthInfo(AccountModel accountModel);

}
