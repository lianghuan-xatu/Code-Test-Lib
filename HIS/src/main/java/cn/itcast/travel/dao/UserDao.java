package cn.itcast.travel.dao;

import cn.itcast.travel.domain.User;

public interface UserDao
{
    public void save(User user);
    public User findByUsername(String username);

    User findByCode(String code);

    void updateStatus(User user);


    User findByUsernameAndPassword(String username, String password);
}
