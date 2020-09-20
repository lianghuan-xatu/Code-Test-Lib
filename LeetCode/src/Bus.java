public class Bus implements Charge {
    @Override
    public void charge() {
        System.out.println("公共汽车：1元/张，不计公里数");
    }
}
