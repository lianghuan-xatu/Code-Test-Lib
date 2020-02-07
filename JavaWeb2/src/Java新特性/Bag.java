package Java新特性;

public class Bag<T> {
    //Bag<String> bag=new Big(String);
    private T obj;
    public T getObj(){
        return obj;
    }
    public  void setObj(T obj){
        this.obj=obj;
    }
}
