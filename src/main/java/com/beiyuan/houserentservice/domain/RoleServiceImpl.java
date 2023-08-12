package com.beiyuan.houserentservice.domain;

import com.beiyuan.houserentservice.infrastructure.database.entity.Role;
import com.beiyuan.houserentservice.infrastructure.database.mysql.mapper.RoleMapper;
import com.beiyuan.houserentservice.application.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色表 服务实现类
 * </p>
 *
 * @author beiyuan
 * @since 2023-08-02
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
