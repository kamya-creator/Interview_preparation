import java.util.Arrays;

public class ExtractMinFromMIN_Heap {

    public static void main(String[] args) {
        //5,3,17,10,84,19,6,22,9
        //10,9,8,7,6,5,4,3,2,1
        //1,2,3,4,5,6,7,8,9,10
        int[] arr= {10,9,8,7,6,5,4,3,2,1 };
        int n = arr.length;
        int[] res = new int[n];
        int size =-1;

        // Building MIN HEAP
        for (int j : arr) {
            size++;
            res[size] = j;
            BuildMInMaxHeap.buildMinHeap(res, size);
        }

        System.out.println("MIN HEAP---------"+ Arrays.toString(res));

        // Get min i.e. top of heap and re-heapify rest heap
        int min = extractMin(res,size);

        System.out.println("Min of Heap--" + min);
        size--;
        for(int i =0;i<=size;i++)
         System.out.print(res[i] +" ");

    }

    private static int extractMin(int[] res, int size) {

        int min = res[0];
        res[0] = res[size];
        size--;
        System.out.println("Before minHeapifying --- Krishna");
        for(int i =0;i<=size;i++)
            System.out.print(res[i] +" ");

        System.out.println("After minHeapifying --- Krishna");
        minHeapify(res,0, size);
        return min;
    }

    private static void minHeapify(int[] res, int i , int size) {

        int left_child = 2*i +1;
        int right_child = 2*i +2;
        int smallest = i;

        if(left_child <= size && res[i] > res[left_child])
        {
            smallest = left_child;
        }

        if(right_child <= size && res[right_child] < res[smallest])
        {
            smallest = right_child;
        }

        if(smallest != i)
        {
            int temp = res[i];
            res[i] = res[smallest];
            res[smallest] = temp;
            //System.out.println("I m smallest " + smallest);
            minHeapify(res, smallest, size);

        }

    }
}
