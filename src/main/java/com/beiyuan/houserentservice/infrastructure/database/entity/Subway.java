package com.beiyuan.houserentservice.infrastructure.database.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

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
@Document(indexName = "subway", shards = 3, replicas = 1)
public class Subway implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 线路名
     */
    private String name;

    /**
     * 所属城市英文名缩写
     */
    private String cityEnName;


}
