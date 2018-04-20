package sort;

public class Selection {
    //    选择排序，选择第一个数为最小的数，和后面的数对比，如果小则选为最小数，到最后选出最小数替换到第一个位置，以此类推
    public static void main(String[] args) {
        int[] a = {30, 24, 20, 38, 45, 50, 49, 27, 14, 48, 1, 29, 11, 36};
        int count = 0;

        Print print = new Print();

        Selection selection = new Selection();
//        count = selection.selectionSort(a, count);
        count = selection.selectionSort1(a, count);

        print.print(a, count);

    }

    //    count = 78
    int selectionSort(int[] a, int count) {
        for (int i = 0; i < a.length; i++) {
            int m = i;
            int temp = 0;
            for (int j = i + 1; j < a.length - 1; j++) {
                if (a[m] > a[j]) {
                    m = j;
                }
                count++;
            }
            if (i != m) {
                temp = a[i];
                a[i] = a[m];
                a[m] = temp;
            }
        }
        return count;
    }

    /*  count = 56
     * 优化：同时找最小值和最大值进行排序*/
    int selectionSort1(int[] a, int count) {
        int i, min, max, left, right;
        int temp;
        for (left = 0, right = a.length - 1; left < right; left++, right--) {
            min = left;
            max = right;
            for (i = left; i <= right; i++) {
                if (a[i] < a[min]) {
                    min = i;
                } else if (a[i] > a[max]) {
                    max = i;
                }
                count++;
            }

            if (min != left) {
                temp = a[left];
                a[left] = a[min];
                a[min] = temp;

                //如果最大值在最左边，肯定要被移走，此时要转移到相应的新位置
                if (max == left) {
                    max = min;
                }
            }

            if (max != right) {
                temp = a[right];
                a[right] = a[max];
                a[max] = temp;
            }
        }
        return count;
    }
}
