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
@Document(indexName = "housedetail", shards = 3, replicas = 1)
public class HouseDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 详细描述
     */
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String description;

    /**
     * 户型介绍
     */
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String layoutDesc;

    /**
     * 交通出行
     */
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String traffic;

    /**
     * 周边配套
     */
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String roundService;

    /**
     * 租赁方式
     */
    private Integer rentWay;

    /**
     * 详细地址 
     */
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String address;

    /**
     * 附近地铁线id
     */
    private Integer subwayLineId;

    /**
     * 附近地铁线名称
     */
    private String subwayLineName;

    /**
     * 地铁站id
     */
    private Integer subwayStationId;

    /**
     * 地铁站名
     */
    private String subwayStationName;

    /**
     * 对应house的id
     */
    private Integer houseId;

}
