package HeapInterviewQuestion;

import java.util.*;

/*
Given an array arr[] and a positive integer k, the task is to find the k most frequently occurring elements from a given array.
Note: If more than one element has same frequency then prioritise the larger element over the smaller one.
Examples:
Input: arr= [3, 1, 4, 4, 5, 2, 6, 1], k = 2
Output: [4, 1]
Explanation: Frequency of 4 is 2 and frequency of 1 is 2, these two have the maximum frequency and 4 is larger than 1.
Input: arr = [7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9], k = 4
Output: [5, 11, 7, 10]
Explanation: Frequency of 5 is 3, frequency of 11 is 2, frequency of 7 is 2, frequency of 10 is 1. These four have the maximum frequency and 5 is largest among rest.
 */
public class TopKFrequentNumber {

    public static void main(String[] args) {
        //Input: arr= [3, 1, 4, 4, 5, 2, 6, 1], k = 2
        //Output: [4, 1]
        int[] arr = {3,1,4,4,5,2,6,1};
        int n = arr.length;
        int k =2;
       // bruteForceApproach(n, arr, k);

        priorityQueueApproach(n, arr, k);
    }

    private static void bruteForceApproach(int n, int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< n; i++)
        {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        System.out.println(map);
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, (o1, o2) -> {
            if(o1.getValue() > o2.getValue()) return -1;
            else if(o1.getValue() < o2.getValue()) return  1;
            else return o2.getKey() - o1.getKey();
        });

        System.out.println("sorted list" + list);
        int i = 0;
        ArrayList<Integer> res = new ArrayList<>();
        while(k-- > 0)
        {
            res.add(list.get(i++).getKey());
        }
        System.out.println(res);

        /*
        Aspect | Complexity
        Time Complexity | O(nlogn)
        Space Complexity | O(n)O(n)O(n)
         */

    }
    


    private static void priorityQueueApproach(int n, int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< n; i++)
        {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        System.out.println(map);
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((o1, o2) -> {
            if(o1.getValue() > o2.getValue()) return 1;
            else if(o1.getValue() < o2.getValue()) return -1;
            else return o2.getKey() - o1.getKey();
        });
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            minHeap.add(entry);
            while(minHeap.size() > k)
            {
                minHeap.poll();
            }
        }
        System.out.println(minHeap);
    }

}
