package com.beiyuan.houserentservice.domain.common.model;

import lombok.Data;

/**
 * Datatables响应结构
 */
@Data
public class ApiDataTableResponse extends ApiResponse {
    private int draw;
    private long recordsTotal;
    private long recordsFiltered;

    public ApiDataTableResponse(ApiResponse.Status status) {
        this(status.getCode(), status.getStandardMessage(), null);
    }

    public ApiDataTableResponse() {
        super();
    }
    public ApiDataTableResponse(int code, String message, Object data) {
        super(code, message, data);
    }
}
