package com.beiyuan.houserentservice.infrastructure.das;

import com.beiyuan.houserentservice.infrastructure.database.elasticsearch.mapper.*;
import com.beiyuan.houserentservice.infrastructure.database.entity.*;
import com.beiyuan.houserentservice.infrastructure.database.mysql.mapper.*;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author: beiyuan
 */
@Component
public class MysqlSyncToES implements ApplicationRunner {


    @Autowired
    HouseMapper houseMapper;


    @Autowired
    HouseDetailMapper houseDetailMapper;

    @Autowired
    HousePictureMapper housePictureMapper;

    @Autowired
    HouseSubscribeMapper houseSubscribeMapper;

    @Autowired
    HouseTagMapper houseTagMapper;

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    SubwayMapper subwayMapper;

    @Autowired
    SubwayStationMapper subwayStationMapper;

    @Autowired
    SupportAddressMapper supportAddressMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    HouseESMapper  houseESMapper;

    @Autowired
    HouseDetailESMapper houseDetailESMapper;

    @Autowired
    HousePictureESMapper housePictureESMapper;

    @Autowired
    HouseSubscribeESMapper houseSubscribeESMapper;

    @Autowired
    HouseTagESMapper houseTagESMapper;

    @Autowired
    RoleESMapper roleESMapper;

    @Autowired
    SubwayESMapper subwayESMapper;

    @Autowired
    SubwayStationESMapper subwayStationESMapper;

    @Autowired
    SupportAddressESMapper supportAddressESMapper;

    @Autowired
    UserESMapper userESMapper;

    @Value("${elasticsearch.start.needsync}")
    boolean needsync;

    // 项目启动时同步   存在的问题是如果执行的方法耗时过长，会导致项目在方法执行期间无法提供服务
//    @PostConstruct
//    public void setUp(){
//        houseSync();
//        houseDetailSync();
//        System.out.println("init 。。。。");
//    }

    // 这个是项目启动后执行代码
    @Override
    public void run(ApplicationArguments args) throws Exception {
        if(needsync){
            houseSync();
            houseDetailSync();
            housePictureSync();
            houseSubscribeSync();
            houseTagSync();
            roleSync();
            subwaySync();
            subwayStationSync();
            supportAddressSync();
            userSync();
        }
    }

    // 每天凌晨3点进行全量
    @Scheduled(cron = "0 0 3 * * ?")
    public void houseSync(){
        List<House> houseList = houseMapper.selectList(null);
        houseESMapper.saveAll(houseList);
    }

    @Scheduled(cron = "0 0 3 * * ?")
    public void houseDetailSync(){
        List<HouseDetail> houseDetailList = houseDetailMapper.selectList(null);
        houseDetailESMapper.saveAll(houseDetailList);
    }

    @Scheduled(cron = "0 0 3 * * ?")
    public void housePictureSync(){
        List<HousePicture> housePictureList = housePictureMapper.selectList(null);
        housePictureESMapper.saveAll(housePictureList);
    }

    @Scheduled(cron = "0 0 3 * * ?")
    public void houseSubscribeSync(){
        List<HouseSubscribe> houseSubscribeList = houseSubscribeMapper.selectList(null);
        houseSubscribeESMapper.saveAll(houseSubscribeList);
    }

    @Scheduled(cron = "0 0 3 * * ?")
    public void houseTagSync(){
        List<HouseTag> houseTagList = houseTagMapper.selectList(null);
        houseTagESMapper.saveAll(houseTagList);
    }

    @Scheduled(cron = "0 0 3 * * ?")
    public void roleSync(){
        List<Role> roleList = roleMapper.selectList(null);
        roleESMapper.saveAll(roleList);
    }

    @Scheduled(cron = "0 0 3 * * ?")
    public void subwaySync(){
        List<Subway> subwayList = subwayMapper.selectList(null);
        subwayESMapper.saveAll(subwayList);
    }

    @Scheduled(cron = "0 0 3 * * ?")
    public void subwayStationSync(){
        List<SubwayStation> subwayStationList = subwayStationMapper.selectList(null);
        subwayStationESMapper.saveAll(subwayStationList);
    }

    @Scheduled(cron = "0 0 3 * * ?")
    public void supportAddressSync(){
        List<SupportAddress> supportAddressList = supportAddressMapper.selectList(null);
        supportAddressESMapper.saveAll(supportAddressList);
    }

    @Scheduled(cron = "0 0 3 * * ?")
    public void userSync(){
        List<User> userList = userMapper.selectList(null);
        userESMapper.saveAll(userList);
    }
}
