package Service;

import Domain.User;

import java.util.List;

public interface UserService
{
    public List<User> findAll();
    public User login(User user);
    public void addUser(User user);
}
