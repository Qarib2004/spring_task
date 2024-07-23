package exerciseFromTeacher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JoinCommon {
    public static void main(String[] args) {

        List<String> l1 = new ArrayList<>(Arrays.asList("apple", "orange", "banana", "cucumber"));
        List<String> l2 = new ArrayList<>(Arrays.asList("orange", "apple", "watermelon", "pear"));
        List<String> common = new ArrayList<>();
        for (String l : l1) {
            if (l2.contains(l)) {
                common.add(l);
            }
        }
        System.out.println(common);
    }

}
