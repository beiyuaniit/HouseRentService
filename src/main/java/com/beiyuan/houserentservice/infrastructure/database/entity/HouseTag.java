package com.beiyuan.houserentservice.infrastructure.database.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * <p>
 * 房屋标签映射关系表
 * </p>
 *
 * @author beiyuan
 * @since 2023-08-02
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@Document(indexName = "housetag",type = "_doc",shards = 3, replicas = 1)
public class HouseTag implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * type : 字段数据类型
     * analyzer : 分词器类型
     * index : 是否索引(默认:true)
     * Keyword : 短语,不进行分词
     */

    /**
     * 标签id
     */
    @Id
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 房屋id
     */
    @Field(type = FieldType.Integer)
    private Integer houseId;

    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String name;
}
