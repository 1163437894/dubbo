package com.yjc.controller;


import com.yjc.service.QuartzService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
@Api(tags = "登录接口")
public class LoginController {

    @DubboReference
    private QuartzService quartzService;

    @GetMapping("doLogin")
    @ApiOperation("登录")
    public String doLogin() {

        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken("admin", "123"));
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return "账号或密码错误！";
        } catch (AuthorizationException e) {
            e.printStackTrace();
            return "没有权限";
        }

        return "登录";
    }

    @RequiresRoles("admin")
    @RequiresPermissions("add")
    @GetMapping("/index")
    @ApiOperation("首页")
    public String index() {
        return "index!";
    }


    @GetMapping("ceshi")
    @ApiOperation("测试参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", dataType = "integer", paramType = "query", required = true, defaultValue = "1"),
            @ApiImplicitParam(name = "name", value = "名称", dataType = "string", paramType = "query", required = true, defaultValue = "ceshi")
    })
    public String ceshi(@RequestParam Integer id, @RequestParam String name) {
        return "ceshi";
    }


    @GetMapping("quartz")
    @ApiOperation("测试定时器")
    public String quartz() {
        quartzService.execute();
        return "1";
    }

}
