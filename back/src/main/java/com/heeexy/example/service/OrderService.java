package com.heeexy.example.service;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface OrderService {


    JSONObject loadOrders(String username);

    //JSONObject updatePayType(JSONObject requestJson);

    JSONObject submitOrder(JSONObject requestJson,String username);

    JSONObject updateItemNum(JSONObject requestJson);
}
