package com.itlzh.service;


import com.itlzh.pojo.UserInfo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService {

    // 通过传来的用户名在数据库中进行匹配
    UserInfo findByUsername(String username);

    // 通过传来的用户名加载用户信息
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
