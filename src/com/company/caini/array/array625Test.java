package com.company.caini.array;
import java.util.Arrays;

/**
 * Created on 2018/6/25.
 * @author Batman
 */
public class Array625Test {
    public static void main(String[] args){
        int [][] f = new int[5][8];
        for(int i =0;i<f.length;i++){
            for (int j=0; j<f[i].length; j++){
                f[i][j] = (int)(Math.random() * 100);
            }
        }
        int [][] sortedTwoArrays = twoArraysSort(f);
        printTwoArrays(sortedTwoArrays);

    }

    public static int[][] twoArraysSort(int[][] arr){
        System.out.println("未排序的二维数组为:");
        printTwoArrays(arr);
        //将二维数组复制出来 构成一维数组后进行排序
        System.out.println("二维数组展开成一维数组为");
        int [] onearray = new int [arr.length * arr[0].length];
        for (int i=0;i<arr.length;i++){
            System.arraycopy(arr[i],0,onearray,i*arr[i].length,arr[i].length);
        }
        System.out.println(Arrays.toString(onearray));

        Arrays.sort(onearray);
        System.out.println("排序后的二维数组展开为");
        System.out.println(Arrays.toString(onearray));

        System.out.println("排序后二维数组为:");
        //将排好序的一维数组再重新写成二维数组样式
        int [][] sortedTwoArrays = new int[arr.length][arr[0].length];
        for(int i=0;i<arr.length;i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sortedTwoArrays[i][j] = onearray[i * sortedTwoArrays[i].length + j];
            }
        }
        return sortedTwoArrays;
    }


    /**
     * 打印二维数组方法
     */
    public static void printTwoArrays(int [][] arr){
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr[i].length; j++){
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }


}
