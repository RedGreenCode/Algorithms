import java.util.*;

// Based on http://algs4.cs.princeton.edu/11model/BinarySearch.java
public class BinarySearch {

		// Returns the index of the specified key, or
		// -1 if the key is not in the array.
		public static int indexOf(int[] a, int key) {
				int lo = 0;
				int hi = a.length - 1;
				System.out.println("Looking for " + key);
				System.out.println("------------------------------");
				while (lo <= hi) {
					// Key is in a[lo..hi] or not present.
					int mid = lo + (hi - lo) / 2;
					System.out.println(String.format("mid = %d + (%d - %d) / 2 = %d", lo, hi, lo, mid));
					System.out.println();
					print(a, lo, mid, hi, key);

					if (key < a[mid]) {
						System.out.println("key is lower than mid, so set hi to mid-1 = " + (mid-1));
						hi = mid - 1;
					} else if (key > a[mid]) {
						System.out.println("key is higher than mid, so set lo to mid+1 = " + (mid+1));
						lo = mid + 1;
					} else {
						System.out.println("key is equal to mid; found it");
						return mid;
					}
					System.out.println();
				}
				System.out.println("lo = " + lo + ", hi = " + hi);
				System.out.println("lo and hi have crossed; key isn't in the list");
				return -1;
		}

		// print current state
		public static void print(int[] a, int lo, int mid, int hi, int key) {
				for (int i=0; i<a.length; i++) {
					System.out.print(String.format("%5d", i));
				}
				System.out.println();
				for (int i=0; i<a.length; i++) {
					System.out.print(String.format("%5d", a[i]));
				}
				System.out.println();
				for (int i=0; i<a.length; i++) {
					if (i == lo) {
						System.out.print("...lo");
					} else {
						System.out.print(".....");
					}
				}
				System.out.println();
				for (int i=0; i<a.length; i++) {
					if (i == mid) {
						System.out.print("..mid");
					} else {
						System.out.print(".....");
					}
				}
				System.out.println();
				for (int i=0; i<a.length; i++) {
					if (i == hi) {
						System.out.print("...hi");
					} else {
						System.out.print(".....");
					}
				}
				System.out.println();
				for (int i=0; i<a.length; i++) {
					if (a[i] == key) {
						System.out.print("..key");
					} else {
						System.out.print(".....");
					}
				}
				System.out.println();
				System.out.println();
		}

		// test client
		public static void main(String[] args) {
				Scanner stdin = new Scanner(System.in);
				int[] a = new int[0];
				if (stdin.hasNextLine()) {
					String line = stdin.nextLine();
					String[] tokens = line.split("\\s+");
					a = new int[tokens.length];
					for (int i=0; i<tokens.length; i++)
						a[i] = Integer.parseInt(tokens[i]);
				}
				Arrays.sort(a);
				while (stdin.hasNextLine()) {
					int index = indexOf(a, Integer.parseInt(stdin.nextLine()));
					System.out.println("index: " + index);
					if (index != -1)
						System.out.println("value: " + a[index]);
					System.out.println("------------------------------");
					System.out.println();
				}
		}
}
