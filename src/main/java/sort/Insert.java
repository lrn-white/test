package sort;

public class Insert {
    public static void main(String[] args) {
        int[] a = {30, 24, 20, 38, 45, 50, 49, 27, 14, 48, 1, 29, 11, 36};
        int count = 0;

        Insert insert = new Insert();
        count = insert.insertSort(a, count);

        Print print = new Print();
        print.print(a, count);
    }

        /*
        * count = 51
        * 插入排序，后一个数与前面的数做大小比较，如果小就前移*/
    int insertSort(int[] a, int count) {
        int i, j, tmp;
        for (i = 1; i < a.length; i++) {
            tmp = a[i];
            for (j = i - 1; j >= 0 && a[j] > tmp; j--) {
                a[j + 1] = a[j];
                count++;
            }
            a[j + 1] = tmp;
        }
        return count;
    }
}


