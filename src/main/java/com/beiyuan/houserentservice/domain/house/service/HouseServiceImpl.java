package com.beiyuan.houserentservice.domain.house.service;

import com.beiyuan.houserentservice.infrastructure.database.elasticsearch.mapper.HouseESMapper;
import com.beiyuan.houserentservice.infrastructure.database.entity.House;
import com.beiyuan.houserentservice.infrastructure.database.mysql.mapper.HouseMapper;
import com.beiyuan.houserentservice.application.HouseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.SerializationUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 房屋信息表 服务实现类
 * </p>
 *
 * @author beiyuan
 * @since 2023-08-02
 */
@Service
public class HouseServiceImpl extends ServiceImpl<HouseMapper, House> implements HouseService {

    // todo 这个双缓存如何抽成一个工具类
    private LoadingCache<String, List<Integer>> titleCache;

    private LoadingCache<Integer, House> idCache;

    @Autowired
    HouseESMapper houseESMapper;

    {
        titleCache = CacheBuilder.newBuilder()
                .maximumSize(1000)   //超过最大数量：LRU进行清除
                .expireAfterAccess(30, TimeUnit.MINUTES)  // 超过30分钟未被访问则过期
                .build(new CacheLoader<String, List<Integer>>() {
                    @Override
                    public List<Integer> load(String title) throws Exception {
                        return loadDataFromESByTitle(title);
                    }
                });

        idCache = CacheBuilder.newBuilder()
                .maximumSize(1000)   //超过最大数量：LRU进行清除
                .expireAfterAccess(30, TimeUnit.MINUTES)  // 超过30分钟未被访问则过期
                .build(new CacheLoader<Integer, House>() {
                    @Override
                    public House load(Integer id) throws Exception {
                        return loadDataFromESById(id);
                    }
                });
    }

    private List<Integer> loadDataFromESByTitle(String title) {
        // 模糊匹配
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("title", title);
        Iterable<House> houses = houseESMapper.search(matchQueryBuilder);
        List<Integer> idList=new ArrayList<>();
        houses.forEach(house -> {
            idCache.put(house.getId(),house);
            idList.add(house.getId());
        });
        return idList;
    }

    private House loadDataFromESById(Integer id) {
        // 对输入的关键词不会分词。但是es那边的还是会分的
        // term对keyword类型查询才是完全精确匹配
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("id", id);
        Iterable<House> houses = houseESMapper.search(termQueryBuilder);
        List<House> houseListt=new ArrayList<>();
        houses.forEach(house -> {
            houseListt.add(house);
        });
        if(houseListt.size()==1){
            return houseListt.get(0);
        }
        return null;
    }

    @Override
    public List<House> queryByTitle(String title) {
        try {
            List<Integer> idList=titleCache.get(title);
            List<House> houseList=new ArrayList<>();
            idList.forEach(id->{
                try {
                    House house=SerializationUtils.clone(idCache.get(id));
                    houseList.add(house);
                } catch (ExecutionException e) {
                    // todo log
                }
            });
            return houseList;
        } catch (ExecutionException e) {
            // todo log
            return null;
        }
    }
}
