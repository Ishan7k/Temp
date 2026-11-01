import java.util.*;

class Item {
    int w, v;                                   // weight, value
    double r;                                   // ratio = value / weight

    Item(int w, int v) {
        this.w = w;
        this.v = v;
        r = (double) v / w;
    }
}

public class DAA2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        Item[] a = new Item[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight and value of item " + (i + 1) + ": ");
            int w = sc.nextInt();
            int v = sc.nextInt();
            a[i] = new Item(w, v);              // item banao
        }

        System.out.print("Enter knapsack capacity: ");
        int cap = sc.nextInt();

        // Step 1: ratio ke hisaab se descending sort (bada pehle)
        Arrays.sort(a, (x, y) -> Double.compare(y.r, x.r));

        // Step 2: greedy selection
        double total = 0;

        for (Item it : a) {

            if (it.w <= cap) {                  // poora item aa jayega
                cap   -= it.w;                  // jagah kam...bachi hui 
                total += it.v;                  // poori value add... paisa mila
            }
            else {                              // poora nahi aayega
                total += it.r * cap;            // bacha hua hissa le lo... per kg paisa* bachi jigah
                break;                          // bag full, stop
            }
        }

        System.out.println("Maximum value = " + total);
        sc.close();
    }
}