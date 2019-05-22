package com.springboot.craftsman.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.craftsman.common.LoginType;
import com.springboot.craftsman.configuration.security.SecurityProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义登录成功处理类
 * Created by Zhengzy
 */
@Component
public class MyAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    /**
     * 日志
     */
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * json 转换工具类
     */
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        logger.info("登录成功");
        //判断是json 格式返回 还是 view 格式返回
        if (LoginType.JSON.equals(securityProperties.getBrowser().getLoginType())){
            //将 authention 信息打包成json格式返回
            //response.setContentType("application/json;charset=UTF-8");
            //response.getWriter().write(objectMapper.writeValueAsString(authentication));
            response.sendRedirect("/welcome");
        }else {
            //返回view
            super.onAuthenticationSuccess(request,response,authentication);
        }
    }
}
