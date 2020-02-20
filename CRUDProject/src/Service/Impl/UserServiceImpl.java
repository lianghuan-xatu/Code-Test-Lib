package Service.Impl;

import Dao.Impl.UserDaoImpl;
import Dao.UserDao;
import Domain.User;
import Service.UserService;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao dao = new UserDaoImpl();
    @Override
    public List<User> findAll() {
        //调用Dao完成操作
        return dao.findAll();
    }
    public User login(User user){
        return dao.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public void addUser(User user) {
        dao.addUser(user);
    }
}
