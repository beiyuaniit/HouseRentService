package com.beiyuan.houserentservice.infrastructure.database.elasticsearch;

/**
 * @author: beiyuan
 */

public enum ESIndexEnum {

    HOUSE("house"),

    HOUSEDETAIL("housedetail"),

    HOUSEPICTURE("housepicture"),

    HOUSESUBSCRIBE("housesubscribe"),

    HOUSETAG("housetag"),

    ROLE("role"),

    SUBWAY("subway"),

    SUBWATSTATION("subwaystation"),

    SUPPORTADDRESS("supportaddress"),

    USER("user");

    private String indexName;

    ESIndexEnum(String indexName){
        this.indexName=indexName;
    }

    public String getIndexName(){
        return indexName;
    }
}
