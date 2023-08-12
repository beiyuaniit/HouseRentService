package com.beiyuan.houserentservice.domain.house.service;

import com.beiyuan.houserentservice.infrastructure.database.entity.HousePicture;
import com.beiyuan.houserentservice.infrastructure.database.mysql.mapper.HousePictureMapper;
import com.beiyuan.houserentservice.application.HousePictureService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 房屋图片信息 服务实现类
 * </p>
 *
 * @author beiyuan
 * @since 2023-08-02
 */
@Service
public class HousePictureServiceImpl extends ServiceImpl<HousePictureMapper, HousePicture> implements HousePictureService {

}
