package com.beiyuan.houserentservice.infrastructure.database.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * <p>
 * 
 * </p>
 *
 * @author beiyuan
 * @since 2023-08-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Document(indexName = "supportaddress", shards = 3, replicas = 1)
public class SupportAddress implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 上一级行政单位名
     */
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String belongTo;

    /**
     * 行政单位英文名缩写
     */
    private String enName;

    /**
     * 行政单位中文名
     */
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String cnName;

    /**
     * 行政级别 市-city 地区-region
     */
    private String level;

    /**
     * 百度地图经度
     */
    private Double baiduMapLng;

    /**
     * 百度地图纬度
     */
    private Double baiduMapLat;


}
