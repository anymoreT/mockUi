package com.hdw.mockUi.config.shiro;

import com.hdw.mockUi.config.shiro.session.ShiroSessionListener;
import org.apache.shiro.mgt.RememberMeManager;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;

import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.mgt.SecurityManager;

import  org.apache.shiro.cache.ehcache.EhCacheManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // setLoginUrl 如果不设置值，默认会自动寻找Web工程根目录下的"/login.jsp"页面 或 "/login" 映射
        shiroFilterFactoryBean.setLoginUrl("/auth/login");
        // 设置无权限时跳转的 url;
        shiroFilterFactoryBean.setUnauthorizedUrl("/auth/login");
        // 设置拦截器
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        //游客，开发权限
        filterChainDefinitionMap.put("/guest/**", "anon");
        //用户，需要角色权限 “admin”
        filterChainDefinitionMap.put("/admin/**", "roles[admin]");
       // filterChainDefinitionMap.put("/admin/**", "anon");
        //管理员，需要角色权限 “admin”
        filterChainDefinitionMap.put("/admin/**", "roles[admin]");
        //开放登陆接口
        filterChainDefinitionMap.put("/auth/login", "anon");
        //其余接口一律拦截
        //主要这行代码必须放在所有权限设置的最后，不然会导致所有 url 都被拦截
        filterChainDefinitionMap.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        System.out.println("Shiro拦截器工厂类注入成功");
        return shiroFilterFactoryBean;
    }

//    @Bean
//    EhCacheManager ehCacheManager()
//    {
//        return new EhCacheManager();
//    }

    /**
     * 注入 securityManager
     */
    @Bean
    public SecurityManager securityManager() {
     //   SecurityManager securityManager = new SecurityManager();
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();

        //配置 ehcache缓存管理器 参考博客：
      //  securityManager.setCacheManager(ehCacheManager());

        //配置自定义session管理，使用ehcache 或redis
    //    securityManager.setSessionManager(sessionManager());
        securityManager.setRealm(customRealm());
        return securityManager;





    }
    /**
     * 自定义身份认证 realm;
     * <p>
     * 必须写这个类，并加上 @Bean 注解，目的是注入 CustomRealm，
     * 否则会影响 CustomRealm类 中其他类的依赖注入
     */
    @Bean
    public CustomRealm customRealm() {
        return new CustomRealm();
    }


//
//
//    /**
//     * 配置session监听
//     * @return
//     */
//    @Bean("sessionListener")
//    public ShiroSessionListener sessionListener(){
//        ShiroSessionListener sessionListener = new ShiroSessionListener();
//        return sessionListener;
//    }
//
//    /**
//     * 配置会话ID生成器
//     * @return
//     */
//    @Bean
//    public SessionIdGenerator sessionIdGenerator() {
//        return new JavaUuidSessionIdGenerator();
//    }
//
//    /**
//     * SessionDAO的作用是为Session提供CRUD并进行持久化的一个shiro组件
//     * MemorySessionDAO 直接在内存中进行会话维护
//     * EnterpriseCacheSessionDAO  提供了缓存功能的会话维护，默认情况下使用MapCache实现，内部使用ConcurrentHashMap保存缓存的会话。
//     * @return
//     */
//    @Bean
//    public SessionDAO sessionDAO() {
//        EnterpriseCacheSessionDAO enterpriseCacheSessionDAO = new EnterpriseCacheSessionDAO();
//        //使用ehCacheManager
//        enterpriseCacheSessionDAO.setCacheManager(ehCacheManager());
//        //设置session缓存的名字 默认为 shiro-activeSessionCache
//        enterpriseCacheSessionDAO.setActiveSessionsCacheName("shiro-activeSessionCache");
//        //sessionId生成器
//        enterpriseCacheSessionDAO.setSessionIdGenerator(sessionIdGenerator());
//        return enterpriseCacheSessionDAO;
//    }
//
//    /**
//     * 配置保存sessionId的cookie
//     * 注意：这里的cookie 不是上面的记住我 cookie 记住我需要一个cookie session管理 也需要自己的cookie
//     * @return
//     */
//    @Bean("sessionIdCookie")
//    public SimpleCookie sessionIdCookie(){
//        //这个参数是cookie的名称
//        SimpleCookie simpleCookie = new SimpleCookie("sid");
//        //setcookie的httponly属性如果设为true的话，会增加对xss防护的安全系数。它有以下特点：
//
//        //setcookie()的第七个参数
//        //设为true后，只能通过http访问，javascript无法访问
//        //防止xss读取cookie
//        simpleCookie.setHttpOnly(true);
//        simpleCookie.setPath("/");
//        //maxAge=-1表示浏览器关闭时失效此Cookie
//        simpleCookie.setMaxAge(-1);
//        return simpleCookie;
//    }
//
//    /**
//     * 配置会话管理器，设定会话超时及保存
//     * @return
//     */
//    @Bean("sessionManager")
//    public SessionManager sessionManager() {
//
//        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
//        Collection<SessionListener> listeners = new ArrayList<SessionListener>();
//        //配置监听
//        listeners.add(sessionListener());
//        sessionManager.setSessionListeners(listeners);
//        sessionManager.setSessionIdCookie(sessionIdCookie());
//        sessionManager.setSessionDAO(sessionDAO());
//        sessionManager.setCacheManager(ehCacheManager());
//
//        //全局会话超时时间（单位毫秒），默认30分钟  暂时设置为10秒钟 用来测试
//        sessionManager.setGlobalSessionTimeout(10000);
//        //是否开启删除无效的session对象  默认为true
//        sessionManager.setDeleteInvalidSessions(true);
//        //是否开启定时调度器进行检测过期session 默认为true
//        sessionManager.setSessionValidationSchedulerEnabled(true);
//        //设置session失效的扫描时间, 清理用户直接关闭浏览器造成的孤立会话 默认为 1个小时
//        //设置该属性 就不需要设置 ExecutorServiceSessionValidationScheduler 底层也是默认自动调用ExecutorServiceSessionValidationScheduler
//        //暂时设置为 5秒 用来测试
//        sessionManager.setSessionValidationInterval(5000);
//
//        //取消url 后面的 JSESSIONID
//        sessionManager.setSessionIdUrlRewritingEnabled(false);
//
//        return sessionManager;
//
//    }
//

}
