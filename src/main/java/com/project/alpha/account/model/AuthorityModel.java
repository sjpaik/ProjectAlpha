package com.project.alpha.account.model;

import org.springframework.security.core.GrantedAuthority;

public class AuthorityModel implements GrantedAuthority {

    private int authorityNo;

    @Override
    public String getAuthority() {
        return String.valueOf(this.authorityNo);
    }

    public int getAuthorityNo() {
        return authorityNo;
    }

    public void setAuthorityNo(int authorityNo) {
        this.authorityNo = authorityNo;
    }

}
