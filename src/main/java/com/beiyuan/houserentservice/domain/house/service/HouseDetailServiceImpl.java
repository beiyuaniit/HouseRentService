package com.beiyuan.houserentservice.domain.house.service;

import com.beiyuan.houserentservice.infrastructure.database.entity.HouseDetail;
import com.beiyuan.houserentservice.infrastructure.database.mysql.mapper.HouseDetailMapper;
import com.beiyuan.houserentservice.application.HouseDetailService;
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
public class HouseDetailServiceImpl extends ServiceImpl<HouseDetailMapper, HouseDetail> implements HouseDetailService {

}
