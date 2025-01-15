package com.jay;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

/**
 * @author xiang.wei
 * @date 2020/1/14 19:17
 */
@Slf4j
public class BaseController {
    @Autowired
    private HttpSession httpSession;

    private static String USER_INFO = "USER_INFO";

    /**
     * 设置用户
     *
     * @param user
     */
    protected void setUser(User user) {
        log.info("************当前传入sessionId={},设置的值={}",httpSession.getId(),JSON.toJSONString(user));
        httpSession.setAttribute(USER_INFO, JSON.toJSONString(user));
    }

    /**
     *
     */
    protected void clearUser() {
        httpSession.removeAttribute(USER_INFO);
    }

    protected String getUserInfo() {
        return (String) httpSession.getAttribute(USER_INFO);
    }

}
