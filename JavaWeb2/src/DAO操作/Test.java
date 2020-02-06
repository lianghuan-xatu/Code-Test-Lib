package DAO操作;

import DAO操作.StudentDao;
import DAO操作.StudentDaoImpl;

public class Test {
    public static void main(String[] args){
      //  Student stu=new Student("it_cast_0001","frank",18,"male");
        StudentDao dao=new StudentDaoImpl(); //用StudentDaoImpl类实现接口再实现方法  再实例化
        //dao.addStudent(stu);
        //dao.removeStudent("it_cast_0001");
        System.out.println(dao.getByNumber("it_cast_0002"));
    }
}
