package com.beiyuan.houserentservice;

import com.beiyuan.houserentservice.application.HouseService;
import com.beiyuan.houserentservice.domain.common.authorization.IAuthService;
import com.beiyuan.houserentservice.domain.common.authorization.JwtUtil;
import com.beiyuan.houserentservice.infrastructure.database.elasticsearch.mapper.HouseESMapper;
import com.beiyuan.houserentservice.infrastructure.database.elasticsearch.mapper.HouseTagESMapper;
import com.beiyuan.houserentservice.infrastructure.database.entity.House;
import com.beiyuan.houserentservice.infrastructure.database.entity.HouseTag;
import com.beiyuan.houserentservice.infrastructure.database.mysql.mapper.HouseMapper;
import com.beiyuan.houserentservice.test.AAB;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@SpringBootTest
class HouseRentServiceApplicationTests {

    @Autowired
    ElasticsearchRestTemplate esRestTemplate;

    @Test
    void contextLoads() {
    }

    @Autowired
    HouseTagESMapper houseTagESMapper;

    @Test
    void testElasticSearch(){
        HouseTag houseTag1=new HouseTag();
        // 若是不指定id，则es自动生成的id是String类型的，不符合Integer
        houseTag1.setId(1);
        houseTag1.setName("茅屋");
        houseTagESMapper.save(houseTag1);
    }

    // 查询并更新
    @Test
    void testElasticSearchUpdate(){
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("id", "1");
        Iterable<HouseTag> houseTags = houseTagESMapper.search(termQueryBuilder);
        for (HouseTag houseTag : houseTags) {
            houseTag.setName("茅屋秋风");
            houseTagESMapper.save(houseTag);
            System.out.println(houseTagESMapper.findById(houseTag.getId()));
        }
    }

    // 查询并更新
    @Test
    void testElasticSearchUpdate01(){
        // 匹配不到，TermQueryBuilder自带的bug？？
        // 这个是精确查询。。？？不分词
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", "秋风");
        Iterable<HouseTag> houseTags = houseTagESMapper.search(termQueryBuilder);
        for (HouseTag houseTag : houseTags) {
            houseTag.setName("秋风所破");
            houseTagESMapper.save(houseTag);
            System.out.println(houseTagESMapper.findById(houseTag.getId()));
        }
    }

    @Test
    void testElasticSearchUpdate02(){
        // 匹配不到，TermQueryBuilder自带的bug？？ 全文检索，用这个就好了
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("name", "秋风");
        Iterable<HouseTag> houseTags = houseTagESMapper.search(matchQueryBuilder);
        for (HouseTag houseTag : houseTags) {
            houseTag.setName("秋风");
            houseTagESMapper.save(houseTag);
            System.out.println(houseTagESMapper.findById(houseTag.getId()));
        }
    }


    //
    @Test
    void deleteIndex(){
        esRestTemplate.deleteIndex("housetag");
    }

    @Autowired
    HouseMapper houseMapper;

    @Autowired
    HouseService houseService;

    @Test
    void testSync(){
        List<House> houses = houseMapper.selectList(null);
        System.out.println(houses.size());
    }

    @Test
    void getHouseSize(){
        List<House> houseList = houseService.list();
        System.out.println(houseList.size());
    }

    @Autowired
    HouseESMapper houseESMapper;

    @Test
    void testEsTemplate(){
        PageRequest pageRequest=PageRequest.of(0,3);
        List<House> houseList = houseESMapper.findAll(pageRequest).toList();
        System.out.println(houseList.size());
    }

    @Test
    void deleteAllIndex(){
        esRestTemplate.deleteIndex("house");
        esRestTemplate.deleteIndex("housedetail");
        esRestTemplate.deleteIndex("housepicture");
        esRestTemplate.deleteIndex("housesubscribe");
        esRestTemplate.deleteIndex("housetag");
        esRestTemplate.deleteIndex("role");
        esRestTemplate.deleteIndex("subwaystation");
        esRestTemplate.deleteIndex("supportaddress");
        esRestTemplate.deleteIndex("user");
    }

    @Test
    void testLombok(){
        AAB a=new AAB();
        a.setName("iii");

        System.out.println(a); // kkk

        a.setId(1);

        AAB b=new AAB();
        b.setId(1);
        b.setName("oooo");

        HashSet<AAB> set=new HashSet<>();
        set.add(a);

        // 不会拿b去更新
        set.add(b);

        System.out.println("ll");
    }

    @Autowired
    IAuthService authService;
    @Test
    void testJwt(){
        String issuer="beiyuan";
        long ttlMillis= 7 * 24 * 60 * 60 * 1000L;//单位是毫秒a。。
        Map<String,Object> claims=new HashMap<>();
        claims.put("key","kkk");

        //根据用户名生成token密文
        String jwt = JwtUtil.encode(issuer, ttlMillis, claims);
        System.out.println(jwt);//eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJiZWl5dWFuIiwiZXhwIjoxNjg1MjYxMjY0LCJrZXkiOiJra2sifQ.nBXrmzqc4WOqW7fR9NnlNUSr7kv4YhJBxiNuCJ3T9uU

        //根据密文返回用户信息
        System.out.println(JwtUtil.decode(jwt).getSubject());//beiyuan

        String userId="beiyuan";
        String token="eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJiZWl5dWFuIiwiZXhwIjoxNjkzNjYzOTE2LCJrZXkiOiJra2sifQ.GLY2XY_XYsYxRXtdwxhbIAVlkE84OiOBGHglJOG-20U";
        System.out.println(authService.validate(userId, token)); // true
    }
}
