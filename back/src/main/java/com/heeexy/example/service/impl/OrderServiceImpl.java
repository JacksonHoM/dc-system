package com.heeexy.example.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.heeexy.example.dao.OrderDao;
import com.heeexy.example.pojo.Order;
import com.heeexy.example.pojo.OrderItem;
import com.heeexy.example.pojo.OrderUser;
import com.heeexy.example.service.OrderService;
import com.heeexy.example.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public JSONObject loadOrders(String username) {
        OrderUser orderUser = orderDao.findorderuserByUsername(username);
        Integer ouid = orderUser.getOuId();
        QueryWrapper<Order> qw = new QueryWrapper<>();
        qw.eq("user_name", ouid);
        Order order = orderDao.selectOne(qw);
        OrderItem orderItem = orderDao.findorderitemByotId(order.getOrderItemId());
        order.setOrderItem(orderItem).setOrderUser(orderUser);
        return CommonUtil.successJson(order);
    }

    @Override
    public JSONObject updatePayType(JSONObject requestJson) {
        String orderPayType = requestJson.getString("order_paytype");
        String orderNum = requestJson.getString("order_num");
        orderDao.updatePayType(orderNum,orderPayType);
        return CommonUtil.successJson();

    }
}
