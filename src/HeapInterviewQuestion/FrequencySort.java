package HeapInterviewQuestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;

public class FrequencySort {
    public static void main(String[] args) {
            // Function to sort the array according to frequency of elements.
        int[] arr = {3,1,4,4,5,2,6,1};
        int n = arr.length;
        int k =2;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int j : arr) {
            map.put(j, map.getOrDefault(j, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
                new PriorityQueue<>((o1, o2) -> {
                    if(o1.getValue() > o2.getValue()) return -1;
                    else if(o1.getValue() < o2.getValue()) return 1;
                    else return o1.getKey() - o2.getKey();
                });
        maxHeap.addAll(map.entrySet());

        //System.out.println(minHeap);
        ArrayList<Integer> res = new ArrayList<>();
        while(!maxHeap.isEmpty())
        {
            int freq = maxHeap.peek().getValue();
            int ele = maxHeap.peek().getKey();
            maxHeap.poll();
            while(freq-- > 0)
                res.add(ele);
        }
        System.out.println(res);
        }


}
