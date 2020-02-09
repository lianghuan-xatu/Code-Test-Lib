import org.junit.Assert;
import org.junit.Test;

public class AssertTest {


    @Test
    public void fun(){
        int result=1+1;
        //断言这个解雇偶就是3
        Assert.assertEquals(3,result);

      /*  java.lang.AssertionError:
        Expected :3
        Actual   :2
                <Click to see difference>*/
    }
}
