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
public class HouseDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 详细描述
     */
    private String description;

    /**
     * 户型介绍
     */
    private String layoutDesc;

    /**
     * 交通出行
     */
    private String traffic;

    /**
     * 周边配套
     */
    private String roundService;

    /**
     * 租赁方式
     */
    private Integer rentWay;

    /**
     * 详细地址 
     */
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
