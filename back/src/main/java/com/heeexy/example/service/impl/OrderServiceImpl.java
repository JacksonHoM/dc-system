package com.heeexy.example.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.heeexy.example.dao.OrderDao;
import com.heeexy.example.dao.OrderItemDao;
import com.heeexy.example.dao.OrderUserDao;
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
    @Autowired
    private OrderItemDao orderItemDao;
    @Autowired
    private OrderUserDao orderUserDao;

    @Override
    public JSONObject loadOrders(String username) {
        QueryWrapper<OrderUser> qw1 = new QueryWrapper<>();
        qw1.eq("user_name", username);
        OrderUser orderUser = orderUserDao.selectOne(qw1);
        QueryWrapper<Order> qw2 = new QueryWrapper<>();
        qw2.eq("user_name", orderUser.getOuId());
        Order order = orderDao.selectOne(qw2);
        QueryWrapper<OrderItem> qw3 = new QueryWrapper<>();
        qw3.eq("ot_id",order.getOrderItemId());
        OrderItem orderItem = orderItemDao.selectOne(qw3);
        order.setOrderItem(orderItem).setOrderUser(orderUser);
        return CommonUtil.successJson(order);
    }

   /* @Override
    public JSONObject updatePayType(JSONObject requestJson) {
        String orderPayType = requestJson.getString("order_paytype");
        String orderNum = requestJson.getString("order_num");
        orderDao.updatePayType(orderNum,orderPayType);
        return CommonUtil.successJson();

    }*/

    @Override
    public JSONObject submitOrder(JSONObject requestJson,String username) {
        QueryWrapper<OrderUser> qw1 = new QueryWrapper<>();
        qw1.eq("user_name", username);
        OrderUser orderUser = orderUserDao.selectOne(qw1);
        QueryWrapper<Order> qw2 = new QueryWrapper<>();
        qw2.eq("user_name", orderUser.getOuId());
        Order order = orderDao.selectOne(qw2);
        String orderPayType = requestJson.getString("order_paytype");
        order.setOrderPayType(orderPayType);
        String orderNum = order.getOrderId()+""+order.getOrderUserId()+System.currentTimeMillis();
        order.setOrderNum(orderNum);
        orderDao.update(order,qw2);
        return CommonUtil.successJson(order);
    }

    @Override
    public JSONObject updateItemNum(JSONObject requestJson) {
        OrderItem orderItem = requestJson.getObject("itemData", OrderItem.class);
        Integer orderId = requestJson.getInteger("order_id");
        QueryWrapper<Order> qw = new QueryWrapper<>();
        qw.eq("order_id",orderId);
        Order order = orderDao.selectOne(qw);
        UpdateWrapper<OrderItem> uw = new UpdateWrapper<>();
        uw.eq("ot_id", order.getOrderItemId());
        orderItemDao.update(orderItem, uw);
        return CommonUtil.successJson(order);
    }
}
