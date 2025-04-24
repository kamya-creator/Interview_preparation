import java.util.Arrays;

public class ExtractMaxFromMax_Heap {
    public static void main(String[] args) {
        //5,3,17,10,84,19,6,22,9
        //10,9,8,7,6,5,4,3,2,1
        //1,2,3,4,5,6,7,8,9,10
        int[] arr= {1,2,3,4,5,6,7,8,9,10};
        int n = arr.length;
        int[] res = new int[n];
        int size =-1;

        // Building MIN HEAP
        for (int j : arr) {
            size++;
            res[size] = j;
            BuildMInMaxHeap.buildMaxHeap(res, size);
        }

        System.out.println("MAN HEAP---------"+ Arrays.toString(res));

        // Get min i.e. top of heap and re-heapify rest heap
        int max = extractMax(res,size);

        System.out.println("Max of Heap--" + max);
        size--;
        for(int i =0;i<=size;i++)
            System.out.print(res[i] +" ");
    }

    private static int extractMax(int[] res, int size) {
        int max = res[0];

        res[0] = res[size];
        size--;
        maxHeapify(res,0,size);
        return max;
    }

    private static void maxHeapify(int[] res,int i, int size) {

        int left_child = 2*i + 1;
        int right_child = 2*i + 2;
        int largest = i;
        if (left_child <= size && res[left_child] > res[i])
        {
            largest = left_child;
        }
        if(right_child <= size && res[right_child] > res[largest])
        {
            largest = right_child;
        }

        if(largest != i)
        {
            int temp = res[i];
            res[i] = res[largest];
            res[largest] = temp;

            maxHeapify(res,largest, size);
        }
    }
}
