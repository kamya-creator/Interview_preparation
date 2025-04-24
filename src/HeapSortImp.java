import java.util.Arrays;

public class HeapSortImp {
    public static void main(String[] args) {

        int[] arr = {5, 3, 17, 10, 84, 19, 6, 22, 9};
        int n = arr.length;

        int[] res = new int[n];
        int size = -1;

        for (int i = 0; i < n; i++) {
            size++;
            res[size] = arr[i];
            buildMinHeap(res,size);
        }
        System.out.println("MIN HEAP---------"+ Arrays.toString(res));
        int[] sorted = new int[n];
        int index = 0;

        for(int i =0;i<n;i++)
        {
            sorted[index++] = extractMin(res,size);
            size--;
        }
        System.out.println("Sorted in Ascending Order");
        System.out.println(Arrays.toString(sorted));


        size = -1;
        res = new int[n];

        for(int j: arr)
        {
            size++;
            res[size] = j;
            buildMaxHeap(res,size);
        }
        System.out.println("Max Heap------" + Arrays.toString(res));

        sorted = new int[n];
        index = 0;
        for(int i =0;i<n;i++)
        {
            sorted[index++] = extractMax(res,size);
            size--;
        }

        System.out.println("Descending order------");
        System.out.println(Arrays.toString(sorted));

    }

    private static int extractMax(int[] res, int size) {

        int max = res[0];
        res[0] = res[size];
        size--;
        maxHeapify(res, 0 ,size);
        return  max;
    }

    private static void maxHeapify(int[] res, int i, int size) {

        int left_child = 2*i +1;
        int right_child = 2*i +2;
        int largest = i ;

        if(left_child <= size && res[left_child] > res[i])
        {
            largest = left_child;
        }
        if(right_child<=size && res[largest] < res[right_child])
        {
            largest = right_child;
        }

        if(largest != i)
        {
            int temp = res[i];
            res[i] = res[largest];
            res[largest] = temp;

            maxHeapify(res,largest,size);
        }

    }

    private static void buildMaxHeap(int[] res, int i) {

        int parent_index = (i-1)/2;
        while (parent_index >= 0 && res[i] > res[parent_index])
        {
            int temp = res[i];
            res[i] = res[parent_index];
            res[parent_index] = temp;

            i = parent_index;
            parent_index = (i-1)/2;
        }
    }

    private static int extractMin(int[] res, int size) {
        int min = res[0];
        res[0] = res[size];
        size--;
        minHeapify(res, 0 , size);
        return  min;
    }

    private static void minHeapify(int[] res, int i, int size) {

        int left_child = 2*i + 1;
        int right_child = 2*i +2;
        int smallest = i;

        if(left_child <= size && res[i] > res[left_child])
        {
            smallest = left_child;
        }
        if(right_child <= size && res[smallest] > res[right_child])
        {
            smallest = right_child;
        }

        if(smallest != i)
        {
            int temp = res[i];
            res[i] = res[smallest];
            res[smallest] = temp;

            minHeapify(res, smallest, size);
        }
    }

    private static void buildMinHeap(int[] res, int i) {

        int parent_index = (i-1)/2;
        while(parent_index >= 0 && res[i] < res[parent_index])
        {
            int temp = res[i];
            res[i] = res[parent_index];
            res[parent_index] = temp;

            i = parent_index;
            parent_index = (i-1)/2;
        }
    }
}
