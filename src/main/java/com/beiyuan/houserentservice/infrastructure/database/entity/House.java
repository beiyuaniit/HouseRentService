package com.beiyuan.houserentservice.infrastructure.database.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * <p>
 * 房屋信息表
 * </p>
 *
 * @author beiyuan
 * @since 2023-08-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Document(indexName = "house", shards = 3, replicas = 1)
public class House implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * house唯一标识
     */
    @Id
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String title;

    /**
     * 价格
     */
    private Integer price;

    /**
     * 面积
     */
    private Integer area;

    /**
     * 卧室数量
     */
    private Integer room;

    /**
     * 楼层
     */
    private Integer floor;

    /**
     * 总楼层
     */
    private Integer totalFloor;

    /**
     * 被看次数
     */
    private Integer watchTimes;

    /**
     * 建立年限
     */
    private Integer buildYear;

    /**
     * 房屋状态 0-未审核 1-审核通过 2-已出租 3-逻辑删除
     */
    private Integer status;

    /**
     * 创建时间
     */
    @Field(type = FieldType.Date,format = DateFormat.custom,pattern ="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime createTime;

    /**
     * 最近数据更新时间
     */
    @Field(type = FieldType.Date,format = DateFormat.custom,pattern ="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime lastUpdateTime;

    /**
     * 城市标记缩写 如 北京bj
     */
    private String cityEnName;

    /**
     * 地区英文简写 如昌平区 cpq
     */
    private String regionEnName;

    /**
     * 封面
     */
    private String cover;

    /**
     * 房屋朝向
     */
    private Integer direction;

    /**
     * 距地铁距离 默认-1 附近无地铁
     */
    private Integer distanceToSubway;

    /**
     * 客厅数量
     */
    private Integer parlour;

    /**
     * 所在小区
     */
    private String district;

    /**
     * 所属管理员id
     */
    private Integer adminId;

    private Integer bathroom;

    /**
     * 街道
     */
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String street;
}
