package IntegerPrograms;

public class SumOfArray {
    public static void main(String[] args){
        int[] array = {2,43,56,7,9,34,89};
        int length = array.length;
        int sum =0;

        for (int i =0; i<length; i++){
            sum = sum + array[i];
        }
        System.out.println(sum);
    }
}
