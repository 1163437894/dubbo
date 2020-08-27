package com.yjc.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

@Component
public class MyRealm extends AuthorizingRealm {


    /**
     * 授权
     * 在SimpleAuthorizationInfo 类中添加角色信息以及权限信息 addRole(),addStringPermission()
     * 只有在使用@RequiresRoles  @RequiresPermissions时才会调用doGetAuthorizationInfo()此方法
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("进入--->doGetAuthorizationInfo(),授权方法");
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRole("admin");
        simpleAuthorizationInfo.addStringPermission("add");
        return simpleAuthorizationInfo;
    }


    /**
     * 认证
     * 登录认证时调用此方法
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("进入--->doGetAuthenticationInfo(),认证方法");
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo("admin", "123", getName());
        return authenticationInfo;
    }
}
