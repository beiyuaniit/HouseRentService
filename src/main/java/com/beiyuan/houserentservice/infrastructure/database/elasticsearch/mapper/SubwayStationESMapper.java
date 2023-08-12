package com.beiyuan.houserentservice.infrastructure.database.elasticsearch.mapper;


import com.beiyuan.houserentservice.infrastructure.database.entity.SubwayStation;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author beiyuan
 * @since 2023-08-02
 */
public interface SubwayStationESMapper extends ElasticsearchRepository<SubwayStation,Integer> {

}
