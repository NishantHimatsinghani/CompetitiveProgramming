package Arrays;

public class AlternativeSortingNoExtraSpace {

    public static void main(String[] args){
        int[] input = {1,4,6,15,20};

        AltSort(input);
        printArray(input);
    }

    private static void printArray(int[] input) {
        for(int ele : input){
            System.out.print(ele + " ");
        }

    }

    private static void AltSort(int[] input) {
        /*
        args: input is already sorted array. Need to convert the array into below format:
              1st Max, 1st Min, 2nd Max, 2nd Min, ... and so on without extra space

       -- we know that the max element in the array is last element of input array i.e. input[n-1]
          So, max_ele is the element greater than this element i.e.
          max_ele = 1 + input[n-1]


        arr[i] = arr[i] + (arr[max_index]) * max_element  //or arr[min_index]

        Now, arr[i]/max_element = arr[max_index]
        and arr[i] % max_element = arr[i]
        This we have successfully stored two elements(i and max_index) at a single index of array

       Also, we can notice that even index contain maximum element and odd index contain minimum element

         */
        int n = input.length;
        int min_index = 0; //index for the next min element
        int max_index = n-1;

        int max_element = input[n-1] + 1;

        for(int i =0 ; i < n; i++){

            if(i%2 == 0){
                input[i] += (input[max_index]%max_element) * max_element;
                max_index--;

            }
            else{
                input[i] += (input[min_index]% max_element) * max_element;
                min_index++;
            }
        }

        for(int i = 0; i < n; i++){
            input[i] /= max_element;

        }

    }


}
