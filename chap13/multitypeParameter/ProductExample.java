package chap13.multitypeParameter;

public class ProductExample {

    public static void main(String[] args) {

        Product<Tv, String> product1 = new Product<>();
        product1.setT(new Tv());
        product1.setM("스마트TV");
        Tv t = product1.getT();
        String tvModel = product1.getM();


        Product<Car, String> product2 = new Product<>();
        product2.setT(new Car());
        product2.setM("그랜져");
        Car car = product2.getT();
        String carModel = product2.getM();

    }
}
