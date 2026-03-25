import java.util.*;

public class RiskLookup {

    static int linearSearch(int[] arr, int target) {
        int comps = 0;
        for (int i = 0; i < arr.length; i++) {
            comps++;
            if (arr[i] == target) {
                System.out.println("Linear Found at index " + i + " (" + comps + " comps)");
                return i;
            }
        }
        System.out.println("Linear: not found (" + comps + " comps)");
        return -1;
    }

    static int floor(int[] arr, int target) {
        int l = 0, r = arr.length - 1, ans = -1, comps = 0;

        while (l <= r) {
            int m = (l + r) / 2;
            comps++;

            if (arr[m] <= target) {
                ans = arr[m];
                l = m + 1;
            } else r = m - 1;
        }

        System.out.println("Floor(" + target + ")=" + ans + " (" + comps + " comps)");
        return ans;
    }

    static int ceil(int[] arr, int target) {
        int l = 0, r = arr.length - 1, ans = -1, comps = 0;

        while (l <= r) {
            int m = (l + r) / 2;
            comps++;

            if (arr[m] >= target) {
                ans = arr[m];
                r = m - 1;
            } else l = m + 1;
        }

        System.out.println("Ceil(" + target + ")=" + ans + " (" + comps + " comps)");
        return ans;
    }

    static int insertionPoint(int[] arr, int target) {
        int l = 0, r = arr.length;

        while (l < r) {
            int m = (l + r) / 2;
            if (arr[m] < target) l = m + 1;
            else r = m;
        }

        System.out.println("Insertion Index for " + target + " = " + l);
        return l;
    }

    public static void main(String[] args) {

        int[] arr = {10, 25, 50, 100};

        linearSearch(arr, 30);

        floor(arr, 30);
        ceil(arr, 30);

        insertionPoint(arr, 30);
    }
}