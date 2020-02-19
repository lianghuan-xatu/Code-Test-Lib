package Dao;

import Domain.User;

import java.util.List;

public interface UserDao
{
    public List<User> findAll();
}
