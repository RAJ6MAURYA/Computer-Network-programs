import java.util.Scanner;

public class BellmanFord {
    public static final int MAX = 999;
    int D[];

    public BellmanFord(int n, int source) {
        D = new int[n + 1];
        for (int i = 0; i <= n; i++)
            D[i] = MAX;
        D[source] = 0;
    }

    public void shortest(int source, int n, int w[][]) {
        for (int k = 1; k <= n - 1; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (w[i][j] != MAX && D[j] > D[i] + w[i][j])
                        D[j] = D[i] + w[i][j];
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++)
                if (w[i][j] != MAX && D[j] > D[i] + w[i][j]) {
                    System.out.println("The Graph contain negative edge");
                    return;
                }
        }
        for (int i = 1; i <= n; i++) {
            System.out.println("the Distance from" + source + "to" + i + "is" + D[i]);
        }
    }

    public static void main(String[] args) {
        int source, n;
        int w[][];
        System.out.println("Enter the number of vertex");
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        System.out.println("Enter the source node");
        source = in.nextInt();
        System.out.println("Enter the weight Matrix");
        w = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j)
                    continue;
                System.out.print(i + "to" + j);
                w[i][j] = in.nextInt();
                if (w[i][j] == 0)
                    w[i][j] = MAX;
            }
        }
        BellmanFord b = new BellmanFord(n, source);
        b.shortest(source, n, w);
        in.close();
    }
}