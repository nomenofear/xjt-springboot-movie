package com.xjt.movie.config.shiro;

import net.sf.ehcache.CacheManager;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    //1.创建shiroFilter  //负责拦截所有请求
    @Bean(name = "shiroFilterFactoryBean")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(){

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //给filter设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(getDefaultWebSecurityManager());

        //配置系统受限资源
        //配置系统公共资源
        Map<String,String> map = new LinkedHashMap<>();
//        map.put("/user/toLogin","anon");	//anon 放行该资源
//        map.put("/user/toLogout","anon");	//anon 放行该资源
//        map.put("/user/toRegister","anon");	//anon 放行该资源
//        map.put("/user/getCaptcha","anon");	//验证码 放行该资源
//        map.put("/user/sendMailCode","anon");	//验证码 放行该资源

        map.put("/user/**","anon");	        //放行该资源
        map.put("/movie/**","anon");	//放行该资源

        map.put("/**","authc");     //authc 请求这个资源需要认证和授权

        //默认认证界面路径---当认证不通过时跳转
        shiroFilterFactoryBean.setLoginUrl("/user/toLogin");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);

        return shiroFilterFactoryBean;
    }

    //2.创建安全管理器
    @Bean(name = "myDefaultWebSecurityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        //给安全管理器设置
        defaultWebSecurityManager.setRealm(customerRealm());

        return defaultWebSecurityManager;
    }

    //3.创建自定义realm
    @Bean(name = "myUsernamePasswordRealm")
    public Realm customerRealm(){
        CustomerRealm customerRealm = new CustomerRealm();
        /*1.密码加盐*/
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        hashedCredentialsMatcher.setHashIterations(1024);
        customerRealm.setCredentialsMatcher(hashedCredentialsMatcher);

        /*2.设置缓存*/
        customerRealm.setCachingEnabled(true);
        customerRealm.setAuthorizationCachingEnabled(true);
        customerRealm.setAuthorizationCachingEnabled(true);
        customerRealm.setCacheManager(new EhCacheManager());

        return customerRealm;
    }

    @Bean
    @ConditionalOnMissingBean
    public net.sf.ehcache.CacheManager ehCacheCacheManager() {
        return CacheManager.create();
    }
}
