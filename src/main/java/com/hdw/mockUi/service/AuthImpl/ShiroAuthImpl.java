package com.hdw.mockUi.service.AuthImpl;

import com.hdw.mockUi.dao.UserRoleDao;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShiroAuthImpl {
    @Autowired
    private UserRoleDao userRoleDao;

    public String login(String username, String password) {
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 执行认证登陆

        subject.login(token);
        String tokenId = subject.getSession().getId().toString();

        //   UserInfo user = (UserInfo) subject.getPrincipal();
        // subject.getSession().setAttribute("userInfo", user);

        System.out.print("tokenID" + tokenId );

        //根据权限，指定返回数据
        String role = userRoleDao.getRole(username).trim();
        if ("admin".equals(role)) {
            return "欢迎登陆";
        }
        if ("admin".equals(role)) {
            return "欢迎来到管理员页面";
        }
        return "权限错误！";
    }
}
