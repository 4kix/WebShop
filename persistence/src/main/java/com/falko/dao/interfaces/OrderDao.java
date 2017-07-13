package com.falko.dao.interfaces;

import com.falko.model.Order;

import java.io.UnsupportedEncodingException;
import java.util.List;


public interface OrderDao {

    int saveOrder(Order order);
    Order getById(int id);
    List<Order> getAllOrders();
    void updateStatus(int id, String status) throws UnsupportedEncodingException;

}
