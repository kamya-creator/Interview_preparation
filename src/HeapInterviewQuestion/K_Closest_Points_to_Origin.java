package HeapInterviewQuestion;

import java.util.*;

/*
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).
The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).

 */
public class K_Closest_Points_to_Origin {
    public static void main(String[] args) {
        // [[3,3],[5,-1],[-2,4]], k = 2
        // {{1,3},{-2,2}};
        int[][] points = {{3,3}, {5,-1},{-2,4}};
        int k = 2;
        int n = points.length;
        HashMap<Integer, Integer> disMap = new HashMap<>();
        for(int i =0;i<n;i++)
        {
            int a = points[i][0];
            int b = points[i][1];
            int diff = a*a + b*b;
            disMap.put(i,diff );
        }
        bruteForceApproach(points, n, k, disMap);
        optimalApproach(points, n, k, disMap);
    }


    public static void bruteForceApproach(int[][] arr, int n, int k,
                                          HashMap<Integer, Integer> map) {

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((o1, o2)->{
            if (o1.getValue() > o2.getValue()) return 1;
            else if(o1.getValue() < o2.getValue()) return  -1;
            else return o1.getKey() - o2.getKey();
        });
        // here we sorted everything in PQ, which sort everything in nlogn time , we can do better than this
        maxHeap.addAll(map.entrySet());
        int[][] res = new int[k][];
        int index = 0;
        while (k-- > 0)
        {
            res[index++] = arr[maxHeap.poll().getKey()];
        }
        for(int[] i : res)
            System.out.println(Arrays.toString(i));
    }

    private static void optimalApproach(int[][] points, int n, int k, HashMap<Integer, Integer> disMap) {

        System.out.println(disMap);
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((o1, o2)->{
            if (o1.getValue() > o2.getValue()) return 1;
            else if(o1.getValue() < o2.getValue()) return  -1;
            else return o1.getKey() - o2.getKey();
        });

        for(Map.Entry<Integer, Integer> entry : disMap.entrySet())
        {
            maxHeap.add(entry);
            System.out.println("krishna---------");
            System.out.println(maxHeap);
            while ((maxHeap.size() > k))
            {
                maxHeap.poll();
            }
        }

        ArrayList<int[]> res = new ArrayList<>();
        while (!maxHeap.isEmpty())
        {
            res.add(points[maxHeap.poll().getKey()]);
        }
        System.out.println("Optimal Sol-------------");
        for(int[] i : res)
            System.out.println(Arrays.toString(i));
    }

}
