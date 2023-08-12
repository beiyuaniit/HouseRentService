package com.beiyuan.houserentservice.domain;

import com.beiyuan.houserentservice.infrastructure.database.entity.Subway;
import com.beiyuan.houserentservice.infrastructure.database.mapper.SubwayMapper;
import com.beiyuan.houserentservice.application.SubwayService;
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
public class SubwayServiceImpl extends ServiceImpl<SubwayMapper, Subway> implements SubwayService {

}
