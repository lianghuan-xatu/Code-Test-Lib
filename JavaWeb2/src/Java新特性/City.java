package Java新特性;

public class City {
    private City(){
        //构造函数
    }
    private static City beijing=new City("北京市"){
        @Override
        public void show() {
          System.out.println("冯伟");
        }
    };
    private  static City wuhan=new City("武汉市"){
        @Override
        public void show() {
            System.out.println("马克");
        }
    };
    private static City zhengzhou=new City("郑州市"){
        @Override
        public void show() {
            System.out.println("弗兰克");
        }
    };
    private String address;
private  City(String address){
    this.address=address;
}
private String getAddress(){
    return address;
}
public void show(){

}

}
