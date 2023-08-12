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
 * 房屋图片信息
 * </p>
 *
 * @author beiyuan
 * @since 2023-08-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Document(indexName = "housepicture", shards = 3, replicas = 1)
public class HousePicture implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 所属房屋id
     */
    private Integer houseId;

    /**
     * 图片路径
     */
    private String cdnPrefix;

    /**
     * 宽
     */
    private Integer width;

    /**
     * 高
     */
    private Integer height;

    /**
     * 所属房屋位置
     */
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String location;

    /**
     * 文件名
     */
    private String path;


}
