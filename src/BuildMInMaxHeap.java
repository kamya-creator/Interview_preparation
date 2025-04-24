import java.util.Arrays;

public class BuildMInMaxHeap {

    public static void main(String[] args) {
        //5,3,17,10,84,19,6,22,9
        //10,9,8,7,6,5,4,3,2,1
        int[] arr= {10,9,8,7,6,5,4,3,2,1 };
        int n = arr.length;
        int[] res = new int[n];
        int size =-1;

        // Building MIN HEAP
        for (int j : arr) {
            size++;
            res[size] = j;
            /*
            arrays in Java are passed by reference (technically, reference value).
             So when you pass res into buildMinHeap(res, size), you're actually passing a
             reference to the same array in memory, not a copy.
             Inside the method, a[] is just another name for the same array as res
             */
            buildMinHeap(res, size);
        }

        System.out.println("MIN HEAP---------"+Arrays.toString(res));

        // Building MAX HEAP
        size=-1;
        res=new int[n];
        for(int j : arr)
        {
            size++;
            res[size] = j;
            buildMaxHeap(res, size);
        }
        System.out.println("MAX HEAP------" + Arrays.toString(res));

    }

    public static void buildMaxHeap(int[] res, int i) {

        int parent_index = (i-1)/2;
        while(parent_index>=0 && res[parent_index] < res[i])
        {
            int temp = res[i];
            res[i] = res[parent_index];
            res[parent_index]= temp;

            i = parent_index;
            parent_index = (i-1)/2;
        }
    }

    public static void buildMinHeap(int[] a, int i) {

        int parent_index = (i-1)/2;

        while(parent_index>=0 && a[i] < a[parent_index])
        {
            int temp = a[i];
            a[i] = a[parent_index];
            a[parent_index] = temp;

            i = parent_index;
            parent_index = (i-1)/2;
        }
    }
}
