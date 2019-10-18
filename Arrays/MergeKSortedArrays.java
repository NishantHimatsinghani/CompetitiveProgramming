package Arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedArrays {

    static class Node{
        Integer data;
        int fromArray;
        int nextEleIndex;

        Node(int data, int fromArray, int nextEleIndex){
            this.data = data;
            this.fromArray = fromArray;
            this.nextEleIndex = nextEleIndex;
        }
    }


    static void mergeKSortedArraysUsingHeap(int[][] input){

        int tot_ele = 0;
        for(int[] arr : input){
            for(int ele : arr)tot_ele++;

        }

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.data.compareTo(o2.data);
            }
        }); //Min heap

        for(int i = 0; i < input.length; i++){
            Node node = new Node(input[i][0], i, 1);
            pq.add(node);
        }
        int size = 1;
        int[] result = new int[tot_ele];

        result[0] = pq.peek().data;

        for(int i = size; i < tot_ele; i++){

            Node top = pq.remove();
            int fromArray = top.fromArray;
            int nextElement = top.nextEleIndex;
            if(nextElement >= input[fromArray].length){
                pq.add(new Node(Integer.MAX_VALUE, 0,0));
                //continue;

            }else{

                top.data = input[fromArray][top.nextEleIndex];
                top.nextEleIndex++;
                pq.add(top);

            }
            result[i] = pq.peek().data;

        }
        for(int ele : result){
            System.out.print(ele + " ");
        }

    }


    private static void mergeKSortedArraysUsingMergeSort(int[][] arr) {
        int k = arr.length;


        while(k > 1){
            int i ;
            int j;

            for(i=0, j= k-1 ; i<j; i++, j--){ //this is done for k/2 times
                arr[i] = MergeTwoSortedArrays(arr[i], arr[j]);//this one operation takes 2*n steps(n is number of elements in each array)

            }
            k= k % 2 ==0 ?k/2 : (k/2) + 1; // we need to do the above merging logk times giving the total complexity of O(n*k*logk)

        }
        System.out.println();
        for(int ele : arr[0]){
            System.out.print(ele + " ");
        }

    }

    private static int[] MergeTwoSortedArrays(int[] arr1, int[] arr2) {//Conventional Merge Sort Step to Merge two sorted arrays
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] result = new int[n1+n2];
        int i =0,j=0,k = 0;
        while(i < n1 && j < n2){
            if(arr1[i] < arr2[j]){
                result[k++] = arr1[i++];
            }else{
                result[k++] = arr2[j++];
            }


        }
        while(i < n1) result[k++] = arr1[i++];

        while(j < n2) result[k++] = arr2[j++];
        return result;

    }
    
    
     public static void main(String args[]){
        int[][] arr= {{2, 6, 12, 34},
                {1, 9, 20, 1000},
                {23, 34, 90, 2000}};

        System.out.println("Merged array is :");

        mergeKSortedArraysUsingHeap(arr);

        mergeKSortedArraysUsingMergeSort(arr);




    }


}
