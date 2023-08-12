package com.beiyuan.houserentservice.interfaces.house;


import com.beiyuan.houserentservice.application.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 房屋信息表 前端控制器
 * </p>
 *
 * @author beiyuan
 * @since 2023-08-02
 */
@RestController
@RequestMapping("houserentservice/house")
public class HouseController {

    @Autowired
    HouseService houseService;

    @GetMapping("list")
    public String getList(){
        return houseService.list().toString();
    }
}

