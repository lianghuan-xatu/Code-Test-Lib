package Service.Impl;
import Dao.Impl.UserDaoImpl;
import Dao.UserDao;
import Domain.PageBean;
import Domain.User;
import Service.UserService;
import org.apache.commons.beanutils.BeanUtils;

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

    @Override
    public void deleteUser(String id) {
        dao.deleteUser(Integer.parseInt(id));
    }

    @Override
    public User findUserById(String id) {
      return  dao.findUserById(Integer.parseInt(id));
    }

    @Override
    public void updateUser(User user) {
        dao.updateUser(user);
    }

    @Override
    public void deleteSelectedUser(String[] paraments) {
        for(int i=0;i<paraments.length;i++){
            dao.deleteUser(Integer.parseInt(paraments[i]));
        }
    }

    @Override
    public PageBean findByPage(String _currentPage, String _rows) {

        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        //创建空的PageBean对象
        PageBean<User> pb=new PageBean<>();
        //设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        //调用dao查询总记录数
        int totalCount=dao.findTotalCount(currentPage,rows);
        //计算总页数
        int totalPage=(totalCount % rows) == 0 ? totalCount/rows : (totalCount/rows)+1;
        pb.setTotalCount(totalCount);
        pb.setTotalPage(totalPage);
        //计算开始记录的索引
        int start=(currentPage-1)*rows;
        //调用daofindPageList查询结果集
        pb.setList(dao.findPageList(start,rows));
        //返回PageBean对象
        return pb;
    }
}
