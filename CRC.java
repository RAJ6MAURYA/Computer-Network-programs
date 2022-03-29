import java.util.Scanner;

public class CRC {
    public void div(int a[], int k) {
        int count = 0;
        int gp[] = { 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0 };
        for (int i = 0; i < k; i++) {
            if (a[i] == gp[0]) {
                for (int j = i; j < 17 + i; j++)
                    a[j] = a[j] ^ gp[count++];
            }
            count = 0;
        }
    }

    public static void main(String[] args) {
        int a[] = new int[100];
        int b[] = new int[100];
        int len, k;
        System.out.println("Enter the length of the data frame");
        Scanner in = new Scanner(System.in);
        len = in.nextInt();
        System.out.println("Enter the data");
        for (int i = 0; i < len; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < 16; i++)
            a[len++] = 0;
        for (int i = 0; i < len; i++)
            b[i] = a[i];
        k = len - 16;
        CRC ob = new CRC();
        ob.div(a, k);
        for (int i = 0; i < len; i++)
            a[i] = a[i] ^ b[i];
        System.out.println("The transmitted data is");
        for (int i = 0; i < len; i++)
            System.out.print(a[i]);
        System.out.println("Enter the recieved data");
        for (int i = 0; i < len; i++)
            a[i] = in.nextInt();
        ob.div(a, k);
        for (int i = 0; i < len; i++) {
            if (a[i] != 0) {
                System.out.println("ERROR");
                return;
            }
        }
        System.out.println("NO ERROR");
    }
}