package itcastTest;

import itcastDao.Impl.ItemsDaoImpl;
import itcastDao.ItemsDao;
import itcastDomain.Items;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ItemsTest
{
    @Test
    public void findAll(){
        ItemsDao itemsDao=new ItemsDaoImpl();
        List<Items> list = itemsDao.findAll();
        System.out.println(Arrays.toString(list.toArray()));
    }
}
