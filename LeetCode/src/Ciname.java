public class Ciname implements Charge,Play {
    @Override
    public void charge() {
        System.out.println("30元/张，凭学生证享受半价");
    }

    @Override
    public void play() {
        System.out.println("正在放映电影");
    }

    public static void main(String args[]) {
        Bus bus = new Bus();
       bus.charge();
        Taxi taxi = new Taxi();
        taxi.charge();
        Ciname ciname = new Ciname();
        ciname.charge();
    }
}
