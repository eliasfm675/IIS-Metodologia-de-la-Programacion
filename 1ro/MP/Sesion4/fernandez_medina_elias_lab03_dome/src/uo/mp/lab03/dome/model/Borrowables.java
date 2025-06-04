package uo.mp.lab03.dome.model;

public interface Borrowables {
    void borrow();

    void giveBack();

    boolean isAvailable();
}
