import java.util.ArrayList;
import java.util.Random;

/**
 * @author 刘仁楠
 * @date 2018/3/21 11:28
 */
public class Test {

    public static void main(String[] args) {

        int[] a = new int[10000000];
        for (int i = 0; i < 10000000; i++) {
            a[i] = i;
        }

        Test test = new Test();
//        System.out.println();
//        System.out.println();
//        System.out.println());

        long startTime = System.currentTimeMillis();
//        顺序查找
//        test.Sequential_Search(a, 10000000, 100000001);
//        顺序查找优化
//        test.Sequential_Search2(a, 9999999, 100000001);
//        折半查找
        test.Binary_search(a, 9999999, 100000001);
        long endTime = System.currentTimeMillis();

        System.out.println("程序运行时间:" + (endTime - startTime) + "ms");
    }

    int Sequential_Search(int[] a, int n, int key) {
        for (int i = 1; i < n; i++) {
            if (a[i] == key) {
                return i;
            }
        }
        return 0;
    }

    int Sequential_Search2(int[] a, int n, int key) {
        int i = 0;
        a[0] = key;
        i = n;
        while (a[i] != key) {
            i--;
        }
        return i;
    }

    int Binary_search(int[] a, int n, int key) {
        int low, high, mid;
        low = 1;
        high = n;
        while (low <= high) {
            mid = (low + high) / 2;
            if (a[mid] > key) {
                high = mid - 1;
            } else if (a[mid] < key) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return 0;
    }


}