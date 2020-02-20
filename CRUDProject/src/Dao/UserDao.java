package Dao;

import Domain.User;
import org.springframework.jdbc.support.CustomSQLErrorCodesTranslation;

import java.util.List;

public interface UserDao
{
    public List<User> findAll();
    public User findUserByUsernameAndPassword(String username,String password);
    public void addUser(User user);
}
