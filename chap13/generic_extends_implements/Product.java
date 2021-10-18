package chap13.generic_extends_implements;

import chap13.multitypeParameter.Tv;

public class Product<T, M> {

    private T kind;
    private M model;

    public T getKind() {
        return kind;
    }

    public void setKind(Tv kind) {
        this.kind = kind;
    }

    public M getModel() {
        return model;
    }

    public void setModel(M model) {
        this.model = model;
    }
}

class TV {

}
