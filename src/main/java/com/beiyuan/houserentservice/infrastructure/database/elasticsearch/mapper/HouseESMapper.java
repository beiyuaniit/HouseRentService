package com.beiyuan.houserentservice.infrastructure.database.elasticsearch.mapper;

import com.beiyuan.houserentservice.infrastructure.database.entity.House;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 房屋信息表 Mapper 接口
 * </p>
 *
 * @author beiyuan
 * @since 2023-08-02
 */
@Repository
public interface HouseESMapper extends ElasticsearchRepository<House,Integer> {

}
