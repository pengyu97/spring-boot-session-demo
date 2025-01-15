package com.jay;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiang.wei
 * @date 2020/1/14 19:04
 */
@RestController
@Api(tags = {"登录测试"})
@RequestMapping(value = "/",produces = {"application/json;charset=utf-8"})
@Slf4j
public class LoginController extends BaseController {


    @RequestMapping("/login.do")
    @ApiOperation(value = "登录接口",httpMethod = "POST")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "userName",value = "用户名",dataType = "String",required = true,paramType = "query"),
                    @ApiImplicitParam(name = "password",value = "密码",dataType = "String",required = true,paramType = "query")
            }
    )
    public ReturnData login(String userName, String password) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        setUser(user);
        return ReturnData.success("登录成功", null);
    }

    @RequestMapping("/exit.do")
    @ApiOperation(value = "退出接口",httpMethod = "POST")
    public ReturnData exit() {
        clearUser();
        return ReturnData.success("退出成功", null);
    }

    /**
     * @return
     */
    @RequestMapping("/getUser.do")
    @ApiOperation(value = "获取用户信息",httpMethod = "POST")
    public ReturnData getUser() {
        return ReturnData.success("获取用户信息成功", getUserInfo());
    }

    @RequestMapping("/removeAndSetUser.do")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "userName",value = "用户名",dataType = "String",required = true,paramType = "query"),
                    @ApiImplicitParam(name = "password",value = "密码",dataType = "String",required = true,paramType = "query")
            }
    )
    @ApiOperation(value = "清除sessino并设置用户信息",httpMethod = "POST")
    public ReturnData removeAndSetUser(String userName, String password) {
        exit();
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        setUser(user);
        return ReturnData.success("清理并重新登录成功", null);
    }

    @RequestMapping("/dealUser.do")
    @ApiOperation(value = "业务操作类",httpMethod = "POST")
    public ReturnData dealUser() {
        String userInfo = getUserInfo();
        log.info("*************进行业务操作时，获取到的用户是={}",userInfo);
        if (StringUtils.isNotBlank(userInfo)) {
            return ReturnData.success("可以进行业务处理", null);
        }
        return ReturnData.success("用户未登录", null);
    }
}


