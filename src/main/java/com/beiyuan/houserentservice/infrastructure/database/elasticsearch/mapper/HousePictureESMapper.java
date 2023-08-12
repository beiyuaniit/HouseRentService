package com.beiyuan.houserentservice.infrastructure.database.elasticsearch.mapper;

import com.beiyuan.houserentservice.infrastructure.database.entity.HousePicture;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 房屋图片信息 Mapper 接口
 * </p>
 *
 * @author beiyuan
 * @since 2023-08-02
 */
@Repository
public interface HousePictureESMapper extends ElasticsearchRepository<HousePicture,Integer> {

}
