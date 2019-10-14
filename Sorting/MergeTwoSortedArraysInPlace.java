
/*
Space Complexity : O(1)
Time Complexity : O(n^2)
 */


public class MergeTwoSortedArraysInPlace {



    private static void MergeHelper(int[] input1, int[] input2){


        int k = input1.length - 1;

        int n = input1.length;
        int m = input2.length;


        for(int i = input2.length -1; i>=0; i--){




            int value = input1[k];
            int j;
            for(j = input1.length - 2; j >= 0 && input2[i] < input1[j]; j--){//Finding the point of insertion for input2[i] within input1 using Insertion sort

                input1[j+1] = input1[j];


            }

            if(j !=input1.length - 2 || value > input2[i]) {

                 int temp = input2[i] ;
                 input2[i] = value;
                 input1[j+1] = temp;

            }



        }


    }




    public static void main(String[] args){

        int[] input1 = {4,6,8,78, 123, 456, 2890};

        int[] input2 = {6, 8, 12, 45, 67, 89, 97, 134, 565};

        MergeHelper(input1, input2);

        printArrays(input1, input2);


    }

    private static void printArrays(int[] input1, int[] input2){

        for(int ele : input1){
            System.out.print(ele + " ");
        }
        for(int ele : input2){
            System.out.print(ele + " ");
        }


    }
}
