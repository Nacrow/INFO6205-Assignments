package edu.neu.coe.info6205.assignment2;

import edu.neu.coe.info6205.sort.elementary.InsertionSort;
import edu.neu.coe.info6205.util.Timer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;

public class MainProgram {
    public static void main (String[] args){
        // int n = 1250;
        // int n = 2500;
        // int n = 5000;
        // int n = 10000;
        // int n = 20000;
         int n = 40000;
        // int n = 80000;
        Supplier randomArray = new Supplier() {
            @Override
            public Object get() {
                List<Integer> array = new ArrayList<>();
                Random rd = new Random();
                for (int i = 0;i < n;i++){
                    array.add(rd.nextInt(n * 2));
                }
                return array;
            }
        };
        Supplier partlyOrdered = new Supplier() {
            @Override
            public Object get() {
                List<Integer> array = new ArrayList<>();
                Random rd = new Random();
                for (int i = 0;i < n;i++){
                    if (i < n/2){
                        array.add(i);
                    } else {
                        array.add(rd.nextInt(n * 2) + n/2);
                    }
                }
                return array;
            }
        };
        Supplier orderedArray = new Supplier() {
            @Override
            public Object get() {
                List<Integer> array = new ArrayList<>();
                for (int i = 0;i < n;i++){
                    array.add(i);
                }
                return array;
            }
        };
        Supplier reversedArray = new Supplier() {
            @Override
            public Object get() {
                List<Integer> array = new ArrayList<>();
                for (int i = n - 1;i >= 0;i--){
                    array.add(i);
                }
                return array;
            }
        };
        System.out.print("Run insertion sort on a random Array with n = " + n +" :" + new Timer().repeat(100, randomArray, new Function() {
            @Override
            public Object apply(Object o) {
                return new InsertionSort().sort((List)o);
            }
        })+"\n");
        System.out.print("Run insertion sort on a ordered Array with n = " + n +" :" + new Timer().repeat(100, orderedArray, new Function<Object, Object>() {
            @Override
            public Object apply(Object o) {
                return new InsertionSort().sort((List)o);
            }
        })+"\n");
        System.out.print("Run insertion sort on a partly-ordered Array with n = " + n +" :" + new Timer().repeat(100,partlyOrdered,new Function<Object, Object>() {
            @Override
            public Object apply(Object o) {
                return new InsertionSort().sort((List)o);
            }
        })+"\n");
        System.out.print("Run insertion sort on a reversed Array with n = " + n +" :" + new Timer().repeat(100,reversedArray,new Function<Object, Object>() {
            @Override
            public Object apply(Object o) {
                return new InsertionSort().sort((List)o);
            }
        })+"\n");
    }
}
