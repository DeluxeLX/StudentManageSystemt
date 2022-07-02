package com.itlzh.service.impl;

import com.itlzh.mapper.UserDAO;
import com.itlzh.pojo.Role;
import com.itlzh.pojo.UserInfo;
import com.itlzh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceimpl implements UserService, UserDetailsService {

    @Autowired
    UserDAO dao;

    @Override
    public UserInfo findByUsername(String username) {
        return dao.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try {
            userInfo = dao.findByUsername(username);
            System.out.println(userInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        User user = null;
        if (userInfo != null) {
            user = new User(userInfo.getUsername(),
                    "{noop}"+userInfo.getPassword(),
                    userInfo.getStatus() == 0 ? false : true,
                    true,
                    true,
                    true,
                    getAuthority(userInfo.getRoles()));
        } else {
            System.out.println("我们自己定义的userInfo是空值...");
        }

        return user;
    }

    public List<SimpleGrantedAuthority> getAuthority(List<Role> roleList) {

        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role: roleList) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return list;
    }
}
