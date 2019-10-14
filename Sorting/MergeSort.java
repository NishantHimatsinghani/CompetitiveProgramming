/*
        Average Worst Case : O(nLogn)
        Worst Case : O(nLogn)
        */

public class MergeSort {


    public static void main(String[] args){

        int[] input = {87,67,9,87,123,45,678,654, 123, 768};
        int n = input.length;
        System.out.println("n = " + n);
        MergeSortArray(input, 0, n-1);

        printArray(input);


    }

    private static void printArray(int[] input){

        for(int ele : input){
            System.out.print(ele + " ");

        }

    }


    private static void MergeSortArray(int[] input, int l, int r) {
        if(l==r) return;
        System.out.println( "l = " + l + " r = " + r);
        if(l < r){
            int m = (l+r)/2;
            System.out.println("m = " + m);
            MergeSortArray(input, l, m);
            MergeSortArray(input, m+1, r);

            MergeArray(input, l, m, r);

        }


    }

    private static void MergeArray(int[] input, int l, int m, int r) {

        int n1 = m-l+1;
        int n2 = r-m;

        int[] L = new int[n1];
        int[] R = new int[n2];
        int j = 0;
        for(int i = l; i <= m; i++){
            L[j] = input[i];
            j++;
        }
        j=0;
        for(int i = m+1; i <= r; i++){
            R[j] = input[i];
            j++;
        }

        int i =0;
        int k = l;
        j=0;

        while(i < n1 && j < n2){
            if(L[i] < R[j]){
                input[k++] = L[i++];
            }
            else input[k++] = R[j++];
        }
        while(i<n1){
            input[k++] = L[i++];
        }

        while(j < n2){
            input[k++] = R[j++];
        }
    }
}
