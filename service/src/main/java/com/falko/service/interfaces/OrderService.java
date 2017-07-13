package com.falko.service.interfaces;

import com.falko.model.Order;

import java.io.UnsupportedEncodingException;
import java.util.List;


public interface OrderService {

    int saveOrder(Order order);
    Order getOrderById(int id);
    List<Order> getAllOrders();
    void updateStatus(int id, String status) throws UnsupportedEncodingException;
}
