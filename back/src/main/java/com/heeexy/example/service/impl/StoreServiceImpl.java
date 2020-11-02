package com.heeexy.example.service.impl;

import com.heeexy.example.dao.StoreDao;
import com.heeexy.example.pojo.Store;
import com.heeexy.example.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreDao storeDao;

    @Override
    public Store findAll() {
        return storeDao.findAll();
    }

    @Override
    public void addStore() {
        storeDao.addStore();
    }
}
