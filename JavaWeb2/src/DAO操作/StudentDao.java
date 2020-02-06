package DAO操作;

import java.util.List;

//    xxxxx.Dao   Data Object Access  数据访问对象
public interface StudentDao {

    //增
       void addStudent(Student stu);


       //删
       void removeStudent(String number);
      void removeStudent(Student stu);



       //改

       void updateStudent(Student stu);

       //查
     Student getByNumber(String number);
     List<Student> getAllStudent();


}
