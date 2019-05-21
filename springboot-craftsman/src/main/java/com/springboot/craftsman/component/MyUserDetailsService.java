package com.springboot.craftsman.component;

import com.springboot.craftsman.base.UserPO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * UserDetail 类
 * Created by Zhengzy
 */
@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 加载用户数据 , 返回UserDetail 实例
     * @param username  用户登录username
     * @return  返回User实体类 做用户校验
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserPO user = new UserPO();
        List<GrantedAuthority> list = AuthorityUtils.createAuthorityList("admin_role"); //所谓的角色，只是增加ROLE_前缀
        user.setAuthorities(list);
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode("123456"));
        user.setAuthorities(list);
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);

        return new User(user.getUsername(),user.getPassword(),list);
    }
}
