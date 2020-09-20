package itcastDao.Impl;

import itcastDao.ItemsDao;
import itcastDomain.Items;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemsDaoImpl implements ItemsDao {
    @Override
    public List<Items> findAll() {
        //加载驱动
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<Items> list=new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //获取connection对象
            connection= DriverManager.getConnection("jdbc:mysql:///day23","root","12345678");
            //获取真正的数据对象
            ps= connection.prepareCall("select * from province");
            resultSet= ps.executeQuery();

            while(resultSet.next()){
                Items items=new Items();
                items.setId(resultSet.getInt("id"));
                items.setName(resultSet.getString("NAME"));
                list.add(items);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
         if(resultSet!=null){
             try {
                 resultSet.close();
             } catch (SQLException e) {
                 e.printStackTrace();
             }
         }


        }
        
        return list;

    }
}
