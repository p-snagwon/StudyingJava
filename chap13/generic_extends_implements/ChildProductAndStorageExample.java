package chap13.generic_extends_implements;

import chap13.multitypeParameter.Tv;

public class ChildProductAndStorageExample {

    public static void main(String[] args) {

        ChildProduct<TV, String, String> product = new ChildProduct<>();
        product.setKind(new Tv());
        product.setModel("스마트모델");
        product.setCompany("삼성");


        Storage<TV> storage = new StorageImpl<>(100);
        storage.add(new TV(), 0);
        TV tv = storage.get(0);
        
    }
}
