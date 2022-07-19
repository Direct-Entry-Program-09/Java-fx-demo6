import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class ArrayListDemo2 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers1=new ArrayList<>();
        numbers1.add(10);
        numbers1.add(20);
        numbers1.add(30);
        numbers1.add(40);

        ArrayList<Integer> numbers2=new ArrayList<>();
        numbers2.add(25);
        numbers2.add(20);
        numbers2.add(59);
        numbers2.add(89);

        System.out.println(numbers1);
        numbers1.addAll(numbers2);

        for (Integer number:numbers2){
            numbers1.add(number);
        }
        System.out.println(numbers1);

        /* Arrays.sort => Collection.sort*/
        Collections.sort(numbers1);
        System.out.println(numbers1);

        // Arraylist<Integer> numbers=(ArrayList<Integer>) Arrays.asList(23,45,76,89);
    }
}
