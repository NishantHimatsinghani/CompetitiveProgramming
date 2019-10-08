import java.util.ArrayList;

public class MobileNumberSubset {


    public boolean main_stuff(int[] input, int index, int remaining_sum, ArrayList<Integer> list){

        if(remaining_sum == 0) return true;

        if(index == input.length -1){

            if(remaining_sum !=0 && remaining_sum!= input[index]) return false;
            else if(remaining_sum == input[index]){
                list.add(input[index]);
                return true;
            }

        }

        if(input[index] > remaining_sum) return main_stuff(input, index + 1, remaining_sum, list);

        if(main_stuff(input, index +1, remaining_sum - input[index], list)){

            list.add(input[index]);
            return true;

        }
        else if(main_stuff(input, index + 1, remaining_sum, list)) return true;

        else return false;



    }


    public int[] remove_elements_of_list(int[] input, ArrayList<Integer> list){


        int[] temp = new int[input.length - list.size()];

        int index = 0;

        boolean found = false;
        int i;
        for(i = 0; i < input.length; i++){
            if(list.size() != 0){

                for(int j = 0; j < list.size() ; j++){
                    if(input[i] == list.get(j)){
                        found = true;
                        list.remove(j);
                        break;
                    }

                }
                if(!found) temp[index++] = input[i];
                else found = false;
            }
            else{
                break;
            }

        }

        while(i < input.length){

            temp[index++] = input[i++];

        }

        System.out.print("Output of remove_elements_of_list : ");print(temp);
        return temp;
    }


    public static void main(String[] args){
        int[] input = {1,2,3,4};
        int sum = 7;

        MobileNumberSubset s = new MobileNumberSubset();


        while(input.length !=0){

            ArrayList<Integer> empty_list = new ArrayList<Integer>();

            if(!s.main_stuff(input, 0, sum, empty_list)){

                break;
            }else {
                System.out.print("input : "); s.print(input);
                System.out.print("List : "); s.printList(empty_list);

                input = s.remove_elements_of_list(input, empty_list);

            }
        }

        int required_sum = 0;

        s.print(input);
        for(int i = 0; i < input.length; i++){

            required_sum += input[i];

        }
        System.out.println(required_sum);

}


public void print(int[] input){
        for( int i : input )System.out.print(i + " ");
        System.out.println();
        return;

}

    public void printList(ArrayList<Integer> input){
        for( int i : input )System.out.print(i + " ");
        System.out.println();
        return;

    }

}
