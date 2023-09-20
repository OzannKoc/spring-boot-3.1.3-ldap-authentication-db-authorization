package com.security.ldap.service;

import com.security.ldap.entity.UserDetail;
import com.security.ldap.model.LoginRequest;

public interface UserDetailService  {

    UserDetail loadUserByUsername(String email);

    String login (LoginRequest request);
}
