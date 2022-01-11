package com.coco.conf;

import com.coco.shiro.TestRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("getDefaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean=new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);
        //添加shiro的内置过滤器

         /** anno:不需要认证就可以访问
         * authc:必须认证了才能访问
         * user:必须拥有"记住我"功能才能使用
         * perms:拥有对某个资源的权限才能访问
         * role:拥有某个角色权限才能访问
         * */
        Map<String, String> filterMap =new HashMap<>();
        /*filterMap.put("/user/add","perms[add]");
        filterMap.put("/user/update","perms[update]");*/
        filterMap.put("/test","authc");
        filterMap.put("/vip1page","roles[vip1]");
        filterMap.put("/vip2page","roles[vip2]");
        filterMap.put("/vip3page","roles[vip3]");
        bean.setFilterChainDefinitionMap(filterMap);


        bean.setLoginUrl("/toLogin");
        /*bean.setUnauthorizedUrl("/no");*/
        return bean;
    }


    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("testRealm") TestRealm testRealm){
        DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
        securityManager.setRealm(testRealm);
        return securityManager;
    }


    @Bean
    public TestRealm testRealm(){
        return new TestRealm();
    }
}
