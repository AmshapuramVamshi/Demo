package IntegerPrograms;

import java.util.Arrays;

public class AssendingDesendingOrder {
    public static void main(String[] args){
        int[] values = {2,5,3,7,9,1,4,8};
        int temp =0;
        for(int i=0; i<values.length; i++){
            for(int j=i+1; j<values.length; j++){
                if(values[i] < values[j]){
                    temp = values[i];
                    values[i] = values[j];
                    values[j] =temp;
                }
            }
        }
        System.out.println(Arrays.toString(values));
    }
}
