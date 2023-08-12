package com.beiyuan.houserentservice.application;

import com.beiyuan.houserentservice.infrastructure.database.entity.House;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 房屋信息表 服务类
 * </p>
 *
 * @author beiyuan
 * @since 2023-08-02
 */
public interface HouseService extends IService<House>{

    List<House> queryByTitle(String title);
}
