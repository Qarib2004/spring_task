package ExCollections.ex1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<HeavyBox>  heavyBoxes = new ArrayList<>();
        heavyBoxes.add(new HeavyBox(10));
        heavyBoxes.add(new HeavyBox(20));
        heavyBoxes.add(new HeavyBox(30));

        for(HeavyBox box:heavyBoxes){
            System.out.println(box);
        }

        heavyBoxes.get(0).setWeight(1);
        System.out.println("После изменения: ");
        for(HeavyBox box:heavyBoxes){
            System.out.println(box);
        }

        heavyBoxes.remove(heavyBoxes.size()-1);
        System.out.println("После удаления последнего: ");
        for(HeavyBox box:heavyBoxes){
            System.out.println(box);
        }

        HeavyBox[] array1 = heavyBoxes.toArray(new HeavyBox[0]);
        System.out.println("Массив созданный с помощью toArray: ");
        for(HeavyBox box:array1){
            System.out.println(box);
        }

        HeavyBox[] array2 = heavyBoxes.stream().toArray(HeavyBox[]::new);
        System.out.println("используем stream: ");
        for(HeavyBox box:array2){
            System.out.println(box);
        }

        HeavyBox[] array3 = new HeavyBox[heavyBoxes.size()];
        for(int i = 0;i < heavyBoxes.size();i++){
            array3[i] = heavyBoxes.get(i);
        }
        System.out.println("с помощью for: ");
        for(HeavyBox box:array3){
            System.out.println(box);
        }
    }
}
