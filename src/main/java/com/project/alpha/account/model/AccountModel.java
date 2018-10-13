package com.project.alpha.account.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class AccountModel implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private String accountNo;
    private String accountId;
    private String name;
    private String email;
    private String mobile;
    private String emailCertFlag;
    private String mobileCertFlag;
    private String accountStatusCode;
    private String regDttm;
    private String regIp;
    private String sysAdminFlag;
    private String password;
    private int failedLoginCount;

    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.accountId;
    }

    /**
     * 계정 만료 여부
     */
    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    /**
     * 계정 잠김 여부
     */
    @Override
    public boolean isAccountNonLocked() {
        return this.failedLoginCount > 4;
    }

    /**
     * 패스워드 만료 여부
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    /**
     * 계정 활성화 여부
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmailCertFlag() {
        return emailCertFlag;
    }

    public void setEmailCertFlag(String emailCertFlag) {
        this.emailCertFlag = emailCertFlag;
    }

    public String getMobileCertFlag() {
        return mobileCertFlag;
    }

    public void setMobileCertFlag(String mobileCertFlag) {
        this.mobileCertFlag = mobileCertFlag;
    }

    public String getAccountStatusCode() {
        return accountStatusCode;
    }

    public void setAccountStatusCode(String accountStatusCode) {
        this.accountStatusCode = accountStatusCode;
    }

    public String getRegDttm() {
        return regDttm;
    }

    public void setRegDttm(String regDttm) {
        this.regDttm = regDttm;
    }

    public String getRegIp() {
        return regIp;
    }

    public void setRegIp(String regIp) {
        this.regIp = regIp;
    }

    public String getSysAdminFlag() {
        return sysAdminFlag;
    }

    public void setSysAdminFlag(String sysAdminFlag) {
        this.sysAdminFlag = sysAdminFlag;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getFailedLoginCount() {
        return failedLoginCount;
    }

    public void setFailedLoginCount(int failedLoginCount) {
        this.failedLoginCount = failedLoginCount;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

}
