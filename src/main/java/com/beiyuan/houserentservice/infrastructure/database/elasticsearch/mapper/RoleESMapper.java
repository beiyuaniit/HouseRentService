package com.beiyuan.houserentservice.infrastructure.database.elasticsearch.mapper;

import com.beiyuan.houserentservice.infrastructure.database.entity.Role;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户角色表 Mapper 接口
 * </p>
 *
 * @author beiyuan
 * @since 2023-08-02
 */
@Repository
public interface RoleESMapper extends ElasticsearchRepository<Role,Integer> {

}
