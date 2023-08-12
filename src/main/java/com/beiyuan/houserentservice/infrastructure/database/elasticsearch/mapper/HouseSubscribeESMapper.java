package com.beiyuan.houserentservice.infrastructure.database.elasticsearch.mapper;

import com.beiyuan.houserentservice.infrastructure.database.entity.HouseSubscribe;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 预约看房信息表 Mapper 接口
 * </p>
 *
 * @author beiyuan
 * @since 2023-08-02
 */
@Repository
public interface HouseSubscribeESMapper extends ElasticsearchRepository<HouseSubscribe,Integer> {

}
