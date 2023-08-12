package com.beiyuan.houserentservice.test;

import com.beiyuan.houserentservice.infrastructure.database.entity.House;
import lombok.Data;

/**
 * @author: beiyuan
 */
@Data
public class AAB {

    private Integer id;

    private String name;

    @Override
    public String toString(){
        return "kkk";
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AAB other = (AAB) obj;
        return id.equals(other.id);
    }
}
