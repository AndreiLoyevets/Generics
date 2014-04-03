package com.epam.andrii_loievets.generics.test;

/**
 *
 * @author Andrii_Loievets
 */
public class Test {

    public static void main(String[] args) {
        Camera c1 = new Camera(1, 10);
        VideoCamera c2 = new VideoCamera(1, 12, 200);

        System.out.println(c1.compareTo(c2));
    }
}

class Product<T extends Product<T>> implements Comparable<T> {

    protected final int price;

    public Product(int price) {
        this.price = price;
    }

    @Override
    public int compareTo(T o) {
        return subCompare(o);
    }
    
    public int subCompare(T o) {
        return (price < o.price ? -1 : (price == o.price ? 0 : 1));
    }
}

class Camera<T extends Camera<T>> extends Product<T> {

    protected final int mpx;

    public Camera(int price, int mpx) {
        super(price);
        this.mpx = mpx;
    }

    @Override
    public int subCompare(T o) {
        int parentComp = super.subCompare(o);

        if (parentComp != 0) {
            return parentComp;
        } else {

            // compare own fields
            return (mpx < o.mpx ? -1 : (mpx == o.mpx ? 0 : 1));
        }
    }
}

class VideoCamera<T extends VideoCamera<T>> extends Camera<T> {
    protected final int recordDuration;

    public VideoCamera(int price, int mpx, int recordDuration) {
        super(price, mpx);
        this.recordDuration = recordDuration;
    }

    @Override
    public int subCompare(T o) {
        int parentComp = super.compareTo(o);

        if (parentComp != 0) {
            return parentComp;
        } else {

            // compare own fields
            return (recordDuration < o.recordDuration ? -1 : (recordDuration
                    == o.recordDuration ? 0 : 1));
        }
    }
}

class Phone extends Product<Phone> {

    protected final int display;

    public Phone(int price, int display) {
        super(price);
        this.display = display;
    }

    @Override
    public int subCompare(Phone o) {
        int parentComp = super.subCompare(o);

        if (parentComp != 0) {
            return parentComp;
        } else {

            // compare own fields
            return (display < o.display ? -1 : (display == o.display ? 0 : 1));
        }
    }
}
