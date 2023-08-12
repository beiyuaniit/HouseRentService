package com.beiyuan.houserentservice.domain.house.service;

import com.beiyuan.houserentservice.infrastructure.database.entity.HouseTag;
import com.beiyuan.houserentservice.infrastructure.database.mapper.HouseTagMapper;
import com.beiyuan.houserentservice.application.HouseTagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 房屋标签映射关系表 服务实现类
 * </p>
 *
 * @author beiyuan
 * @since 2023-08-02
 */
@Service
public class HouseTagServiceImpl extends ServiceImpl<HouseTagMapper, HouseTag> implements HouseTagService {

}
