package exerciseFromTeacher;

import java.util.ArrayList;
import java.util.List;

public class ExYoutube {
    public static void main(String[] args) {
       int[] array = new int[]{12,4,5,87,5,343,34,98,42};
       print(array);
        deleteElement(array,87);
        System.out.println("\n");
        print(array);
    }
    public static int[] deleteElement(int[] array,int element){
        int offset = 0;
        for(int i = 0;i< array.length;i++){
            if(array[i]==element){
                offset++;
            }else{
                array[i-offset] = array[i];
            }
        }
        int[] newArray = new int[array.length-offset];
        for(int i = 0;i< newArray.length;i++){
            newArray[i]=array[i];
        }
        return newArray;
    }
    public static void print(int[] array){
        for(int i = 0;i < array.length;i++){
            System.out.print(array[i] +" ");
        }
    }
}
