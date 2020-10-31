package com.heeexy.example.dao;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heeexy.example.pojo.Order;
import com.heeexy.example.pojo.OrderItem;
import com.heeexy.example.pojo.OrderUser;
import org.apache.ibatis.annotations.Param;

public interface OrderDao extends BaseMapper<Order> {

    int updatePayType(@Param("orderNum") String orderNum, @Param("orderPayType") String orderPayType);


    OrderUser findorderuserByUsername(@Param("username") String username);

    OrderItem findorderitemByotId(@Param("orderItemId") Integer orderItemId);
}
