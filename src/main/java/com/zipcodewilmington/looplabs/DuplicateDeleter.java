package com.zipcodewilmington.looplabs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by leon on 1/25/18.
 */
public abstract class DuplicateDeleter<T> implements DuplicateDeleterInterface<T> {
    protected T[] array;

    public DuplicateDeleter() {
    }

    public DuplicateDeleter(T[] intArray) {
        this.array = intArray;
    }

    public T[] removeDuplicates(int maxNumberOfDuplications) {
        Stream<T> astream = Arrays.stream(array);
        return astream.filter(element -> getNumberOfOccurrences(element) < maxNumberOfDuplications)
                      .toArray(size -> createNewArray(size));
//        List<T> noDup = new ArrayList<T>();
//        for(int i = 0; i < array.length; i++){
//            if(getNumberOfOccurrences(array[i]) < maxNumberOfDuplications){
//                noDup.add(array[i]);
//            }
//        }
//
//        //converting list to array
//        T[] newArray = Arrays.copyOf(array, noDup.size());
//        return noDup.toArray(newArray);
    }

    private T[] createNewArray(int size) {
        return Arrays.copyOf(array, size);
    }

    public T[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        Stream<T> astream = Arrays.stream(array);
        return astream.filter(element -> getNumberOfOccurrences(element) != exactNumberOfDuplications)
                // create an array of the that size
                        .toArray(size -> Arrays.copyOf(array, size));

//
//        List<T> noDup = new ArrayList<T>();
//        for(int i = 0; i < array.length; i++){
//            if(getNumberOfOccurrences(array[i]) != exactNumberOfDuplications){
//                noDup.add(array[i]);
//            }
//        }
//
//        //converting list to array
//        T[] newArray = Arrays.copyOf(array,noDup.size());
//        return noDup.toArray(newArray);

    }

    protected Integer getNumberOfOccurrences(T valueToCount) {
        //create stream
        Stream<T> astream = Arrays.stream(array);
        //find all the element equals to value and return the count
        //valueToCount is the element you want to look at and if the element is equal to the value to count, keep it
        //once it's finished filtering, count how element was kept
        return (int)astream.filter(element -> valueToCount.equals(element)).count();

//        int count = 0;
//
//        for (int i = 0; i < array.length; i++) {
//            if(array[i].equals(numberToCount)) {
//                count++;
//            }
//        }
//        return count;
    }

}
