package com.beiyuan.houserentservice.domain.common.result;

import lombok.*;

/**
 * @author: beiyuan
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    private String code;

    private String message;

    private Object data;

    public static Result success(Object data){
        return new Result("200","success",data);
    }
}
