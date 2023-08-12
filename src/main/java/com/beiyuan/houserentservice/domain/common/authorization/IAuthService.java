package com.beiyuan.houserentservice.domain.common.authorization;

/**
 * @author: beiyuan
 * @date: 2023/5/20  23:38
 */
public interface IAuthService {
    //接口中方法默认pulic，volidate有验证的意思
    boolean validate(String userId,String token);
}
