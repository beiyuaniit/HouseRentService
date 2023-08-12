package com.beiyuan.houserentservice.domain;

import com.beiyuan.houserentservice.infrastructure.database.entity.SupportAddress;
import com.beiyuan.houserentservice.infrastructure.database.mysql.mapper.SupportAddressMapper;
import com.beiyuan.houserentservice.application.SupportAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author beiyuan
 * @since 2023-08-02
 */
@Service
public class SupportAddressServiceImpl extends ServiceImpl<SupportAddressMapper, SupportAddress> implements SupportAddressService {

}
