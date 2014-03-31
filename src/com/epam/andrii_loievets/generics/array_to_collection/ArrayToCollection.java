package com.epam.andrii_loievets.generics.array_to_collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * This class allows to copy elements from array to collection of the same type.
 * 
 * @author Andrii_Loievets
 * @version 1.0 31-March-2014
 * @param <E>
 */
public class ArrayToCollection<E> {
    public void fromArrayToCollection(E [] a, Collection<E> c) {
        c.addAll(Arrays.asList(a));
    }
    
    public static void main(String [] args) {
        ArrayToCollection<Integer> converter = new ArrayToCollection<>();
        
        Integer [] array = {1, 2, 3, 4};
        Collection<Integer> collection = new ArrayList<>();
        
        converter.fromArrayToCollection(array, collection);
        
        System.out.println(collection);
    }
}
