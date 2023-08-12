package com.beiyuan.houserentservice.infrastructure.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: beiyuan
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageLimiter {

    private Integer page;

    private Integer size;

}
