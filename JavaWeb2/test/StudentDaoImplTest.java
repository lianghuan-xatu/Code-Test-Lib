import DAO操作.Student;
import DAO操作.StudentDao;
import DAO操作.StudentDaoImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StudentDaoImplTest {
    //初始化方法   用于资源申请，所有测试方法在执行之前都会先执行该方法
    @Before
    public void init(){
        System.out.println("初始化开始");
    }
    @Test
    public void testaddStudent(){
        StudentDao dao=new StudentDaoImpl();
        Student stu=new Student("it_cast_0001","jack",18,"male");
        dao.addStudent(stu);

    }
    
    //释放资源方法，在测试方法执行完后，都会自动执行该方法
    @After
    public void close(){
        System.out.println("结束");
    }

}
