import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListDemo {
    public static void main(String[] args) {
        int[] numbers1 = new int[5];
        numbers1[0]=10;
        numbers1[1]=20;
        numbers1[2]=30;
        numbers1[3]=40;
        numbers1[4]=50;
       ArrayList<Integer> numbers2= new ArrayList<>();
       numbers2.add(12); // 0
       numbers2.add(13); // 1
       numbers2.add(30); // 2
       numbers2.add(15); // 3
       numbers2.add(16); // 4


       for (int i=0;i<numbers1.length;i++){
           System.out.println(numbers1[i]);
       }
       for (int i: numbers1){
           System.out.println(i);
       }

       for (int i=0;i<numbers2.size();i++){
           System.out.println(numbers2.get(i));
       }
       for (Integer i: numbers2){
           System.out.println(numbers2.get(i));
       }
       // auto unboxing is also possible in enhancing for loop
        for (int i:numbers2){
            System.out.println(i);
        }
        System.out.println(Arrays.toString(numbers1));
        System.out.println(numbers2);
        numbers2.set(1,15);

        // since ArrayLists are dynamic we can append elements after creation
        numbers2.set(1,15);
        System.out.println(numbers2);
        numbers2.add(10);
        System.out.println(numbers2);
        numbers2.add(2,23);
        System.out.println(numbers2);
        numbers2.add(0,5);
        System.out.println(numbers2);
        numbers2.remove(5);

        // Remmoving 30 from the array list directlly
        numbers2.remove(Integer.valueOf(30));
        System.out.println(numbers2);
        numbers2.add(40);
        numbers2.add(50);
        numbers2.add(30);
        numbers2.add(60);
        numbers2.add(30);

        numbers2.remove(5);
       // numbers2.remove(thirty2);

//        for (int i=0;i<numbers2.size();i++){
//            System.out.println(numbers2.get(i));
//        }
//        for (Integer integer:numbers2){
//            System.out.println(integer);
//        }

        // Instead of the above two methods of listing out all the elements we can use the below method as a short han
        numbers2.forEach(System.out::println);

        numbers2.clear(); // clear everything

        System.out.println(numbers2.contains(15));
        System.out.println(numbers2.contains(30));

    }
}
