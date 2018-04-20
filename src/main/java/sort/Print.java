package sort;

public class Print {
    void print(int[] a, int count) {
        for (int i = 0; i < a.length; i++) {
            System.out.printf(a[i] + " ");
        }
        System.out.printf("count = " + count);
    }
}
