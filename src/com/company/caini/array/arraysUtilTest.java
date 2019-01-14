package com.company.caini.array;
import java.util.Arrays;

/**
 * Created on 2018/5/16.
 * @author Batman
 */
public class ArraysUtilTest {
    public static void main(String[] args){

        int [] a = new int[] {1,32,5,-7,89,1000};
        int [] b = Arrays.copyOfRange(a,0,3);
        for (int each:b){
            System.out.print(each + "\t");
        }
        System.out.println();
        String content = Arrays.toString(a);
        System.out.println("数组内容为:"+content);

        System.out.println("数字1出现的位置是"+Arrays.binarySearch(a, 1));

        Arrays.sort(a);
        System.out.println("排序后的数组为:"+Arrays.toString(a));

        int [] c = new int[] { 18, 62, 68, 82, 65, 9 };
        int [] d = new int[] {18, 62, 68, 82, 65, 8};
        System.out.println(Arrays.equals(c,d));

        int [] e = new int[5];
        Arrays.fill(e, 10);
        System.out.println(Arrays.toString(e));


        /**
         * 二维数组排序测试
         */
        int [][] f = new int[5][8];
        for(int i =0;i<f.length;i++){
            for (int j=0; j<f[i].length; j++){
                f[i][j] = (int)(Math.random() * 100);
            }
        }

        System.out.println("未排序前二维数组为:");
        printTwoArrays(f);

        /**
         * 把二维数组复制出来并存储至一维数组
         */
        System.out.println("二维数组展开为");
        int[] test = new int[40];
        for(int i=0; i<f.length; i++){
            System.arraycopy(f[i], 0, test, i*f[i].length, f[i].length);
        }

        System.out.println(Arrays.toString(test));

        Arrays.sort(test);
        System.out.println("排序后的二维数组展开为");
        System.out.println(Arrays.toString(test));


        System.out.println("排序后二维数组为:");
        printTwoArrays(sortTwoArrays(f));


    }

    public static int[][] sortTwoArrays(int [][] arr){

        int [] arr1 = new int [arr.length * arr[0].length];


        for(int i=0; i<arr.length; i++){
            System.arraycopy(arr[i], 0, arr1, i*arr[i].length, arr[i].length);
        }
        // 调用Arrays内置方法进行排序
        Arrays.sort(arr1);
        // 将排好序的列表写回二维数组
        int [][] arr2 = new int[arr.length][arr[0].length];
        for (int i =0; i<arr2.length; i++){
            for (int j=0; j<arr2[i].length; j++){
                arr2[i][j] = arr1[(i*arr2[i].length)+j];
            }
        }

        return arr2;

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
