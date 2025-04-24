import java.util.Arrays;

public class BasicImpofHeap {

    public static void main(String[] args) {
        //{9, 5, 6, 2, 3}
        // 5,3,17,10,84,19,6,22,9

        int[] arr= {  5,3,17,10,84,19,6,22,9
        };
        int n = arr.length;

        int[] res = new int[n];
        int size = -1;

        for(int i =0;i<n;i++)
        {
            size++;
            res[size] = arr[i];
            heapify(res, size);
        }

        System.out.println(Arrays.toString(res));

        int min_top = remove(res, size);

        System.out.println("After removal");
        System.out.println(Arrays.toString(res));
        System.out.println(min_top);
    }

    private  static int remove(int[] res , int size)
    {
        int top_min = res[0];
        res[0] = res[size];
        res[size] = Integer.MIN_VALUE;
        size--;

        for(int i =0;i<=size/2;i++)
        {
            heapify_top_down(res, i, size);
        }
        System.out.println(Arrays.toString(res));


        return top_min;
    }

    private static void heapify_top_down(int[] res, int i, int size) {

        int left_child = 2*i + 1;
        int right_child = 2*i + 2;

        if (left_child <= size && res[i] > res[left_child])
        {
            int temp = res[i];
            res[i] = res[left_child];
            res[left_child] = temp;
        }
        else if(right_child <= size && res[i] > res[right_child])
        {
            int temp = res[i];
            res[i] = res[right_child];
            res[right_child] = temp;
        }
        else{
            return;
        }

        System.out.println(Arrays.toString(res));
    }

    private static void heapify(int[] res, int size) {

        int child_index = size;
        int parent_index = (size -1 )/2;

        while (parent_index >= 0)
        {
            if(res[parent_index] > res[child_index])
            {
                int temp = res[parent_index];
                res[parent_index] = res[child_index];
                res[child_index] = temp;

                child_index = parent_index;
                parent_index = (child_index - 1)/2;

            }
            else{
                break;
            }
        }
    }
}
