package com.jack.lottery.filter;

import com.alibaba.fastjson.JSONObject;
import com.jack.lottery.entity.User;
import com.jack.lottery.mapper.UserMapper;
import com.jack.lottery.utils.PropertyUtil;
import com.jack.lottery.utils.exception.Exception2ResponseUtils;
import com.jack.lottery.vo.CommonResponose;
import com.jack.lottery.vo.ResponseCode;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class LoginFilter implements Filter {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private UserMapper userMapper;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ServletContext servletContext = filterConfig.getServletContext();
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        userMapper = (UserMapper) webApplicationContext.getBean("userMapper");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Allow-Origin","*");
        filterChain.doFilter(servletRequest, servletResponse);
        /*if (PropertyUtil.contains(request.getRequestURI())) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        String userId = request.getParameter("userId");
        if (StringUtils.isBlank(userId) || !StringUtils.isNumeric(userId) || !checkUser(Long.parseLong(userId))) {
            returnNotLogin(response);
            return;
        }
        HttpSession session = request.getSession();
        Object loginToken = session.getAttribute("loginToken");
        if (null == loginToken) {
            returnNotLogin(response);
            return;
        }
        String loginTokenStr = (String) loginToken;
        Cookie[] cookies = request.getCookies();
        boolean isLogin = false;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("loginToken") && cookie.getValue().equals(loginTokenStr)) {
                isLogin = true;
            }
        }
        if (isLogin) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            returnNotLogin(response);
        }*/
    }

    @Override
    public void destroy() {

    }

    private void returnNotLogin(HttpServletResponse httpServletResponse) throws IOException {
        CommonResponose resp = new CommonResponose(ResponseCode.NOT_LOGIN, null);
        String json = JSONObject.toJSONString(resp);
        httpServletResponse.setStatus(HttpStatus.OK.value()); //设置状态码
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE); //设置ContentType
        httpServletResponse.setCharacterEncoding("UTF-8"); //避免乱码
        httpServletResponse.setHeader("Cache-Control", "no-cache, must-revalidate");
        httpServletResponse.getWriter().write(JSONObject.toJSONString(resp));
    }

    private boolean checkUser(long userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        if (null == user) {
            return false;
        }
        return true;
     }
}
