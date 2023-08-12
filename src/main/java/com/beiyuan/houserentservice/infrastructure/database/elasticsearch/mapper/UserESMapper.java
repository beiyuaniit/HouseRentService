package com.beiyuan.houserentservice.infrastructure.database.elasticsearch.mapper;


import com.beiyuan.houserentservice.infrastructure.database.entity.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户基本信息表 Mapper 接口
 * </p>
 *
 * @author beiyuan
 * @since 2023-08-02
 */
@Repository
public interface UserESMapper extends ElasticsearchRepository<User,Integer> {

}
