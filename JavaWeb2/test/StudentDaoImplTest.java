import DAO操作.Student;
import DAO操作.StudentDao;
import DAO操作.StudentDaoImpl;
import org.junit.Test;

public class StudentDaoImplTest {
    @Test
    public void testaddStudent(){
        StudentDao dao=new StudentDaoImpl();
        Student stu=new Student("it_cast_0001","jack",18,"male");
        dao.addStudent(stu);     }
}
