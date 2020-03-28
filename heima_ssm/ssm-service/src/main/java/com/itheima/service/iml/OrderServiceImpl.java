package com.itheima.service.iml;

import com.github.pagehelper.PageHelper;
import com.itheima.dao.IOrderDao;
import com.itheima.domain.Order;
import com.itheima.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private IOrderDao orderDao;
/*
    @Override
    public List<Order> findAll() {
        return orderDao.findAll();
    }
*/

    @Override
    public List<Order> findAll(int page, int size) {
        //参数pageNum是页码值   参数pageSize代表是每页显示条数
        PageHelper.startPage(page,size);
        return orderDao.findAll();
    }
}
