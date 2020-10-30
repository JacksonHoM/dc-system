package com.heeexy.example.service.impl;

import com.heeexy.example.dao.OrderDao;
import com.heeexy.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;


}
