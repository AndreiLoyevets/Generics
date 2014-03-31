package com.epam.andrii_loievets.generics.fruits;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Provides methods to copy elements from one collection to another collection
 * and to get a collection of elements that are larger than the given value.
 * 
 * @author Andrii_Loievets
 * @version 1.0 31-March-2014
 */
public class CollectionUtils {
    public <F, G> void copyAll(Collection<F> collection, Collection<G> out) {
        if (collection == null) {
            throw new NullPointerException("Cannot copy from null source");
        }
        
        if (out == null) {
            out = new ArrayList<>();
        }
        
        for (F elem : collection) {
            out.add((G) elem);
        }
    }
    
    public <E extends Comparable> Collection<E>
        getLargerThen(Collection<E> collection, E limit) {
            
        Collection<E> result = new ArrayList<>();
        
        for (E elem : collection) {
            if (elem.compareTo(limit) > 0) {
                result.add(elem);
            }
        }
        
        return result;
    }
    
    public void testCopyAll() {
        List<Fruit> fr = null;
        List<Apple> app = null;
        List<Orange> or = null;
        List<RedApple> rapp = null;
        List<Melon> mel = null;
        copyAll(or, fr);
        copyAll(rapp, fr);
        copyAll(rapp, app);
        copyAll(rapp, rapp);
//copyAll(fr, or);
    }
    
    public void testLargerThen() {
        Collection<Apple> apples = new ArrayList<>();
        
        for (int i = 1; i < 11; ++i) {
            apples.add(new Apple(i));
        }
        
        Collection<Apple> greaterThenFive = getLargerThen(apples, new Apple(5));
        
        for (Apple apple : greaterThenFive) {
            System.out.println(apple.getWeight());
        }
    }

    public static void main(String[] args) {
       CollectionUtils fh = new CollectionUtils();
       
       fh.testCopyAll();
       fh.testLargerThen();
    }
}
