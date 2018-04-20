package sort;

public class Bubble {

    //    冒泡排序,按从小到大排列
    public static void main(String[] args) {
        int[] a = {30, 24, 20, 38, 45, 50, 49, 27, 14, 48, 1, 29, 11, 36};
        int count = 0;

        Bubble bubble = new Bubble();
//        count = Bubble.bubbleSort(a, count);
        count = bubble.bubbleSort1(a, count);
        Print print = new Print();
        print.print(a, count);
    }

    /*
     * count = 169
     * 两个数比大小，如果前面的数大，则和后面的数调换位置
     * 需要两个两个比对，且即使已经排好序也要重复比对
     * */
    int bubbleSort(int[] a, int count) {
        int m = 0;
        for (int j = 0; j < a.length - 1; j++) {
            for (int i = 0; i < a.length - 1 - j; i++) {
                if (a[i] > a[i + 1]) {
                    m = a[i + 1];
                    a[i + 1] = a[i];
                    a[i] = m;
                }
                count++;
            }
        }
        return count;
    }

    /*
     * 改进方法 count = 90
     * 设定一个flag，判断是否发生排序变化，如果没有发生变化，则跳出循环*/
    int bubbleSort1(int[] a, int count) {
        int tmp = 0;
        int flag = 0;
        for (int i = 0; i < a.length; ++i) {
            flag = 0;
            for (int j = 0; j < a.length - 1 - i; ++j) {
                if (a[j] > a[j + 1]) {
                    flag = 1;
                    tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
                count++;
            }
            if (flag == 0) {
                break;
            }
        }
        return count;
    }

}
