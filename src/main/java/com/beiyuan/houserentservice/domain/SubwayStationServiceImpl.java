package com.beiyuan.houserentservice.domain;

import com.beiyuan.houserentservice.infrastructure.database.entity.SubwayStation;
import com.beiyuan.houserentservice.infrastructure.database.mapper.SubwayStationMapper;
import com.beiyuan.houserentservice.application.SubwayStationService;
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
public class SubwayStationServiceImpl extends ServiceImpl<SubwayStationMapper, SubwayStation> implements SubwayStationService {

}
