package com.beiyuan.houserentservice.infrastructure.database.elasticsearch.mapper;

import com.beiyuan.houserentservice.infrastructure.database.entity.SupportAddress;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author beiyuan
 * @since 2023-08-02
 */
@Repository
public interface SupportAddressESMapper extends ElasticsearchRepository<SupportAddress,Integer> {

}
