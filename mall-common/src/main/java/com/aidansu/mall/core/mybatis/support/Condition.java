package com.aidansu.mall.core.mybatis.support;

import com.aidansu.mall.core.utils.BeanUtil;
import com.aidansu.mall.core.utils.Func;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 分页工具
 *
 * @author Chill
 */
public class Condition {

    /**
     * 转化成mybatis plus中的Page
     *
     * @param query
     * @return
     */
    public static <T> IPage<T> getPage(Query query) {
        Page<T> page = new Page<>(Func.toInt(query.getCurrent(), 1), Func.toInt(query.getSize(), 10));
        String[] ascArray = Func.toStrArray(SqlKeyword.filter(query.getAscs()));
        String[] descArray = Func.toStrArray(SqlKeyword.filter(query.getDescs()));
        List<OrderItem> orders = new ArrayList<>();
        if (ascArray.length > 0) {
            for (String column : ascArray) {
                OrderItem ascItem = new OrderItem();
                ascItem.setColumn(column);
                ascItem.setAsc(true);
                orders.add(ascItem);
            }
        }
        if (descArray.length > 0) {
            for (String column : descArray) {
                OrderItem descItem = new OrderItem();
                descItem.setColumn(column);
                descItem.setAsc(false);
                orders.add(descItem);
            }
        }

        page.setOrders(orders);
        return page;
    }

    /**
     * 获取mybatis plus中的QueryWrapper
     *
     * @param entity
     * @param <T>
     * @return
     */
    public static <T> QueryWrapper<T> getQueryWrapper(T entity) {
        return new QueryWrapper<>(entity);
    }

    /**
     * 获取mybatis plus中的QueryWrapper
     *
     * @param query
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> QueryWrapper<T> getQueryWrapper(Map<String, Object> query, Class<T> clazz) {
        query.remove("current");
        query.remove("size");
        QueryWrapper<T> qw = new QueryWrapper<>();
        qw.setEntity(BeanUtil.newInstance(clazz));
        SqlKeyword.buildCondition(query, qw);
        return qw;
    }

}
