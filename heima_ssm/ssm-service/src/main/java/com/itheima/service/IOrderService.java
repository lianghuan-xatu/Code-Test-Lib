package com.itheima.service;

import com.itheima.domain.Order;

import java.util.List;

public interface IOrderService
{
  /*  List<Order> findAll();*/

    List<Order> findAll(int page, int size);

    Order findById(String orderId);
}
