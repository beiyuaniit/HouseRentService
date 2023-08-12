package com.beiyuan.houserentservice.domain.common.authorization;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * 自定义网关的token格式
 * @author: beiyuan
 * @date: 2023/5/20  23:58
 * AuthenticationToken 这个接口只有两个接口，所以可以自己定义token格式。UsernamePasswordToken就是其实现类
 */
public class GlobalAuthorizingToken implements AuthenticationToken {

    //token要序列化
    private static long serialVersionUID =1L;


    private String userId;

    //密文串
    private String jwt;

    public GlobalAuthorizingToken() {
    }

    public GlobalAuthorizingToken(String userId, String jwt) {
        this.userId = userId;
        this.jwt = jwt;
    }


    /**
     * Principal：主体
     */
    @Override
    public Object getPrincipal() {
        return this.userId;
    }

    /**
     * Credentials:资格证书
     * @return
     */
    @Override
    public Object getCredentials() {
        return this.jwt;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    //验证时用的是String，加个get更加方便
    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
