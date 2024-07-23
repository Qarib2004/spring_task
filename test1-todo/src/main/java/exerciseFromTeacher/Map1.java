package exerciseFromTeacher;

import java.util.*;

public class Map1 {
    public static void main(String[] args) {
//        Map<Integer,String> map = new HashMap<>();
//        map.put(null,"qarib");
//        System.out.println(map);
//        HashMap<Integer,String> linkedHashMap = new LinkedHashMap<>();
//        linkedHashMap.put(null,"qarib");
//        System.out.println(linkedHashMap);
//
//        TreeMap<Integer,String > treeMap = new TreeMap<>();
//        treeMap.put(1,"Qerib");
//        System.out.println(treeMap);
//
//        Hashtable<Integer,String> hashtable = new Hashtable<>();
//        hashtable.put(1,"Qerib");


        HashSet<String> hashSet = new HashSet<>();
        hashSet.add(null);
        System.out.println(hashSet);

        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add(null);
        System.out.println(lhs);

        TreeSet<String> ts = new TreeSet<>();
        ts.add("qari");
        System.out.println(ts);

        //EnumSet<Integer> es = new HashSet<>();
    }
}
