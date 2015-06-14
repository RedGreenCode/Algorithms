import java.util.*;

// Based on http://introcs.cs.princeton.edu/java/42sort/QuickSort.java
// For more information, see http://www.redgreencode.com/how-to-learn-an-algorithm/

// Compared to class QuickSort, class QuickSortDemo prints extra information to
// help follow the progress of the algorithm.
public class QuickSortDemo {
    public static void quicksort(int[] a) {
        quicksort(a, 0, a.length - 1);
    }
    
    private static void print(int[] a) {
    	for (int i=0; i<a.length; i++) {
    		System.out.print(a[i] + " ");
    	}
    	System.out.println();
    }

    // quicksort a[left] to a[right]
    public static void quicksort(int[] a, int left, int right) {
        print(a);
        if (right <= left) return;
        int i = partition(a, left, right);
        quicksort(a, left, i-1);
        quicksort(a, i+1, right);
    }

    // partition a[left] to a[right], assumes left < right
    private static int partition(int[] a, int left, int right) {
        int i = left - 1;
        int j = right;
        while (true) {
            while (a[++i] < a[right])           // find item on left to swap
                ;                               // a[right] acts as sentinel
            System.out.println("Found " + a[i] + " as left item to swap (or hit end)");
            while (a[right] < a[--j])           // find item on right to swap
                if (j == left) break;           // don't go out-of-bounds
            System.out.println("Found " + a[j] + " as right item to swap (or hit beginning)");
            if (i >= j) break;                  // check if pointers cross
            System.out.println("Swapping " + a[i] + " and " + a[j]);
            exch(a, i, j);                      // swap two elements into place
        		print(a);
        }
        System.out.println("Swapping " + a[i] + " and " + a[right]);
        exch(a, i, right);                      // swap with partition element
        print(a);
        System.out.println("partition = " + a[i]);
        return i;
    }

    // exchange a[i] and a[j]
    private static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    // test client
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        List<String> inputList = new ArrayList<String>();
        while (stdin.hasNextLine())
          inputList.add(stdin.nextLine());
        int[] a = new int[inputList.size()];
        for (int i=0; i<a.length; i++) a[i] = Integer.parseInt(inputList.get(i));
        quicksort(a);
        
        for (int i=0; i<a.length; i++) System.out.println(a[i]);
    }
}
