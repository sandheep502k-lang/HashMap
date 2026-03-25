package Week2;

import java.util.*;

class TwoSum {

    public static int[] find(int[] arr, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int c = target - arr[i];
            if(map.containsKey(c))
                return new int[]{map.get(c), i};
            map.put(arr[i], i);
        }
        return new int[]{-1,-1};
    }
}