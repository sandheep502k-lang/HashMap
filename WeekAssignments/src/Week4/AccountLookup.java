import java.util.*;

public class AccountLookup {

    static int linearFirst(String[] arr, String target) {
        int comps = 0;
        for (int i = 0; i < arr.length; i++) {
            comps++;
            if (arr[i].equals(target)) {
                System.out.println("Linear First Index: " + i + " (comparisons=" + comps + ")");
                return i;
            }
        }
        return -1;
    }

    static int linearLast(String[] arr, String target) {
        int comps = 0, res = -1;
        for (int i = 0; i < arr.length; i++) {
            comps++;
            if (arr[i].equals(target)) res = i;
        }
        System.out.println("Linear Last Index: " + res + " (comparisons=" + comps + ")");
        return res;
    }

    static int binarySearch(String[] arr, String target) {
        int l = 0, r = arr.length - 1, comps = 0;

        while (l <= r) {
            int m = (l + r) / 2;
            comps++;

            if (arr[m].equals(target)) {
                System.out.println("Binary Found at: " + m + " (comparisons=" + comps + ")");
                return m;
            } else if (arr[m].compareTo(target) < 0)
                l = m + 1;
            else
                r = m - 1;
        }

        return -1;
    }

    static int countOccurrences(String[] arr, String target) {
        int count = 0;
        for (String s : arr)
            if (s.equals(target)) count++;
        System.out.println("Count: " + count);
        return count;
    }

    public static void main(String[] args) {

        String[] logs = {"accB", "accA", "accB", "accC"};

        linearFirst(logs, "accB");
        linearLast(logs, "accB");

        Arrays.sort(logs); // required for binary search

        System.out.println("Sorted: " + Arrays.toString(logs));

        binarySearch(logs, "accB");
        countOccurrences(logs, "accB");
    }
}