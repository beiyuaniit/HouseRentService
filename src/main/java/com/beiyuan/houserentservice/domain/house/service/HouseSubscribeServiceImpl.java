package com.beiyuan.houserentservice.domain.house.service;

import com.beiyuan.houserentservice.infrastructure.database.entity.HouseSubscribe;
import com.beiyuan.houserentservice.infrastructure.database.mysql.mapper.HouseSubscribeMapper;
import com.beiyuan.houserentservice.application.HouseSubscribeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 预约看房信息表 服务实现类
 * </p>
 *
 * @author beiyuan
 * @since 2023-08-02
 */
@Service
public class HouseSubscribeServiceImpl extends ServiceImpl<HouseSubscribeMapper, HouseSubscribe> implements HouseSubscribeService {

}
