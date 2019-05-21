package com.springboot.craftsman.configuration.security;

import com.springboot.craftsman.common.LoginType;
import org.springframework.beans.factory.annotation.Value;

/**
 *
 * Created by zhengzy
 */
public class BrowserProperties {

    /**
     *  loginPage 默认值  是login
     *  如果 application.properties 里有对 security.browser.loginPage 的声明，则获取该值
     */
    @Value("${security.browser.loginPage}")
    private String loginPage;

    /**
     * 默认 返回 json 类型
     */
    private LoginType loginType = LoginType.JSON;

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }
}
