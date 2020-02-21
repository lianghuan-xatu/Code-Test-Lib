package Dao;

import Domain.User;
import org.springframework.jdbc.support.CustomSQLErrorCodesTranslation;

import java.util.List;

public interface UserDao {
    public List<User> findAll();

    public User findUserByUsernameAndPassword(String username, String password);

    public void addUser(User user);

    public void deleteUser(int id);

    public User findUserById(int id);

    public void updateUser(User user);

    public int findTotalCount(int currentPage, int rows);

    public List<User> findPageList(int start, int rows);
}
