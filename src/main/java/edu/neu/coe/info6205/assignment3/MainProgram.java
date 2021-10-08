package edu.neu.coe.info6205.assignment3;

import edu.neu.coe.info6205.union_find.UF_HWQUPC;

import java.util.Random;

public class MainProgram {
    public static void main(String[] args){
        int[] testN = new int[]{1,10,50,100,200,400,800,1600,3200,6400,12800,25600,51200,1024000};
        for (int i:testN){
            System.out.print("With n = "+ i + ",the number of pairs (m) = "+ count(i)+" \n");
        }

    }
    public static int count(int n){
        int count = 0;
        Random rd = new Random();
        UF_HWQUPC uf = new UF_HWQUPC(n);
        while (!isAllConnected(uf,n)) {
            uf.connect(rd.nextInt(n), rd.nextInt(n));
            count ++;
        }
        return count;
    }
    public static boolean isAllConnected(UF_HWQUPC uf,int n){
        for (int i = 0; i < n - 1;i++){
            if (!uf.isConnected(i,i + 1)){
                return false;
            }
        }
        return true;
    }
}
