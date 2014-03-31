package com.epam.andrii_loievets.generics.fruits;

/**
 * Hierarchy of fruits.
 * 
 * @author Andrii_Loievets
 * @version 1.0 31-March-2014
 */
public class Fruit {
}

class Apple extends Fruit implements Comparable<Apple> {
    private final int weight;
    
    Apple(int weight) {
        this.weight = weight;
    }
    
    int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Apple o) {
        return (weight < o.weight ? -1 : (weight == o.weight ? 0 : 1));
    }
}

class RedApple extends Apple {

    public RedApple(int weight) {
        super(weight);
    }
}

class Orange extends Fruit {}

class Melon {}
