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
        Timer timer = new Timer();
        int n = 50;
        InsertionSort is = new InsertionSort();
        Function sort = new Function() {
            @Override
            public Object apply(Object o) {
                return is.sort((List)o);
            }
        };
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
                    }
                    array.add(rd.nextInt(n * 2) + n/2);
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
                for (int i = n - 1;i > 0;i--){
                    array.add(i);
                }
                return array;
            }
        };
        System.out.print(timer.repeat(100,randomArray,sort));
    }
}
