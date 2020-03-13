package com.itcast.dao;

import com.itcast.domain.Role;

import java.util.List;

public interface IRoleDao {
    List<Role> findAll();
}
