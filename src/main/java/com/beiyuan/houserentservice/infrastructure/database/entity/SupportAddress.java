package com.beiyuan.houserentservice.infrastructure.database.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
public class SupportAddress implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 上一级行政单位名
     */
    private String belongTo;

    /**
     * 行政单位英文名缩写
     */
    private String enName;

    /**
     * 行政单位中文名
     */
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
