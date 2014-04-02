package com.epam.andrii_loievets.generics.fruits;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Provides methods to copy elements from one collection to another collection
 * and to get a collection of elements that are larger than the given value.
 * 
 * @author Andrii_Loievets
 * @version 3.0 2-April-2014
 */
public class CollectionUtils {
    
    /* Collection<? super E> means that out must be parametrized by type E
     * or one of its super classes to allow adding elements of type E.
    */
    public <E> void copyAll(Collection<E> collection, Collection<? super E> out) {
        if (collection == null) {
            throw new NullPointerException("Cannot copy from null source");
        }
        
        if (out == null) {
            out = new ArrayList<>();
        }
        
        for (E elem : collection) {
            out.add(elem);
        }
    }
    
    /* Comparable<? super E> means that E or one of its super classes must
     * implement Comparable.
     *
     * We write 'Collection<? extends E> collection' to be sure we can pass a
     * collection parametrized by some T (T extends E) and compare it with E.
     * For example, this allows us the following:
     *
     * getLargerThen(Collection<RedApple> collection, Apple limit) and even
     * getLargerThen(Collection<RedApple> collection, GreenApple limit)
     *
     * not only
     *
     * getLargerThen(Collection<Apple> collection, RedApple limit) or
     * getLargerThen(Collection<RedApple> collection, RedApple limit)
     * 
    */
    public <E extends Comparable<? super E>> Collection<E>
        getLargerThen(Collection<? extends E> collection, E limit) {
            
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
        Collection<RedApple> apples = new ArrayList<>();
        
        for (int i = 1; i < 11; ++i) {
            apples.add(new RedApple(i));
        }
        
        // Since Apple is Comparable<Apple> we can compare Apples and RedApples.
        Collection<RedApple> largerThenFive
                = getLargerThen(apples, new RedApple(5));
        
        for (Apple apple : largerThenFive) {
            System.out.println(apple.getWeight());
        }
    }

    public static void main(String[] args) {
       CollectionUtils fh = new CollectionUtils();
       
       fh.testCopyAll();
       fh.testLargerThen();
    }
}
