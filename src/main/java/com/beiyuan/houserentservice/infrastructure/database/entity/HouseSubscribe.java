package com.beiyuan.houserentservice.infrastructure.database.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 预约看房信息表
 * </p>
 *
 * @author beiyuan
 * @since 2023-08-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class HouseSubscribe implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 房源id
     */
    private Integer houseId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户描述
     */
    private String desc;

    /**
     * 预约状态 1-加入待看清单 2-已预约看房时间 3-看房完成
     */
    private Integer status;

    /**
     * 数据创建时间
     */
    private LocalDateTime createTime;

    /**
     * 记录更新时间
     */
    private LocalDateTime lastUpdateTime;

    /**
     * 预约时间
     */
    private LocalDateTime orderTime;

    /**
     * 联系电话
     */
    private String telephone;

    /**
     * 房源发布者id
     */
    private Integer adminId;


}
