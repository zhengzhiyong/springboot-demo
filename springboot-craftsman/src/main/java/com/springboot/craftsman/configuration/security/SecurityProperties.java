package com.springboot.craftsman.configuration.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Security 属性 类
 * Created by Fant.J.
 */
@Component
@ConfigurationProperties(prefix = "security")
public class SecurityProperties {
    /**
     * 浏览器 属性类
     */
    private BrowserProperties browser = new BrowserProperties();

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }
}


