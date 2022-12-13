import java.util.*;

public class BF {
    int dist[], n;
    public static final int max = 999;

    public BF(int n) {
        this.n = n;
        dist = new int[n + 1];
    }

    void shortest(int s, int a[][]) {
        for (int i = 1; i <= n; i++)
            dist[i] = max;
        dist[s] = 0;
        for (int k = 1; k <= n - 1; k++)
            for (int i = 1; i <= n; i++)
                for (int j = 1; j <= n; j++)
                    if (a[i][j] != max)
                        if (dist[j] > dist[i] + a[i][j])
                            dist[j] = dist[i] + a[i][j];

        for (int i = 1; i <= n; i++)
            System.out.println("Distance from source " + s + " to " + i + " is " + dist[i]);
    }

    public static void main(String args[]) {
        int s, n = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices :");
        n = sc.nextInt();
        int a[][] = new int[n + 1][n + 1];
        System.out.println("Enter the adjacency matrix :");
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= n; j++) {
                a[i][j] = sc.nextInt();
                if (i == j)
                    a[i][j] = 0;
            }

        BF obj = new BF(n);
        System.out.println("Enter the source vertex :");
        s = sc.nextInt();

        System.out.println("\n1.No line break\n2.Line Break exists");
        int ch;
        ch = sc.nextInt();
        if (ch == 1)
            obj.shortest(s, a);
        else if (ch == 2) {
            System.out.println("Enter the nodes where line break exists :");
            int x, y;
            x = sc.nextInt();
            y = sc.nextInt();
            a[x][y] = max;
            a[y][x] = max;
            obj.shortest(s, a);
        }
        sc.close();
    }
}
