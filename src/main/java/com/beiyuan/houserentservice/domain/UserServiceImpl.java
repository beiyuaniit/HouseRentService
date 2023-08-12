package com.beiyuan.houserentservice.domain;

import com.beiyuan.houserentservice.infrastructure.database.entity.User;
import com.beiyuan.houserentservice.infrastructure.database.mapper.UserMapper;
import com.beiyuan.houserentservice.application.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户基本信息表 服务实现类
 * </p>
 *
 * @author beiyuan
 * @since 2023-08-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
