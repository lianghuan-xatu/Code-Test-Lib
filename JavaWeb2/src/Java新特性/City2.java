package Java新特性;

public enum City2 {
    beijing("北京"){
        @Override
        public void show() {
            System.out.println("jack");
        }
    },wuhan("武汉") {
        @Override
        public void show() {
            System.out.println("frank");
        }
    },zhengzhou("郑州") {
        @Override
        public void show() {
            System.out.println("tom");
        }
    };
  //反编译后相同
    private String address;
    private City2(String address){
        this.address=address;
    }

    public String getAddress(){
        return address;
    }
    public abstract void show();


}
