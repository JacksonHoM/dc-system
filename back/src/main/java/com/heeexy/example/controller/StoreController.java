package com.heeexy.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.pojo.Store;
import com.heeexy.example.service.StoreService;
import com.heeexy.example.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreController {

    @Autowired
    private StoreService storeService;

    public JSONObject checkAllMer(){
        Store store = storeService.findAll();
        return CommonUtil.successJson(store);
    }

    public void addStore(){
        storeService.addStore();
    }
}
