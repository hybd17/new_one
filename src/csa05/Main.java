package csa05;

public class Main {
    public static void main(String[] args) {
        int[] arr = {3,7,8,4,6,1,5,9};
        quickSort(arr,0,arr.length-1);
        print(arr);
    }
    public static void bubbleSort(int[] arr){
        for(int i =0;i<arr.length;i++)
        {
            for(int k = 0;k< arr.length-i-1;k++)
            {
                if(arr[k]>arr[k+1]){
                    swap(arr,k,k+1);
                }
            }
        }
        print(arr);
    }
    public static void insertSort(int[] arr){
        for(int i=1;i<arr.length;i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j>=0 && arr[j] > temp) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
        print(arr);
    }
    public static void quickSort(int[] arr,int left,int right){
        if(left>right)
        {
            return;
        }
        int base = arr[left];//基线值
        int i = left;
        int k = right;
        while(i<k){
            while(i<k && base<=arr[k])
            {
                k--;
            }
            while ((i<k && base>=arr[i]))
            {
                i++;
            }
            if(i<k){
                swap(arr,i,k);
            }
        }
        swap(arr,left,i);
        quickSort(arr,left,k-1);
        quickSort(arr,k+1,right);
    }
    public static void mergeSort(int[] arr){
        int mid = arr.length/2;
        int[] temp = new int[arr.length];
        int i = 0;
        int j = mid+1;
        int k = 0;
        while (i<=mid && j< arr.length)
        {
            if(arr[i] <= arr[j])
            {
                temp[k] = arr[i];
                i++;
                k++;
            }
            else {
                temp[k] = arr[j];
                j++;
                k++;
            }
        }
        while (i<=mid){
            temp[k++] = arr[i++];
        }
        while (j< arr.length){
            temp[k++] = arr[j++];
        }
        print(temp);
    }
    public static int[] heapSort(int[] arr){
        int lengthTrue = arr.length-1;
        //构建大根堆
        int end = lengthTrue/2-1;
        for(int i =end;i>=0;i--)
        {
            createHeap(arr,lengthTrue,i);
        }
        for(int i = arr.length-1;i>0;i--)
        {
            swap(arr,0,i);
            lengthTrue--;
            createHeap(arr,lengthTrue,0);
        }
        return arr;
    }
    public static void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static void print(int arr[]){
        for(int i = 0;i< arr.length;i++)
        {
            System.out.println(arr[i]);
        }
    }
    public static void createHeap(int[] arr,int lengthTrue,int m){
        int m_max = maxBelow(arr,lengthTrue,m);
        if(m_max==m){
            return;
        }
        swap(arr,m,m_max);
        createHeap(arr,lengthTrue,m_max);
    }
    public static int maxBelow(int[] arr,int lengthTrue,int m){
        int max = m;
        int left = m*2+1;
        int right = m*2+2;
        if(left<lengthTrue && arr[left] > arr[m]){
            m = left;
        }
        if (right < lengthTrue && arr[right] > arr[max]){
            max = right;
        }
        return max;
    }
}
