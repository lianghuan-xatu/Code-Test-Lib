package Java新特性;


import java.util.Iterator;

public class MyIt implements Iterable{
    String[] strs=new String[]{"html","css","js","http","tomcat","servlet"};

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private int index=0;
            @Override
            public boolean hasNext() {
                return index<strs.length;
            }

            @Override
            public Object next() {
                return strs[index++];
            }
        };
    }
}
