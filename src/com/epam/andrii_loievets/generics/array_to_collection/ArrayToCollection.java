package com.epam.andrii_loievets.generics.array_to_collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * This class allows to copy elements from array to collection of the same type.
 * 
 * @author Andrii_Loievets
 * @version 2.0 2-April-2014
 */
public class ArrayToCollection {
    public <E> void fromArrayToCollection(E [] a, Collection<E> c) {
        for (E elem : a) {
            c.add(elem);
        }
    }
    
    public static void main(String [] args) {
        ArrayToCollection converter = new ArrayToCollection();
        
        Integer [] array = {1, 2, 3, 4};
        Collection<Integer> collection = new ArrayList<>();
        
        converter.fromArrayToCollection(array, collection);
        
        System.out.println(collection);
    }
}
