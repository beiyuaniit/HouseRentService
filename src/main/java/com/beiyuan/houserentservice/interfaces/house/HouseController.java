package com.beiyuan.houserentservice.interfaces.house;


import com.beiyuan.houserentservice.application.HouseService;
import com.beiyuan.houserentservice.domain.common.result.Result;
import com.beiyuan.houserentservice.infrastructure.common.PageLimiter;
import com.beiyuan.houserentservice.infrastructure.database.elasticsearch.mapper.HouseESMapper;
import com.beiyuan.houserentservice.infrastructure.database.entity.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @Autowired
    HouseESMapper houseESMapper;

    @GetMapping("list")
    public Result getList(PageLimiter pageLimiter){
        PageRequest pageRequest=PageRequest.of(pageLimiter.getPage(),pageLimiter.getSize());
        List<House> houseList = houseESMapper.findAll(pageRequest).toList();
        return Result.success(houseList);
    }
}

