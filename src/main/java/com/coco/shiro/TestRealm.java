package com.coco.shiro;

import com.coco.model.dto.RoleTable;
import com.coco.model.dto.User;
import com.coco.service.aboutUser.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class TestRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了授权");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        List<RoleTable> roleTables = user.getRoleTables();
        List<String> roles=new ArrayList<>();
        roleTables.forEach(roleTable -> roles.add(roleTable.getRole()));
        info.addRoles(roles);
        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        User user = userService.getUserByUserAccount(userToken.getUsername());
        if (user==null){
            return null;
        }
        return new SimpleAuthenticationInfo(user,user.getUserPass(),"");
    }
}
