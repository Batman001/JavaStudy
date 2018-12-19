package com.company.caini.array;
import java.text.MessageFormat;
/**
 * Created by sunchao on 2018/5/15.
 */
public class arrayTest {
    public static void main(String[] args){
        int[] a  = new int[5];
        int num = 100;
        a[0] = (int)(Math.random() * 100);
        a[1] = (int)(Math.random() * 100);
        a[2] = (int)(Math.random() * 100);
        a[3] = (int)(Math.random() * 100);
        a[4] = (int)(Math.random() * 100);
        for (int i = 0; i<a.length; i++){
            System.out.println(MessageFormat.format("第 {0} 个元素为 {1}", i,a[i]));
            if (a[i] < num)
                num = a[i];
            System.out.println(MessageFormat.format("当前最小值为{0}", num));
        }
        System.out.println("数组中最小值为" + num);
        //selectSortint(a);
        //bubbleSort(a);
        int b[] = new int[3];
        int b1[] = arrayCopy(a,b);
        int c[] = arrayMerge(a,b1);
        for (int each:c){
            System.out.print(each + " ");
        }
        System.out.println();


        // 随机生成某个二维数组
        int d[][]  = new int[5][5];
        for (int i=0; i<d.length; i++){
            for (int j=0; j<d[i].length; j++){
                d[i][j] = (int)(Math.random() * 100);

            }
        }
        System.out.println("二维数组为");

        for(int i=0; i<d.length; i++){
            for (int j=0; j<d[i].length; j++){
                System.out.print(d[i][j] + "\t");
            }
            System.out.println();
        }

        findMaxValueOf2DArray(d);

    }
    public static void selectSort(int[] arr){
        System.out.println("排序前的数组为\n");
        for (int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();

        for(int i=0; i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if (arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("选择排序后的数组为");
        for (int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }

    /*
    比较相邻的元素。如果第一个比第二个大，就交换他们两个。
    对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
    针对所有的元素重复以上的步骤，除了最后一个。
    持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     */
    public static void bubbleSort(int[] arr){
        System.out.println("排序前的数组为");
        for (int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();

        for (int i=0;i<arr.length;i++){
            for (int j=0; j<arr.length-i-1; j++){
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println("冒泡排序后的数组为");
        for (int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        // 增强型for循环
        for (int each:arr){
            System.out.print(each + " ");
        }

    }

    /*
    System.arraycopy(src, srcPos, dest, destPos, length)
    src: 源数组
    srcPos: 从源数组复制数据的起始位置
    dest: 目标数组
    destPos: 复制到目标数组的起始位置
    length: 复制的长度
     */
    public static int[] arrayCopy(int[] a, int[] b){
        System.arraycopy(a,0,b,0,3);
        return b;

    }
    public static int[] arrayMerge(int[] a, int[] b){
        int[] c = new int[a.length+b.length];
        System.arraycopy(a,0,c,0,a.length);
        System.arraycopy(b,0,c,a.length,b.length);
        return c;

    }

    public static void findMaxValueOf2DArray(int [][] a){
        int max = a[0][0];
        int x=0;
        int y=0;
        for(int i=0;i<a.length;i++){
            for (int j=0; j<a[i].length; j++){
                if (a[i][j] > max){
                    max = a[i][j];
                    x = i;
                    y = j;
                }
            }
        }
        System.out.print("最大值是"+max+"\n");
        System.out.print("坐标是["+x+"]["+y+"]");

    }



}
