package sort;

import java.util.Arrays;

/**
 * 快速排序
 * http://blog.csdn.net/vayne_xiao/article/details/53508973
 * @author 刘仁楠
 * @date 2018/3/14 14:15
 */
public class Quick {

    public static void main(String[] args) {
        int[] a = {30, 24, 20, 38, 45, 50, 49, 27, 14, 48, 1, 29, 11, 36};
        int count = 0;

        sort(a, 0, a.length-1);

        System.out.println("排序结果：" + Arrays.toString(a));

//        Print print = new Print();
//        print.print(a, count);
    }

    public static int partition(int []array,int lo,int hi){
        //固定的切分方式
        int key=array[lo];
        while(lo<hi){
            while(array[hi]>=key&&hi>lo){//从后半部分向前扫描
                hi--;
            }
            array[lo]=array[hi];
            while(array[lo]<=key&&hi>lo){//从前半部分向后扫描
                lo++;
            }
            array[hi]=array[lo];
        }
        array[hi]=key;
        return hi;
    }

    public static void sort(int[] array,int lo ,int hi){
        if(lo>=hi){
            return ;
        }
        int index=partition(array,lo,hi);
        sort(array,lo,index-1);
        sort(array,index+1,hi);
    }
}
